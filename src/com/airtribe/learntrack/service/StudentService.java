package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    // Method Overloading
    public void addStudent(ArrayList<Student> list) {
        students.addAll(list);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student findStudentById(int id)
            throws EntityNotFoundException {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }

        }

        throw new EntityNotFoundException(
                "Student with ID " + id + " not found."
        );
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

        if (students.isEmpty()) {

            System.out.println("No students available.");

            return;
        }

        for (Student student : students) {

            System.out.println("---------------------------");

            System.out.println(student);

        }

    }

}