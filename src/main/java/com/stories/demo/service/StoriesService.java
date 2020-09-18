package com.stories.demo.service;

import java.util.List;

import com.stories.demo.model.Comments;
import com.stories.demo.model.Stories;


public interface StoriesService {

	public List<Stories> getBestStories();
	
	public List<Stories> getPastStories();
	
	public List<Comments> getComments(Long storiesID);
	
	
	
}
