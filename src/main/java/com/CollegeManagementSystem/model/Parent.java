package com.CollegeManagementSystem.model ;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@DiscriminatorValue("parent")
public class Parent extends User {

    /**
     * Default constructor
     */
    public Parent() {
    }

    /**
     * 
     */
    
    
    @OneToMany
    @JoinColumn(name="student_id")
    private List<Student> students;

	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(List<Student> students) {
		this.students = students;
	}

	
	

    
}