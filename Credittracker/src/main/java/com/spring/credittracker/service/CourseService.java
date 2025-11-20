package com.spring.credittracker.service;

import java.util.Optional;
import java.util.List;

import com.spring.credittracker.model.Course;

public interface CourseService 
{
	Course saveCourse(Course course);
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course updateCourse(Long id, Course updatedCourse);
    void deleteCourse(Long id);

}
