package com.sapient.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

	@JsonProperty(value="")
	private long dateMillis;
	private String dateText;
	public String getDateText() {
		return dateText;
	}
	public void setDateText(String dateText) {
		this.dateText = dateText;
	}		
}
