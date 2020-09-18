package com.stories.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stories.demo.model.Comments;


@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
	
	List<Comments> findTop10ByOrderByNumberOfChieldDesc();

}
