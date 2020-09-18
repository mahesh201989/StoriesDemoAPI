package com.stories.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comments implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "STORIES_ID")
	private Long storiesID;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "USER_PROFILE_IN_YEARS")
	private Integer userProfileInYears;
	
	@Column(name = "NUMBER_OF_CHIELD")
	private Integer numberOfChield;
	
	
	public Comments() {
		super();
	}


	public Comments(Long storiesID, String text, Integer userProfileInYears, Integer numberOfChield) {
		super();
		this.storiesID = storiesID;
		this.text = text;
		this.userProfileInYears = userProfileInYears;
		this.numberOfChield = numberOfChield;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoriesID() {
		return storiesID;
	}

	public void setStoriesID(Long storiesID) {
		this.storiesID = storiesID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getUserProfileInYears() {
		return userProfileInYears;
	}

	public void setUserProfileInYears(Integer userProfileInYears) {
		this.userProfileInYears = userProfileInYears;
	}
	
	public Integer getNumberOfChield() {
		return numberOfChield;
	}

	public void setNumberOfChield(Integer numberOfChield) {
		this.numberOfChield = numberOfChield;
	}


	@Override
	public String toString() {
		return "Comments [id=" + id + ", storiesID=" + storiesID + ", text=" + text + ", userProfileInYears="
				+ userProfileInYears + "]";
	}

}
