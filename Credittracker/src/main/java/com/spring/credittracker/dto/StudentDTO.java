package com.spring.credittracker.dto;


import lombok.Data;
@Data


public class StudentDTO {
	

	    private Long id;
	    private String rollNumber;
	    private String name;
	    private String department;
	    private int semester;
	    private int creditsEarned;
	    // If you want to show enrollments:
	    // private List<EnrollmentDTO> enrollments;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRollNumber() {
			return rollNumber;
		}
		public void setRollNumber(String rollNumber) {
			this.rollNumber = rollNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public int getSemester() {
			return semester;
		}
		public void setSemester(int semester) {
			this.semester = semester;
		}
		public int getCreditsEarned() {
			return creditsEarned;
		}
		public void setCreditsEarned(int creditsEarned) {
			this.creditsEarned = creditsEarned;
		}
	    
	    


}
