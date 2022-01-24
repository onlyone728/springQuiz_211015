package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz03RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// http://localhost/lesson03/quiz03/1?id=8&type=전세&price=70000
	@RequestMapping("/lesson03/quiz03/1")
	public String quiz03(
			@RequestParam(value="id", required=true) int id,
			@RequestParam(value="type", required=true) String type,
			@RequestParam(value="price", required=true) int price) {
		// id가 8인 행의 type 을 전세로 바꾸고 price를 70000으로 변경
		int rowCount = realEstateBO.updateRealEstateById(8, "전세", 70000);
		return "수정 성공 : " + rowCount;
	}
}
