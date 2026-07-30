# LearnTrack - Student & Course Management System

## Project Description

LearnTrack is a console-based Student & Course Management System developed using Core Java.

The application allows administrators to:

- Add and manage students
- Add and manage courses
- Enroll students into courses
- View student enrollments
- Update enrollment status
- Activate/Deactivate students and courses

This project demonstrates the fundamentals of Core Java, Object-Oriented Programming (OOP), Collections, Exception Handling, and Menu-Driven Console Applications.

---

## Technologies Used

- Java (JDK 21 or your installed version)
- Core Java
- ArrayList
- OOP Concepts
- Exception Handling

---

## Project Structure

```
src/
└── com.airtribe.learntrack
    ├── entity
    ├── service
    ├── util
    ├── exception
    └── ui
```

---

## Features

### Student Management

- Add Student
- View Students
- Search Student by ID
- Deactivate Student

### Course Management

- Add Course
- View Courses
- Activate/Deactivate Course

### Enrollment Management

- Enroll Student
- View Student Enrollments
- Update Enrollment Status

---

## OOP Concepts Used

- Classes & Objects
- Encapsulation
- Inheritance
- Polymorphism
- Constructor Overloading
- Static Members

---

## Collections Used

- ArrayList

---

## Exception Handling

- Custom Exception
- try-catch blocks
- Input validation

---

## Compile & Run

Compile

```bash
javac com/airtribe/learntrack/ui/Main.java
```

Run

```bash
java com.airtribe.learntrack.ui.Main
```

---

## Class Diagram

```
                Person
                   ▲
          ------------------
          |                |
      Student          Trainer

Student -------- Enrollment -------- Course
```

---

## Author

Sruthi

#Project submitted successfully.
