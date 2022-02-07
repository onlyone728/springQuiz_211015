package com.quiz.lesson05;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherBO;
import com.quiz.lesson05.model.Weather;

@Controller
public class Lesson05Quiz05Controller {

	@Autowired
	private WeatherBO weatherBO;

	// request -> server -> response
	// http://localhost/lesson05/quiz05
	@RequestMapping("/lesson05/quiz05")
	public String quiz05(Model model) {
		// DB select
		List<Weather> weatherHistory = weatherBO.getWeatherList();

		model.addAttribute("weatherHistory", weatherHistory);

		return "weather_history/quiz05Template";
	}

	// 날씨 정보 입력 화면
	// http://localhost/lesson05/quiz05Add
	@RequestMapping("/lesson05/quiz05Add")
	public String addtWeather() {

		return "weather_history/quiz05AddTemplate";
	}

	// 날씨 입력 => 결과 : 날씨 정보 목록 화면으로 리다이렉트
	@PostMapping("/lesson05/quiz05AfterAddWeather")
	public String afterAddWeather(
			@RequestParam("date") String date,
			@RequestParam("weather") String weather, 
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed,
			HttpServletResponse response) {

		// DB insert
		weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);

		// 날씨 정보 목록 화면으로 리다이렉트
		// return response.sendRedirect("/lesson05/quiz05");
		return "redirect:/lesson05/quiz05";
		

	}
}
