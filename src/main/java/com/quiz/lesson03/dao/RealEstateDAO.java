package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {

	public RealEstate selectRealEstateById(@Param("id")int id);

	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice")int rentPrice);

	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			// @Param 어노테이션은 파라미터들을 하나의 맵으로 만든다.
			@Param("area")int area, 
			@Param("price")int price);
	
	public int insertRealEstate(RealEstate realEstate);
}
