package com.spring.credittracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.credittracker.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}
