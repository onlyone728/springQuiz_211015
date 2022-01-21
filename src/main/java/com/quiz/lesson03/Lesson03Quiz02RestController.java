package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// http://localhost/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		// RealEstate 객체에 값을 세팅
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		// BO insert 요청 => 입력된 성공 row 수 리턴
		// TODO insert realEstate
		int rowCount = realEstateBO.addRealEstate(realEstate);
		return "입력 성공 : " + rowCount;
	}
}
