package com.quiz.lesson05.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.WeatherDAO;
import com.quiz.lesson05.model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;

	public List<Weather> selectWeather() {
		return weatherDAO.selectWeather();
	}
	
	public void addWeather(
			Date date,
			String weather,
			double temperatures,
			double precipitation,
			String microDust,
			double windSpeed) {
		weatherDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
