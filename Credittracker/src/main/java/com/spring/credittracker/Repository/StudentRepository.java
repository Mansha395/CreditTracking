package com.spring.credittracker.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.credittracker.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findByRollNumber(String rollNumber);

}