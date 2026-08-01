package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository repository = new StudentRepository();

    public void addStudent(Student student) {
        repository.save(student);
    }

    // Method Overloading
    public void addStudent(List<Student> students) {
        for (Student student : students) {
            repository.save(student);
        }
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student findStudentById(int id)
            throws EntityNotFoundException {

        Student student = repository.findById(id);

        if (student == null) {
            throw new EntityNotFoundException(
                    "Student with ID " + id + " not found.");
        }

        return student;
    }

    public void deactivateStudent(int id)
            throws EntityNotFoundException {

        Student student = findStudentById(id);

        student.setActive(false);
    }

    public void updateStudentEmail(int id, String email)
            throws EntityNotFoundException {

        Student student = findStudentById(id);

        student.setEmail(email);
    }

    public void listStudents() {

        List<Student> students = repository.findAll();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println("----------------------------");
            System.out.println(student);
        }
    }
}