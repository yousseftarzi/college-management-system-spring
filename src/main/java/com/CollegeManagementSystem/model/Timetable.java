package com.CollegeManagementSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */
/**
 * @author Pc
 *
 */
@Entity
public class Timetable {

    /**
     * Default constructor
     */
    public Timetable() {
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
    private String file;

    /**
     * 
     */
    @Column(name="uploaded_at")
    private Date uploadedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(Date uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	@Override
	public String toString() {
		return "Timetable [id=" + id + ", file=" + file + ", uploadedAt=" + uploadedAt + "]";
	}

    

}