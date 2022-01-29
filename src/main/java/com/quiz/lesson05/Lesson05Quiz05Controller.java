package com.quiz.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherBO;
import com.quiz.lesson05.model.Weather;

@Controller
public class Lesson05Quiz05Controller {

	@Autowired
	private WeatherBO weatherBO;

	// http://localhost/lesson05/quiz05
	@RequestMapping("/lesson05/quiz05")
	public String quiz05(Model model) {
		// DB select
		List<Weather> weatherHistory = weatherBO.selectWeather();

		model.addAttribute("weatherHistory", weatherHistory);

		return "lesson05/quiz05Template";
	}

	// http://localhost/lesson05/quiz05Add
	@RequestMapping("/lesson05/quiz05Add")
	public String addtWeather() {

		return "lesson05/quiz05AddTemplate";
	}

	//
	@RequestMapping("/lesson05/quiz05AfterAddWeather")
	public String afterAddWeather(
			@RequestParam("date") 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
			@RequestParam("weather") String weather, 
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed,
			Model model) {

		weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);

		// DB select
		List<Weather> weatherHistory = weatherBO.selectWeather();

		model.addAttribute("weatherHistory", weatherHistory);

		return "lesson05/quiz05Template";

	}
}
