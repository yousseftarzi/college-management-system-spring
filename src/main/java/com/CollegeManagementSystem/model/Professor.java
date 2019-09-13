package com.CollegeManagementSystem.model ;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 */
@Entity
@DiscriminatorValue("professor")
public class Professor extends User {

    /**
     * Default constructor
     */
    public Professor() {
    }

    @ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(
    		name="professor_class",
    		joinColumns=@JoinColumn(name="professor_id"),
    		inverseJoinColumns=@JoinColumn(name="class_id")
    		)
    private List<SchoolClass> schoolClasses;

    @ManyToMany(cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(
    		name="professor_course",
    		joinColumns=@JoinColumn(name="professor_id"),
    		inverseJoinColumns=@JoinColumn(name="course_id")
    		)
    private Set<Course> courses;
    
	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	public List<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}


	public void setSchoolClasses(List<SchoolClass> schoolClasses) {
		this.schoolClasses= schoolClasses;
	}


    

}