package com.spring.credittracker.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.credittracker.dto.StudentDTO;
import com.spring.credittracker.mapper.StudentMapper;
import com.spring.credittracker.model.Student;
import com.spring.credittracker.service.StudentService;


@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")

public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

	public StudentService getStudentService() {
		return studentService;
	}
	
	 @PostMapping
	 public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
		 Student student = StudentMapper.toEntity(studentDTO);
	        Student savedStudent = studentService.addStudent(student);
	        StudentDTO responseDTO = StudentMapper.toDTO(savedStudent);
	        return ResponseEntity.ok(responseDTO);
	    
	    }
	 @GetMapping
	 public ResponseEntity<List<StudentDTO>> getAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        List<StudentDTO> dtos = students.stream()
	            .map(StudentMapper::toDTO)
	            .collect(Collectors.toList());
	        return ResponseEntity.ok(dtos);
	    }

	 @GetMapping("/{rollNumber}")
	 public ResponseEntity<StudentDTO> getStudentByRollNumber(@PathVariable String rollNumber) {
	        return studentService.getStudentByRollNumber(rollNumber)
	            .map(student -> ResponseEntity.ok(StudentMapper.toDTO(student)))
	            .orElse(ResponseEntity.notFound().build());
	    }
	 
	 
	 @PutMapping("/{id}/credits/{credits}")
	 public ResponseEntity<StudentDTO> updateCredits(@PathVariable Long id, @PathVariable int credits) {
		    Student updatedStudent = studentService.updateCredits(id, credits); // Service returns entity
		    StudentDTO responseDTO = StudentMapper.toDTO(updatedStudent); // Convert Entity to DTO
		    return ResponseEntity.ok(responseDTO);
	    }
}
