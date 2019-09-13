package com.CollegeManagementSystem.model ;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * 
 */
@Entity
@DiscriminatorValue("admin")
public class Admin extends User {

    /**
     * Default constructor
     */
	
    public Admin() {
    }
    
    
    @OneToMany(mappedBy="author")
    private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

    


	




}