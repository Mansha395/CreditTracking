package com.spring.credittracker.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")




public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;

    private String rollNumber;
    private String name;
    private String department;
    private int semester;
    
    private int creditsEarned;
	
	
	public void setTotalCreditsEarned(int credits) {
		// TODO Auto-generated method stub
		
	}


	public String getRollNo() {
		return rollNumber;
	}


	public void setRollNo(String rollNo) {
		this.rollNumber = rollNo;
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


	public String getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments;


	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}


	public Collection<Student> getEnrollments() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getCourse() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
