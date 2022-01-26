package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// http://localhost/lesson04/quiz02/1
	@RequestMapping("/lesson04/quiz02/1")
	public String quiz02_1() {
		return "lesson04/addRealtor";
	}
	
	
	// http://localhost/lesson04/quiz02/add_realtor
	@PostMapping("/lesson04/quiz02/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// insert => id 반환을 받고
		realtorBO.addRealtor(realtor);
		
		// select => 반환받은 id로
		realtor = realtorBO.getRealtorById(realtor.getId());
		
		// jsp에서 사용할 객체를 model에 담는다.
		model.addAttribute("realtor", realtor);
		model.addAttribute("subject", "공인중개사 정보");
		
		// view return
		return "lesson04/afterAddRealtor";
	}

}
