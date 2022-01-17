package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller
public class Quiz01Controller {

	// http://localhost/lesson01/quiz01/1
	@ResponseBody
	@RequestMapping("/1")
	public String printString() {
		return "<h1>테스트 프로젝트 완성</h1><b>해당 프로젝트를 통해서 문제를 진행합니다.</b>";
	}
	
	// http://localhost/lesson01/quiz01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap() {
		Map<String, Object> scores = new HashMap<>();
		scores.put("국어", 80);
		scores.put("수학", 90);
		scores.put("영어", 85);
		
		return scores;
	}
}
