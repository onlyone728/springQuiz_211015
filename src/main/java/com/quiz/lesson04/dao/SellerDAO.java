package com.quiz.lesson04.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson04.model.Seller;


@Repository
public interface SellerDAO {

	public void insertSeller(
			@Param("nickname") String nickname, 
			@Param("profileImageUrl") String profileImageUrl,
			@Param("temperature") double temperature);
	
	public Seller selectLastSeller();
	
	public List<Seller> selectSeller();
	
	public Seller selectSellerById(int id);
	
	public List<Seller> selectSellerWithGoods();
}
