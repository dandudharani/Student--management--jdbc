package com.example.student.service;

import com.example.student.dao.StudentDAO;
import com.example.student.model.Student;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.findAll();
    }

    public Student addStudent(Student student) throws SQLException {
        return studentDAO.save(student);
    }

    public boolean updateStudent(int id, Student student) throws SQLException {
        return studentDAO.update(id, student);
    }

    public boolean deleteStudent(int id) throws SQLException {
        return studentDAO.delete(id);
    }
}
