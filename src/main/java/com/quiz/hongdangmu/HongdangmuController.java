package com.quiz.hongdangmu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.hongdangmu.bo.UsedGoodsBO;
import com.quiz.hongdangmu.model.UsedGoods;
//import com.quiz.hongdangmu.model.UsedGoods;
import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@Controller
public class HongdangmuController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;

	@Autowired
	private SellerBO sellerBO;

	// http://localhost/hongdangmu
	@RequestMapping("/hongdangmu")
	public String hongdangmu(Model model) {

		// DB select `used-goods`
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
//		List<Seller> sellerList = sellerBO.getSellerWithGoods();
		
		model.addAttribute("usedGoodsList", usedGoodsList);
//		model.addAttribute("sellerList", sellerList);

		return "hongdangmu/template";
	}

	// http://localhost/hongdangmu/addGoods
	@RequestMapping("/hongdangmu/addGoods")
	public String addGoods(Model model) {

		// seller nickname 보내기
		List<Seller> sellerList = sellerBO.getSeller();

		model.addAttribute("seller", sellerList);

		return "hongdangmu/addTemplate";
	}

	// http://localhost/hongdangmu/afterAddGoods
	@PostMapping("/hongdangmu/afterAddGoods")
	public String afterAddGoods(@RequestParam("sellerId") int sellerId, 
			@RequestParam("title") String title,
			@RequestParam("description") String description, 
			@RequestParam("price") int price,
			@RequestParam("picture") String picture) {

		// DB input
		usedGoodsBO.addUsedGoods(sellerId, title, description, price, picture);
		
		return "hongdangmu/afterAddTemplate";
	}
}
