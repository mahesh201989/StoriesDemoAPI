package com.stories.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stories.demo.model.Stories;


@Repository
public interface StoriesRepository extends JpaRepository<Stories, Long>{
	
	List<Stories> findTop10ByOrderByScoreDesc();

}
