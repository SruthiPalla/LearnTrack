package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("      LEARNTRACK SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Activate/Deactivate Course");
            System.out.println("8. Enroll Student");
            System.out.println("9. View Student Enrollments");
            System.out.println("10. Update Enrollment Status");
            System.out.println("0. Exit");
            System.out.print("Enter Choice : ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        studentService.listStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        deactivateStudent();
                        break;

                    case 5:
                        addCourse();
                        break;

                    case 6:
                        courseService.listCourses();
                        break;

                    case 7:
                        updateCourseStatus();
                        break;

                    case 8:
                        enrollStudent();
                        break;

                    case 9:
                        viewStudentEnrollments();
                        break;

                    case 10:
                        updateEnrollmentStatus();
                        break;

                    case 0:
                        System.out.println("Thank you for using LearnTrack.");
                        break;

                    default:
                        System.out.println("Invalid Option.");

                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

                choice = -1;

            } catch (Exception e) {

                System.out.println(e.getMessage());

                choice = -1;

            }

        } while (choice != 0);

    }

    private static void addStudent() {

        System.out.print("First Name : ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name : ");
        String lastName = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        System.out.print("Batch : ");
        String batch = scanner.nextLine();

        Student student = new Student(
                IdGenerator.getNextStudentId(),
                firstName,
                lastName,
                email,
                batch,
                true
        );

        studentService.addStudent(student);

        System.out.println("Student Added Successfully.");

    }

    private static void searchStudent() {

        try {

            System.out.print("Enter Student ID : ");

            int id = Integer.parseInt(scanner.nextLine());

            Student student = studentService.findStudentById(id);

            System.out.println(student);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    private static void deactivateStudent() {

        try {

            System.out.print("Student ID : ");

            int id = Integer.parseInt(scanner.nextLine());

            studentService.deactivateStudent(id);

            System.out.println("Student Deactivated.");

        } catch (EntityNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void addCourse() {

        System.out.print("Course Name : ");
        String name = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        System.out.print("Duration (Weeks) : ");
        int duration = Integer.parseInt(scanner.nextLine());

        Course course = new Course(
                IdGenerator.getNextCourseId(),
                name,
                description,
                duration,
                true
        );

        courseService.addCourse(course);

        System.out.println("Course Added.");

    }

    private static void updateCourseStatus() {

        try {

            System.out.print("Course ID : ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Activate? (true/false): ");
            boolean active = Boolean.parseBoolean(scanner.nextLine());

            courseService.changeCourseStatus(id, active);

            System.out.println("Course Updated.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    private static void enrollStudent() {

        try {

            System.out.print("Student ID : ");
            int studentId = Integer.parseInt(scanner.nextLine());

            System.out.print("Course ID : ");
            int courseId = Integer.parseInt(scanner.nextLine());

            Enrollment enrollment = new Enrollment(
                    IdGenerator.getNextEnrollmentId(),
                    studentId,
                    courseId,
                    LocalDate.now().toString(),
                    "ACTIVE"
            );

            enrollmentService.enrollStudent(enrollment);

            System.out.println("Enrollment Successful.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    private static void viewStudentEnrollments() {

        System.out.print("Student ID : ");

        int studentId = Integer.parseInt(scanner.nextLine());

        enrollmentService.viewStudentEnrollments(studentId);

    }

    private static void updateEnrollmentStatus() {

        System.out.print("Enrollment ID : ");

        int enrollmentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Status (ACTIVE/COMPLETED/CANCELLED): ");

        String status = scanner.nextLine().toUpperCase();

        enrollmentService.updateStatus(enrollmentId, status);

        System.out.println("Status Updated.");

    }

}