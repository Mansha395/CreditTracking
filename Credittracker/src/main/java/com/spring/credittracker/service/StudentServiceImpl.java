package com.spring.credittracker.service;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.spring.credittracker.Repository.StudentRepository;
import com.spring.credittracker.model.Student;



@Service
public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public java.util.List<Student> getAllStudents() {
	    return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentByRollNumber(String rollNumber) {
		// TODO Auto-generated method stub
		 return studentRepository.findByRollNumber(rollNumber);
	}

	@Override
	public Student updateCredits(Long studentId, int credits) {
		// TODO Auto-generated method stub
		 Student student = studentRepository.findById(studentId)
		            .orElseThrow(() -> new RuntimeException("Student not found"));
		    student.setCreditsEarned(credits); // Use correct setter
		    return studentRepository.save(student);
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	@Override
	public boolean canRegisterSubject(Long studentId, int credits) {
		// TODO Auto-generated method stub
		return false;
	}

}
