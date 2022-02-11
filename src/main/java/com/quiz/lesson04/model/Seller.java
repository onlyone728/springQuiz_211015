package com.quiz.lesson04.model;

import java.util.Date;

import com.quiz.hongdangmu.model.UsedGoods;

public class Seller {

	private int id;
	private String nickname;
	private String profileImageUrl;
	private Double temperature;
	private Date createdAt;
	private Date updatedAt;
	
	private UsedGoods usedGoods;	// join할 model
	
	public UsedGoods getUsedGoods() {
		return usedGoods;
	}
	public void setUsedGoods(UsedGoods usedGoods) {
		this.usedGoods = usedGoods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
