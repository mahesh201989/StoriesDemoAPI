package com.stories.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableJpaRepositories("com.stories.demo.repository")
public class StoriesConfiguration  {

    @Bean
    public RestTemplate restTemplate() {
    	try {
			return new RestTemplate(TrustAllStrategy.buildCustomRequestFactory("hacker-news.firebaseio", 443));
		} catch (MoxtraSingleSignOnProcessException e) {
			e.printStackTrace();
		}
    	return new RestTemplate();
    }
    
}
