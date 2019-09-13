package com.CollegeManagementSystem.model ;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
public class Grade {

    /**
     * Default constructor
     */
    public Grade() {
    }

    /**
     * 
     */
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    /**
     * 
     */
    public String level;

    /**
     * 
     */
    @OneToOne
    @JoinColumn(name="branch_id")
    public Branch branch;

    /**
     * 
     */
    @OneToMany(mappedBy="grade",cascade= CascadeType.ALL)
    public List<Course> courses;

    /**
     * 
     */
    @OneToMany(mappedBy="grade",cascade= CascadeType.ALL)
    public List<SchoolClass> schoolClasses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}

	public void setSchoolClasses(List<SchoolClass> schoolClasses) {
		this.schoolClasses= schoolClasses;
	}

	
	
	@Override
	public String toString() {
		return "Grade [id=" + id + ", level=" + level + ", branch=" + branch + "]";
	}

	

    

}