package com.CollegeManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 */
@Entity
@DiscriminatorValue("student")
public class Student extends User {

    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * 
     */
    
    
    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="class_id")
    public SchoolClass schoolClass;

    /**
     * 
     */
    @OneToMany(mappedBy="recipient",cascade= {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    public List<Notification> notifications;


    @OneToMany(mappedBy="student",cascade= {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    private List<Attendance> attendances; 

    @OneToMany(mappedBy="student",cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    private List<Mark> marks;


	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Attendance> getAttendance() {
		return attendances;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendances = attendance;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}


    


}