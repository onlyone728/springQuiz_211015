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
public class SellerController {

	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost/lesson04/quiz01/1
	@RequestMapping("/lesson04/quiz01/1")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/lesson04/quiz01/add_seller")
	public String addSeller(
			@RequestParam(value="nickname", required=true) String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam(value="temperature", required=false) Double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/lesson04/quiz01/seller_info")
	public String sellerInfo(Model model) {
		Seller lastSeller = sellerBO.getSeller();
		model.addAttribute("result", lastSeller);
		model.addAttribute("subject", "판매자 정보");
		
		return "lesson04/sellerInfo";
	}
}
