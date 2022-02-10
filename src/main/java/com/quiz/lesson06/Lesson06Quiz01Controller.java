package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 즐겨찾기 추가 화면
	@RequestMapping("/lesson06/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/addFavorite";
	}
	
	// 즐겨찾기 추가 기능 - AJAX 호출로 들어오는 요청
	@PostMapping("/lesson06/add_favorite")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// insert DB
		favoriteBO.addFavorite(name, url);
		
		// return map => return json string
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		result.put("code", "1");
		
		return result;
	}
	
	// 즐겨찾기 리스트 화면
	@RequestMapping("/lesson06/favorite_list")
	public String afterAddFavorite(Model model) {
		
		// select DB
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		// return String
		return "lesson06/favorite_list";
	}
	
	// url 중복 확인 - AJAX 통신 호출
	@ResponseBody
	@PostMapping("/lesson06/is_duplication")
	public Map<String, Boolean>  isDuplication(
			@RequestParam("url") String url) {
		
		// 중복 확인
		Favorite favorite = favoriteBO.getFavoriteByUrl(url);
		
		// map 리턴
		Map<String, Boolean> result = new HashMap<>();
		result.put("result", true);
		
		if (favorite == null) {
			// 중복되지 않음
			result.put("result", false);
		}
		
		return result;
	}
	
	// 즐겨찾기 삭제 기능 -> AJAX 통신 호출
	@ResponseBody
	@RequestMapping("/lesson06/delete_favorite")
	public Map<String, Boolean> deleteFavorite(
			@RequestParam("id") int id) {
		
		// delete DB
		boolean isDelete = favoriteBO.deleteFavorite(id);
		
		// return map
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDelete", isDelete);
		
		return result;
	}
}
