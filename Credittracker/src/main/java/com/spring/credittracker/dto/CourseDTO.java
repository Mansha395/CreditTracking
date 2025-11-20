package com.spring.credittracker.dto;

import lombok.Data;
@Data
public class CourseDTO {

	
	    private Long id;
	    private String courseCode;
	    private String courseName;
	    private int credits;
	    // If needed, add a List<Long> enrollmentIds or List<EnrollmentDTO> enrollments
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCourseCode() {
			return courseCode;
		}
		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public int getCredits() {
			return credits;
		}
		public void setCredits(int credits) {
			this.credits = credits;
		}

}
