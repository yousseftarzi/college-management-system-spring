package com.CollegeManagementSystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Comment {

    /**
     * Default constructor
     */
    public Comment() {
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
    @Column(name="created_at")
    private Date createdAt;

    /**
     * 
     */
    @Column(name="updated_at")
    private Date updatedAt;

    /**
     * 
     */
    
/*    @JoinTable(
    		name="author_comment",
    		joinColumns=@JoinColumn(name="comment_id"),
    		inverseJoinColumns=@JoinColumn(name="author_id")
    		)*/
    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="author_id")
    private User author;

    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="post_id")
    private Post post;

    
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", author=" + author + ", post=" + post + "]";
	}

    

}