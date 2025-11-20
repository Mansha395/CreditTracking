package com.spring.credittracker.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.spring.credittracker.dto.EnrollmentDTO;
import com.spring.credittracker.mapper.EnrollmentMapper;
import com.spring.credittracker.model.Enrollment;
import com.spring.credittracker.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "http://localhost:4200")
public class EnrollmentController {
	

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentDTO addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = EnrollmentMapper.toEntity(enrollmentDTO, null, null);
        Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);
        return EnrollmentMapper.toDTO(savedEnrollment);
    }
    

    @GetMapping
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return enrollments.stream()
            .map(EnrollmentMapper::toDTO)
            .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public EnrollmentDTO getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return EnrollmentMapper.toDTO(enrollment);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentDTO updatedEnrollmentDTO) {
        Enrollment updatedEnrollment = EnrollmentMapper.toEntity(updatedEnrollmentDTO, null, null);
        Enrollment enrollment = enrollmentService.updateEnrollment(id, updatedEnrollment);
        return ResponseEntity.ok(EnrollmentMapper.toDTO(enrollment));
    }
    
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return "Enrollment deleted successfully";
    }

}
