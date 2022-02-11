package com.quiz.hongdangmu.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.hongdangmu.dao.UsedGoodsDAO;
import com.quiz.hongdangmu.model.UsedGoods;

@Service
public class UsedGoodsBO {

	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {
		
		return usedGoodsDAO.selectUsedGoodsList();
	}
	
	public void addUsedGoods(
			int sellerId
			, String title
			, String description
			, int price
			, String picture) {
		usedGoodsDAO.insertUsedGoods(sellerId, title, description, price, picture);
	}
}
