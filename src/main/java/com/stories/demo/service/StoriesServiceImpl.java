	package com.stories.demo.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stories.demo.model.Comments;
import com.stories.demo.model.Stories;
import com.stories.demo.repository.CommentsRepository;
import com.stories.demo.repository.StoriesRepository;

@Service
public class StoriesServiceImpl implements StoriesService{

	@Autowired
	StoriesRepository storyRepo;
	
	@Autowired
	RestTemplate restTemp;
	
	@Autowired
	CommentsRepository commentRepo;

	@Override
	@Cacheable(value="bestStories")  
	public List<Stories> getBestStories() {
		
		System.out.println("Method called");
		List<Stories> storyList = new ArrayList<Stories>();
		ResponseEntity<String> result = restTemp.getForEntity("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty", String.class);
		System.out.println(result.getBody());
		//String temp = "[ 24506744, 24509222, 24507423, 24504080, 24504074, 24510079, 24506303, 24509903, 24503632, 24510053, 24503153, 24508880, 24509298, 24505467, 24505727, 24504473, 24508610, 24503559, 24508559, 24506280, 24503418, 24506724, 24507053, 24508975, 24502003, 24502221, 24502782, 24507905, 24499924, 24505436, 24489871, 24504716, 24504891, 24507009, 24491700, 24505232, 24491371, 24504537, 24491871, 24491605, 24503353, 24505074, 24502697, 24502293, 24508526, 24506809, 24495330, 24506243, 24503179, 24506206, 24486874, 24503163, 24508791, 24509470, 24488224, 24503950, 24489257, 24509403, 24491307, 24502706, 24503436, 24499958, 24505637, 24506470, 24501872, 24502962, 24490036, 24491956, 24464807, 24506152, 24509681, 24507003, 24501803, 24502912, 24502815, 24504589, 24491887, 24500214, 24508010, 24491091, 24509389, 24495138, 24507306, 24494505, 24483283, 24502768, 24502906, 24504365, 24492609, 24507605, 24505183, 24498678, 24504562, 24499374, 24504990, 24505182, 24503889, 24489604, 24500263, 24490299, 24503773, 24503077, 24503720, 24503681, 24489696, 24487353, 24493248, 24491356, 24508088, 24498170, 24492991, 24503292, 24494377, 24491453, 24477981, 24489829, 24477049, 24494852, 24493865, 24501669, 24493491, 24491584, 24488426, 24491839, 24497470, 24483633, 24504102, 24477941, 24493479, 24489268, 24498108, 24498663, 24498939, 24507217, 24494403, 24504979, 24490692, 24494347, 24493200, 24504720, 24494653, 24503022, 24492675, 24499823, 24487825, 24496200, 24486931, 24491776, 24479530, 24470954, 24489728, 24485444, 24490131, 24504505, 24490326, 24494810, 24495046, 24507199, 24492000, 24505116, 24499552, 24479727, 24494956, 24491614, 24491549, 24472659, 24484336, 24477913, 24482208, 24505759, 24495432, 24506844, 24480289, 24484320, 24493710, 24498601, 24491318, 24487937, 24499824, 24497977, 24479628, 24504246, 24506267, 24506229, 24495456, 24498537, 24487135, 24506052, 24490363, 24468084, 24488986, 24503764, 24488745, 24482082, 24480982, 24476469, 24499099, 24487867, 24467635, 24507240, 24501511, 24464339, 24506880, 24480448, 24488831, 24479653, 24508294, 24496219, 24498491, 24480504, 24467351, 24468347, 24474309, 24476333, 24492647, 24468704, 24492185, 24471331, 24502618, 24475327, 24468639, 24493181, 24503080, 24486895, 24485447, 24490089, 24475292, 24476059, 24488624, 24474484, 24487736, 24473111, 24475322, 24478769, 24505288, 24482538, 24495245, 24488527, 24491876, 24482119, 24487805, 24472941, 24504280, 24502066, 24479065, 24481198, 24486726, 24493698, 24493306, 24491205, 24485454, 24477516, 24496766, 24469292, 24496667, 24489234, 24480239, 24485281, 24466929, 24468897, 24493670, 24473864, 24481117, 24485124, 24481854, 24487061, 24490814, 24492615, 24502903, 24463347, 24498836, 24495707, 24470764, 24479705, 24468533, 24494531, 24476641, 24480142, 24469074, 24501294, 24494021, 24501257, 24484511, 24466280, 24501437, 24484129, 24468213, 24495112, 24495886, 24471641, 24485476, 24469140, 24500811, 24498028, 24495244, 24498604, 24477099, 24496149, 24481616, 24471544, 24481973, 24462383, 24486664, 24478149, 24498826, 24478534, 24467731, 24484169, 24495359, 24468874, 24496429, 24481448, 24474343, 24500629, 24494859, 24494630, 24480572, 24502653, 24494486, 24479891, 24494412, 24465225, 24486716, 24467718, 24465207, 24469921, 24479813, 24484291, 24471525, 24477434, 24465595, 24469135, 24493968, 24479103, 24467355, 24469072, 24503934, 24479097, 24474293, 24490847, 24502437, 24493581, 24505730, 24484545, 24502373, 24484177, 24467576, 24487085, 24473231, 24495039, 24475984, 24486929, 24472754, 24478087, 24467989, 24490338, 24501358, 24480034, 24468701, 24472647, 24465170, 24470984, 24476608, 24474042, 24490971, 24502625, 24461844, 24467119, 24491903, 24471015, 24498531, 24473869, 24491746, 24467385, 24500017, 24491604, 24467695, 24468782, 24471434, 24501789, 24481142, 24499723, 24486364, 24501743, 24479846, 24487010, 24493330, 24491004, 24472063, 24490883, 24488600, 24475599, 24469025, 24467649, 24496702, 24466497, 24471738, 24495404, 24466324, 24497213, 24465482, 24481883, 24475178, 24469007, 24490167, 24486675, 24485843, 24461932, 24467391, 24498854, 24487713, 24498104, 24475505, 24464933, 24472050, 24479085, 24462511, 24499487, 24468892, 24463763, 24466814, 24495012, 24485768, 24469257, 24500931, 24469855, 24486248, 24468039, 24484563, 24463967, 24479691, 24461779, 24487917, 24500645, 24471903, 24487801, 24482421, 24484335, 24489009, 24493575, 24470336, 24462322, 24500424, 24471058, 24478876, 24464082, 24469947, 24461861, 24501473, 24472181, 24487679, 24487286, 24486462, 24490264, 24462093, 24486554, 24496434, 24496395, 24483529, 24486168, 24467136, 24469151, 24484368, 24463856, 24472061, 24485257, 24464608, 24495569, 24479951, 24475072, 24501622, 24475726, 24470351, 24491136, 24488260, 24479108, 24464305, 24463423, 24498369, 24463252, 24487860, 24486351, 24479454, 24493849, 24477412, 24483442, 24489387, 24465208, 24478079, 24480564, 24480337, 24486029, 24477872, 24471274, 24466440, 24476405, 24474073, 24472808, 24475287, 24502922 ] ";
		String temp = result.getBody().toString();
		
		temp = temp.replaceAll("\\[", "");
		temp = temp.replaceAll("\\]", "");
		String[] storiesArr = temp.split(",");
		Integer counter = 0;
		for(String storieID : storiesArr) {
			if(counter >= 20)
				break;
			ResponseEntity<String> result2 = restTemp.getForEntity("https://hacker-news.firebaseio.com/v0/item/"+storieID.trim()+".json?print=pretty", String.class);
			JSONObject jsonObj = new JSONObject(result2.getBody());
			String title = null, url = null, by = null;
			Timestamp time = null;
			Integer score = 0;
			
			if (jsonObj.has("title")) 
				title = jsonObj.get("title").toString();
			if (jsonObj.has("url")) 
				url = jsonObj.get("url").toString();
			if (jsonObj.has("by")) 
				by = jsonObj.get("by").toString();
			if (jsonObj.has("time")) 
				time = new Timestamp(Long.parseLong(jsonObj.get("time").toString()));
			if (jsonObj.has("score")) 
				score = Integer.parseInt(jsonObj.get("score").toString());
			
			Stories story = new Stories(Long.parseLong(storieID.trim()), title, url, score, time, by);
			storyList.add(story);
			counter++;
		}
		storyRepo.saveAll(storyList);
		return storyRepo.findTop10ByOrderByScoreDesc();
	}

