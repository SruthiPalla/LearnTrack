package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment() {
    }

    public Enrollment(int id,
                      int studentId,
                      int courseId,
                      LocalDate enrollmentDate,
                      EnrollmentStatus status) {

        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "\nEnrollment ID : " + id +
                "\nStudent ID : " + studentId +
                "\nCourse ID : " + courseId +
                "\nDate : " + enrollmentDate +
                "\nStatus : " + status;
    }

}