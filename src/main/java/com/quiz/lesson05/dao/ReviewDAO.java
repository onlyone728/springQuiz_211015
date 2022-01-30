package com.quiz.lesson05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson05.model.Review;

@Repository
public interface ReviewDAO {

	public List<Review> selectReviewListById(
			@Param("storeId") int storeId);
}
