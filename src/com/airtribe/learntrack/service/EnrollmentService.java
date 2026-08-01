package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository repository =
            new EnrollmentRepository();

    public void enrollStudent(Enrollment enrollment) {
        repository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    public void viewStudentEnrollments(int studentId) {

        List<Enrollment> enrollments =
                repository.findByStudentId(studentId);

        if (enrollments.isEmpty()) {

            System.out.println("No enrollments found.");

            return;
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println("----------------------------");
            System.out.println(enrollment);
        }
    }

    public void updateStatus(int enrollmentId,
                             EnrollmentStatus status) {

        Enrollment enrollment =
                repository.findById(enrollmentId);

        if (enrollment != null) {
            enrollment.setStatus(status);
        } else {
            System.out.println("Enrollment not found.");
        }
    }

    public void listEnrollments() {

        List<Enrollment> enrollments =
                repository.findAll();

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments available.");
            return;
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println("----------------------------");
            System.out.println(enrollment);
        }
    }
}