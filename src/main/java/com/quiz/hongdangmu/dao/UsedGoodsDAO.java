package com.quiz.hongdangmu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.hongdangmu.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {

	public List<UsedGoods> selectUsedGoodsList();
	
	public void insertUsedGoods(
			@Param("sellerId") int sellerId,
			@Param("title") String title,
			@Param("description") String description,
			@Param("price") int price,
			@Param("picture") String picture);
}
