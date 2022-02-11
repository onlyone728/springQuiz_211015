package com.quiz.hongdangmu.model;

import com.quiz.lesson04.model.Seller;

public class SellerGoods {

	private Seller seller;
	private UsedGoods usedGoods;
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public UsedGoods getUsedGoods() {
		return usedGoods;
	}
	public void setUsedGoods(UsedGoods usedGoods) {
		this.usedGoods = usedGoods;
	}
}