	@Override
	@Cacheable(value="pastStories") 
	public List<Stories> getPastStories() {
		return storyRepo.findTop10ByOrderByScoreDesc();
	}

	@Override
	@Cacheable(value="comments") 
	public List<Comments> getComments(Long storiesID) {
		ResponseEntity<String> result = restTemp.getForEntity("https://hacker-news.firebaseio.com/v0/item/"+storiesID+".json?print=pretty", String.class);
		JSONObject jsonObj = new JSONObject(result.getBody());
		Integer numberOfChield = 0;
		String kids = null, text = null, cmntKids = null;
		String[] kidsArr = null, cmntKidsArr = null;
		String userName = null;
		Long created = 0L;
		Integer userProfileInYears = 0;
		List<Comments> cmntList = new ArrayList<Comments>();
		
		if (jsonObj.has("kids")) {
			kids = jsonObj.get("kids").toString();
			kids = kids.replaceAll("\\[", "");
			kids = kids.replaceAll("\\]", "");
			
			kidsArr = kids.split(",");
		}
		
		for(String commentID : kidsArr) {
			
			ResponseEntity<String> commentRes = restTemp.getForEntity("https://hacker-news.firebaseio.com/v0/item/"+commentID+".json?print=pretty", String.class);
			JSONObject commentObj = new JSONObject(commentRes.getBody());	
			
			if (commentObj.has("text")) {
				text = commentObj.get("text").toString();
				if(text.length() >= 254) {
					text = text.substring(0, 254);
				}
			}
			
			if (commentObj.has("by")) {
				userName = commentObj.get("by").toString();
				
				ResponseEntity<String> result2 = restTemp.getForEntity("https://hacker-news.firebaseio.com/v0/user/"+userName+".json?print=pretty", String.class);
				JSONObject jsonObj2 = new JSONObject(result2.getBody());
				
				created = jsonObj2.getLong("created");
				
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(created);
				Integer userYear = cal.get(Calendar.YEAR);
				
				LocalDate date = LocalDate.now(); 
				Integer currentYear = date.getYear();
				
				userProfileInYears = currentYear - userYear;
			}
			
			if (commentObj.has("kids")) {
				cmntKids = commentObj.get("kids").toString();
				cmntKids = cmntKids.replaceAll("\\[", "");
				cmntKids = cmntKids.replaceAll("\\]", "");
				
				cmntKidsArr = cmntKids.split(",");
				numberOfChield = cmntKidsArr.length;
			}
			
			Comments comment = new Comments(storiesID, text, userProfileInYears, numberOfChield);
			cmntList.add(comment);
				
		}
		commentRepo.saveAll(cmntList);
		return commentRepo.findTop10ByOrderByNumberOfChieldDesc();
	}
	
	
}
