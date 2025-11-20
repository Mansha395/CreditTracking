package com.spring.credittracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.credittracker.Repository.CourseRepository;
import com.spring.credittracker.Repository.EnrollmentRepository;
import com.spring.credittracker.Repository.StudentRepository;
import com.spring.credittracker.model.Enrollment;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{


    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        // Fetch the managed (persistent) Student and Course
        var student = studentRepository.findById(enrollment.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + enrollment.getStudent().getId()));

        var course = courseRepository.findById(enrollment.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + enrollment.getCourse().getId()));

        // Replace detached entities with managed ones
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        // Now safely save
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment) {
        return enrollmentRepository.findById(id).map(enrollment -> {
            var student = studentRepository.findById(updatedEnrollment.getStudent().getId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            var course = courseRepository.findById(updatedEnrollment.getCourse().getId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setGrade(updatedEnrollment.getGrade());

            return enrollmentRepository.save(enrollment);
        }).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public CourseRepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


}
