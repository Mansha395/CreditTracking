package com.spring.credittracker.service;

import java.util.List;
import java.util.Optional;

import com.spring.credittracker.model.Enrollment;

public interface EnrollmentService {
	  Enrollment saveEnrollment(Enrollment enrollment);
	    List<Enrollment> getAllEnrollments();
	    Optional<Enrollment> getEnrollmentById(Long id);
	    Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment);
	    void deleteEnrollment(Long id);

}
