package com.stories.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stories.demo.model.Comments;
import com.stories.demo.model.Stories;
import com.stories.demo.service.StoriesService;

@Controller
public class StoriesController {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	StoriesService storiesService;
	
	@RequestMapping(value = "/best-stories", method= RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Stories> bestStories(HttpServletRequest req) {
		logger.info("API called");
		List<Stories> response = storiesService.getBestStories();
		return response;
	}
	
	@RequestMapping(value = "/past-stories", method= RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Stories> pastStories(HttpServletRequest req) {
		logger.info("API called");
		List<Stories> response = storiesService.getPastStories();
		return response;
	}
	
	@RequestMapping(value = "/comments/{storiesID}", method= RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Comments> comments(@PathVariable("storiesID") Long storiesID) {
		
		logger.info("API called");
		List<Comments> response = storiesService.getComments(storiesID);
		return response;
	}
	
}
