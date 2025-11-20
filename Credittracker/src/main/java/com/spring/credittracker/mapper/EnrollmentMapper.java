package com.spring.credittracker.mapper;

import com.spring.credittracker.dto.EnrollmentDTO;
import com.spring.credittracker.model.Course;
import com.spring.credittracker.model.Enrollment;
import com.spring.credittracker.model.Student;

public class EnrollmentMapper {
	public static EnrollmentDTO toDTO(Enrollment enrollment) {
		if (enrollment == null) return null;
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setGrade(enrollment.getGrade());
        dto.setCourseId(enrollment.getCourse() != null ? enrollment.getCourse().getId() : null);
        dto.setStudentId(enrollment.getStudent() != null ? enrollment.getStudent().getId() : null);
        return dto;
    }

    public static Enrollment toEntity(EnrollmentDTO dto, Student student, Course course) {
    	if (dto == null) return null;
        Enrollment enrollment = new Enrollment();
        enrollment.setId(dto.getId());
        enrollment.setGrade(dto.getGrade());
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollment;
    }

}
