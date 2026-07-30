package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments =
            new ArrayList<>();

    public void enrollStudent(Enrollment enrollment) {

        enrollments.add(enrollment);

    }

    public void listEnrollments() {

        if (enrollments.isEmpty()) {

            System.out.println("No enrollments found.");

            return;

        }

        for (Enrollment enrollment : enrollments) {

            System.out.println("-----------------------");

            System.out.println(enrollment);

        }

    }

    public void viewStudentEnrollments(int studentId) {

        boolean found = false;

        for (Enrollment enrollment : enrollments) {

            if (enrollment.getStudentId() == studentId) {

                System.out.println(enrollment);

                found = true;

            }

        }

        if (!found) {

            System.out.println("No enrollments found.");

        }

    }

    public void updateStatus(int enrollmentId,
                             String status) {

        for (Enrollment enrollment : enrollments) {

            if (enrollment.getId() == enrollmentId) {

                enrollment.setStatus(status);

                break;

            }

        }

    }

}