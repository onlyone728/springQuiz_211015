package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {

	public RealEstate selectRealEstate(@Param("id")int id);

	public List<RealEstate> selectRealEstate2(@Param("rent_price")Integer rent_price);

	public List<RealEstate> selectRealEstate3(@Param("area")int area, @Param("price")int price);
	
}
