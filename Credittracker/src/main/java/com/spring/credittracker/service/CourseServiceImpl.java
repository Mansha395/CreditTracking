package com.spring.credittracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.spring.credittracker.Repository.CourseRepository;
import com.spring.credittracker.model.Course;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public Optional<Course> getCourseById(Long id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id);
	}

	@Override
	public Course updateCourse(Long id, Course updatedCourse) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id).map(course -> {
            course.setCourseCode(updatedCourse.getCourseCode());
            course.setCourseName(updatedCourse.getCourseName());
            course.setCredits(updatedCourse.getCredits());
            return courseRepository.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
	}

	@Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

	@Override
	public List getAllCourses() {
		// TODO Auto-generated method stub
		return (List) courseRepository.findAll();
	}
	
}
