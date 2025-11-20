package com.spring.credittracker.dto;

import lombok.Data;

@Data
public class EnrollmentRegistrationDTO {
	
	
	    private Long studentId;
	    private Long courseId;
	    private String grade; // Optional, if assigning at registration
		public Long getStudentId() {
			return studentId;
		}
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}
		public Long getCourseId() {
			return courseId;
		}
		public void setCourseId(Long courseId) {
			this.courseId = courseId;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
	

}
