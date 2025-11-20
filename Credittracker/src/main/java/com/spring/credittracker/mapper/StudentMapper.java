package com.spring.credittracker.mapper;

import com.spring.credittracker.dto.StudentDTO;
import com.spring.credittracker.model.Student;

public class StudentMapper {
	

	public static StudentDTO toDTO(Student student) {
		
		if (student == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setRollNumber(student.getRollNumber());
        dto.setName(student.getName());
        dto.setDepartment(student.getDepartment());
        dto.setSemester(student.getSemester());
        dto.setCreditsEarned(student.getCreditsEarned());
        // Optionally: map enrollments if needed (e.g., dto.setEnrollments(...))
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
    	if (dto == null) return null;
        Student student = new Student();
        student.setId(dto.getId());
        student.setRollNumber(dto.getRollNumber());
        student.setName(dto.getName());
        student.setDepartment(dto.getDepartment());
        student.setSemester(dto.getSemester());
        student.setCreditsEarned(dto.getCreditsEarned());
        // Optionally: map enrollments if needed (e.g., student.setEnrollments(...))
        return student;
    }
}
