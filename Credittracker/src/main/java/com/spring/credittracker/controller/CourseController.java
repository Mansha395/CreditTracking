package com.spring.credittracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

import com.spring.credittracker.dto.CourseDTO;
import com.spring.credittracker.mapper.CourseMapper;
import com.spring.credittracker.model.Course;
import com.spring.credittracker.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200") // for Angular connection


public class CourseController {
	
	@Autowired
    private CourseService courseService;
	
	@PostMapping
	 public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        Course course = CourseMapper.toEntity(courseDTO);
        Course savedCourse = courseService.saveCourse(course);
        return CourseMapper.toDTO(savedCourse);
    }
	
	
	@GetMapping
	public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return courses.stream()
            .map(CourseMapper::toDTO)
            .collect(Collectors.toList());
    }
	
	@GetMapping("/{id}")
	  public CourseDTO getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id)
            .orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseMapper.toDTO(course);
    }
	
	@PutMapping("/{id}")
	  public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO updatedCourseDTO) {
        Course updatedCourse = CourseMapper.toEntity(updatedCourseDTO);
        Course course = courseService.updateCourse(id, updatedCourse);
        return ResponseEntity.ok(CourseMapper.toDTO(course));
    }
	
	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully";
    }



}
