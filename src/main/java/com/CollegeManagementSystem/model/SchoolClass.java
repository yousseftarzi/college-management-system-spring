package com.CollegeManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="class")
public class SchoolClass {

    /**
     * Default constructor
     */
    public SchoolClass() {
    }

    /**
     * 
     */
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int capacity;

    /**
     * 
     */
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="timetable_id")
    private Timetable timetable;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade;

    /**
     * 
     */
    @OneToMany(mappedBy="schoolClass",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    private List<Student> students;
    
    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Exam> exams;
 
    
    @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(
    		name="professor_class",
    		joinColumns=@JoinColumn(name="class_id"),
    		inverseJoinColumns=@JoinColumn(name="professor_id")
    		)
    private List<Professor> professors;
    
    @OneToMany(mappedBy = "schoolClass")
    private List<Assignment> assignments;
    
    
    /**
     * 
     */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	

}