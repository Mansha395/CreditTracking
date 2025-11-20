package com.spring.credittracker.mapper;

import com.spring.credittracker.dto.CourseDTO;
import com.spring.credittracker.model.Course;

public class CourseMapper {
	public static CourseDTO toDTO(Course course) {
		if (course == null) return null;
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseCode(course.getCourseCode());
        dto.setCourseName(course.getCourseName());
        dto.setCredits(course.getCredits());
        return dto;
    }

    public static Course toEntity(CourseDTO dto) {
    	if (dto == null) return null;
        Course course = new Course();
        course.setId(dto.getId());
        course.setCourseCode(dto.getCourseCode());
        course.setCourseName(dto.getCourseName());
        course.setCredits(dto.getCredits());
        return course;
    }

}
