package com.CollegeManagementSystem.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 */
@Entity
public class Attendance {

    /**
     * Default constructor
     */
    public Attendance() {
    }
   
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    
    private boolean status;
    
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
	
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
    
    
    

}