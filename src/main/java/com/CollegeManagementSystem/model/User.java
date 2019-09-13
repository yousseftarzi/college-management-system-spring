package com.CollegeManagementSystem.model ;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", 
  discriminatorType = DiscriminatorType.STRING)
public class User {

    /**
     * Default constructor
     */
    public User() {
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
    private String password;

    /**
     * 
     */
    @Column(name="first_name")
    private String firstName;

    /**
     * 
     */
    @Column(name="last_name")
    private String lastName;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    
    private String cin;
    
    
    @Column(name="phone_number")
    private String phoneNumber;

    /**
     * 
     */
    @Column(name="profile_picture")
    private String profilePicture;

    /**
     * 
     */
    @Column(name="created_at")
    private Date createdAt;

    
    @OneToMany(mappedBy="author",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Comment> comments;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

    
}