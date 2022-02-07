package com.quiz.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.WeatherDAO;
import com.quiz.lesson05.model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;

	public List<Weather> getWeatherList() {
		return weatherDAO.selectWeatherList();
	}
	
	public void addWeather(
			String date,
			String weather,
			double temperatures,
			double precipitation,
			String microDust,
			double windSpeed) {
		weatherDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
