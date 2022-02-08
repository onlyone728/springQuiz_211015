package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private FavoriteBO favoriteBO;
	
	@RequestMapping("/lesson06/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/addFavorite";
	}
	
	// 즐겨찾기 추가 기능
	@PostMapping("/lesson06/add_favorite")
	@ResponseBody
	public String addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// insert DB
		favoriteBO.addFavorite(name, url);
		
		return "성공";
	}
	
	// 즐겨찾기 리스트 화면
	@RequestMapping("/lesson06/after_add_favorite")
	public String afterAddFavorite(Model model) {
		
		// select DB
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		// return String
		return "lesson06/afterAddFavorite";
	}
	
	
}
