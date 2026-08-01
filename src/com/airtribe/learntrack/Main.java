package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService =
            new StudentService();

    private static final CourseService courseService =
            new CourseService();

    private static final EnrollmentService enrollmentService =
            new EnrollmentService();

    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case MenuOptions.ADD_STUDENT:
                        addStudent();
                        break;

                    case MenuOptions.VIEW_STUDENTS:
                        studentService.listStudents();
                        break;

                    case MenuOptions.SEARCH_STUDENT:
                        searchStudent();
                        break;

                    case MenuOptions.DEACTIVATE_STUDENT:
                        deactivateStudent();
                        break;

                    case MenuOptions.ADD_COURSE:
                        addCourse();
                        break;

                    case MenuOptions.VIEW_COURSES:
                        courseService.listCourses();
                        break;

                    case MenuOptions.UPDATE_COURSE:
                        updateCourseStatus();
                        break;

                    case MenuOptions.ENROLL_STUDENT:
                        enrollStudent();
                        break;

                    case MenuOptions.VIEW_ENROLLMENTS:
                        viewStudentEnrollments();
                        break;

                    case MenuOptions.UPDATE_ENROLLMENT:
                        updateEnrollmentStatus();
                        break;

                    case MenuOptions.EXIT:
                        System.out.println("\nThank you for using LearnTrack.");
                        break;

                    default:
                        System.out.println("\nInvalid Choice.");

                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

                choice = -1;

            } catch (Exception e) {

                System.out.println(e.getMessage());

                choice = -1;

            }

        } while (choice != MenuOptions.EXIT);

    }

    private static void displayMenu() {

        System.out.println("\n================================");
        System.out.println("      LEARNTRACK SYSTEM");
        System.out.println("================================");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Deactivate Student");

        System.out.println("5. Add Course");
        System.out.println("6. View Courses");
        System.out.println("7. Update Course Status");

        System.out.println("8. Enroll Student");
        System.out.println("9. View Student Enrollments");
        System.out.println("10. Update Enrollment Status");

        System.out.println("0. Exit");

        System.out.print("\nEnter Choice : ");

    }

    private static void addStudent() {

        System.out.print("First Name : ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name : ");
        String lastName = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        if (!InputValidator.isValidEmail(email)) {

            System.out.println("Invalid Email.");

            return;

        }

        System.out.print("Batch : ");
        String batch = scanner.nextLine();

        Student student = new Student(

                IdGenerator.generateStudentId(),

                firstName,

                lastName,

                email,

                batch,

                true

        );

        studentService.addStudent(student);

        System.out.println("\nStudent Added Successfully.");

    }

    private static void searchStudent() {

        try {

            System.out.print("Enter Student ID : ");

            int id = Integer.parseInt(scanner.nextLine());

            Student student =
                    studentService.findStudentById(id);

            System.out.println(student);

        } catch (EntityNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void deactivateStudent() {

        try {

            System.out.print("Student ID : ");

            int id = Integer.parseInt(scanner.nextLine());

            studentService.deactivateStudent(id);

            System.out.println("Student Deactivated.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    private static void addCourse() {

        System.out.print("Course Name : ");
        String courseName = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        System.out.print("Duration (Weeks) : ");
        int duration = Integer.parseInt(scanner.nextLine());

        Course course = new Course(
                IdGenerator.generateCourseId(),
                courseName,
                description,
                duration,
                true
        );

        courseService.addCourse(course);

        System.out.println("\nCourse Added Successfully.");
    }

    private static void updateCourseStatus() {

        try {

            System.out.print("Course ID : ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Activate Course? (true/false): ");
            boolean active = Boolean.parseBoolean(scanner.nextLine());

            courseService.updateCourseStatus(id, active);

            System.out.println("Course status updated successfully.");

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
                    IdGenerator.generateEnrollmentId(),
                    studentId,
                    courseId,
                    LocalDate.now(),
                    EnrollmentStatus.ACTIVE
            );

            enrollmentService.enrollStudent(enrollment);

            System.out.println("Student enrolled successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    private static void viewStudentEnrollments() {

        try {

            System.out.print("Enter Student ID : ");

            int studentId = Integer.parseInt(scanner.nextLine());

            enrollmentService.viewStudentEnrollments(studentId);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    private static void updateEnrollmentStatus() {

        try {

            System.out.print("Enrollment ID : ");
            int enrollmentId = Integer.parseInt(scanner.nextLine());

            System.out.println("\nSelect Status");
            System.out.println("1. ACTIVE");
            System.out.println("2. COMPLETED");
            System.out.println("3. CANCELLED");
            System.out.print("Enter Choice : ");

            int option = Integer.parseInt(scanner.nextLine());

            EnrollmentStatus status;

            switch (option) {

                case 1:
                    status = EnrollmentStatus.ACTIVE;
                    break;

                case 2:
                    status = EnrollmentStatus.COMPLETED;
                    break;

                case 3:
                    status = EnrollmentStatus.CANCELLED;
                    break;

                default:
                    System.out.println("Invalid Status.");
                    return;
            }

            enrollmentService.updateStatus(enrollmentId, status);

            System.out.println("Enrollment status updated successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}