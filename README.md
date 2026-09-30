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


## Backend + MySQL connection

The backend is already connected to MySQL through JDBC.

Flow:

Frontend (HTML/CSS/JS)
→ Spring Boot REST Controller
→ Service
→ StudentDAO
→ JDBC
→ MySQL `college` database
→ `students` table

### 1. Create the database

Open MySQL Workbench or MySQL command line and run:

```sql
SOURCE database/schema.sql;
```

Or copy and run the contents of `database/schema.sql`.

### 2. Configure MySQL login

For local MySQL with the default `root` username and an empty password, the project works with the default settings.

If your MySQL has a password, set:

```text
DB_URL=jdbc:mysql://localhost:3306/college
DB_USERNAME=root
DB_PASSWORD=YOUR_PASSWORD
```

Do not put a real password in a public GitHub repository.

### 3. Start the backend

From the `backend` folder:

```bash
mvn spring-boot:run
```

Open:

```text
http://localhost:8080
```

### 4. Test the database connection

Open:

```text
http://localhost:8080/api/students/db-status
```

A successful connection returns:

```text
MySQL database connection is successful.
```


## Online deployment note

For an online deployment, `localhost` refers to the cloud server, not your phone or laptop.
Therefore, create a cloud MySQL database and set these environment variables on the backend host:

`DB_URL`
`DB_USERNAME`
`DB_PASSWORD`

The database must contain the `college` database and `students` table from `database/schema.sql`.
