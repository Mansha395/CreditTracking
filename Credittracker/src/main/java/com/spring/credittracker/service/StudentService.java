package com.spring.credittracker.service;

import java.util.Optional;

import com.spring.credittracker.model.Student;

public interface StudentService {
	Student addStudent(Student student);
    java.util.List<Student> getAllStudents();
    Optional<Student> getStudentByRollNumber(String rollNumber);
    Student updateCredits(Long studentId, int credits);
	boolean canRegisterSubject(Long studentId, int credits);
	Object getStudentRepository();

}
