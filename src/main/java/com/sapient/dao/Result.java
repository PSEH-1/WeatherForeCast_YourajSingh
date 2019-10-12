package com.sapient.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	
	private int count;
	private List<WeatherData> weatherData;
	
	public List<WeatherData> getWeatherData() {
		return weatherData;
	}
	public void setWeatherData(List<WeatherData> weatherData) {
		this.weatherData = weatherData;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
