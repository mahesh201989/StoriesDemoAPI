/**
* API Processing Logging
* 
* @author Mahesh Chaudhari
* @version 1.0.0
* @since Dec 2019
*
*/

package com.stories.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORIES")
public class Stories implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "STORIES_ID")
	private Long storiesID;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "SCORE")
	private Integer score;
	
	@Column(name = "TIME")
	private Timestamp time;
	
	@Column(name = "USER")
	private String user;
	
	public Stories() {
		super();
	}
	
	public Stories(Long storiesID, String title, String url, Integer score, Timestamp time, String user) {
		super();
		this.storiesID = storiesID;
		this.title = title;
		this.url = url;
		this.score = score;
		this.time = time;
		this.user = user;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Stories [id=" + id + ", storiesID=" + storiesID + ", title=" + title + ", url=" + url + ", score="
				+ score + ", time=" + time + ", user=" + user + "]";
	}

}
