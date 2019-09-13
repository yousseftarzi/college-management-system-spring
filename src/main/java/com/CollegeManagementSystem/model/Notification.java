package com.CollegeManagementSystem.model ;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




/**
 * 
 */
@Entity
public class Notification {

    /**
     * Default constructor
     */
    public Notification() {
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
    private String content;

    /**
     * 
     */
    @Enumerated(EnumType.STRING)
    @Column(name="severity_level")
    private SeverityLevelEnum severityLevel;

    /**
     * 
     */
    @Column(name="created_at")
    private Date createdAt;

    /**
     * 
     */
    @ManyToOne
    private User recipient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SeverityLevelEnum getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(SeverityLevelEnum severityLevel) {
		this.severityLevel = severityLevel;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	

    

}