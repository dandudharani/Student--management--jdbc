package com.example.student.controller;

import com.example.student.dao.StudentDAO;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentDAO studentDAO;

    public StudentController(StudentService studentService, StudentDAO studentDAO) {
        this.studentService = studentService;
        this.studentDAO = studentDAO;
    }

    @GetMapping("/db-status")
    public ResponseEntity<String> databaseStatus() {
        if (studentDAO.testConnection()) {
            return ResponseEntity.ok("MySQL database connection is successful.");
        }
        return ResponseEntity.status(500)
                .body("MySQL database connection failed. Check DB_URL, DB_USERNAME, DB_PASSWORD and MySQL.");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws SQLException {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
            throws SQLException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) throws SQLException {

        if (studentService.updateStudent(id, student)) {
            return ResponseEntity.ok("Student updated successfully");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id)
            throws SQLException {

        if (studentService.deleteStudent(id)) {
            return ResponseEntity.ok("Student deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}
