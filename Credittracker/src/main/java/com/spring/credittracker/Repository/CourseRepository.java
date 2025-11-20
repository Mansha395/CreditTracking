package com.spring.credittracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.credittracker.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	Course findByCourseCode(String courseCode);

}
