package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {

        courses.add(course);

    }

    public ArrayList<Course> getAllCourses() {

        return courses;

    }

    public Course findCourseById(int id)
            throws EntityNotFoundException {

        for (Course course : courses) {

            if (course.getId() == id) {

                return course;

            }

        }

        throw new EntityNotFoundException(
                "Course not found."
        );

    }

    public void changeCourseStatus(int id, boolean active)
            throws EntityNotFoundException {

        Course course = findCourseById(id);

        course.setActive(active);

    }

    public void listCourses() {

        if (courses.isEmpty()) {

            System.out.println("No courses available.");

            return;

        }

        for (Course course : courses) {

            System.out.println("---------------------------");

            System.out.println(course);

        }

    }

}