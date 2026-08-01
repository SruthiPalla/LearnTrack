package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.List;

public class CourseService {

    private final CourseRepository repository = new CourseRepository();

    public void addCourse(Course course) {
        repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course findCourseById(int id)
            throws EntityNotFoundException {

        Course course = repository.findById(id);

        if (course == null) {
            throw new EntityNotFoundException(
                    "Course with ID " + id + " not found.");
        }

        return course;
    }

    public void updateCourseStatus(int id, boolean active)
            throws EntityNotFoundException {

        Course course = findCourseById(id);

        course.setActive(active);
    }

    public void listCourses() {

        List<Course> courses = repository.findAll();

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses) {
            System.out.println("----------------------------");
            System.out.println(course);
        }
    }
}