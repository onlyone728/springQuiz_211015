package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost/lesson04/quiz01/1	-> 판매자 추가 view 화면
	@RequestMapping("/lesson04/quiz01/1")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/lesson04/quiz01/add_seller")
	public String addSeller(
			@RequestParam(value="nickname", required=true) String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam(value="temperature") double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		return "lesson04/afterAddSeller";
	}
	
	// http://localhost/lesson04/quiz01/seller_info?id=1
	// http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/lesson04/quiz01/seller_info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id,
			Model model) {
		
		if(id == null) {
			// 최근 seller 1행 정보 select
			Seller seller = sellerBO.getLastSeller();
			model.addAttribute("seller", seller);
		} else {
			Seller seller = sellerBO.getSellerById(id);
			model.addAttribute("seller", seller);
		}
		
		return "lesson04/sellerInfo";
	}
}
