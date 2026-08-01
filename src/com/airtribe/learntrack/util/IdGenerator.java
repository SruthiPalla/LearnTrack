package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int studentId = 1001;
    private static int courseId = 501;
    private static int enrollmentId = 1;

    private IdGenerator() {
    }

    public static int generateStudentId() {
        return studentId++;
    }

    public static int generateCourseId() {
        return courseId++;
    }

    public static int generateEnrollmentId() {
        return enrollmentId++;
    }
}