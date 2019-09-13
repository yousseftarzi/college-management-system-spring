package com.CollegeManagementSystem.model ;
import javax.persistence.CascadeType;
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
public class Mark {

    /**
     * Default constructor
     */
    public Mark() {
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
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="exam_id")
    private Exam exam;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;



}