# Student Management System

A beginner-friendly Java Full Stack application using:

- HTML, CSS, JavaScript
- Spring Boot
- MVC architecture
- REST Controller
- JDBC
- MySQL
- Maven

## Architecture

Frontend → REST Controller → Service → DAO → JDBC → MySQL

## Project structure

```text
student-management-jdbc/
├── backend/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/com/example/student/
│           │   ├── StudentApplication.java
│           │   ├── controller/StudentController.java
│           │   ├── dao/StudentDAO.java
│           │   ├── model/Student.java
│           │   └── service/StudentService.java
│           └── resources/
│               ├── application.properties
│               └── static/
│                   ├── index.html
│                   ├── style.css
│                   └── script.js
├── database/
│   └── schema.sql
└── .gitignore
```

## 1. Create the database

Open MySQL and run `database/schema.sql`.

## 2. Configure MySQL

Set environment variables before running the application:

```text
DB_URL=jdbc:mysql://localhost:3306/college
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
```

Or edit `backend/src/main/resources/application.properties` for local practice. Do not commit real passwords to GitHub.

## 3. Run the application

Open a terminal inside `backend`:

```bash
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080
```

## API endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/students` | View all students |
| POST | `/api/students` | Add student |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

## GitHub

This repository contains source code. GitHub Pages cannot run the Spring Boot/JDBC/MySQL backend. For a live full-stack deployment, deploy the backend and database on a server/cloud platform separately.
