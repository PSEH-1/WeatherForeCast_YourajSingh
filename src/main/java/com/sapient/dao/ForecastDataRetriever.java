package com.sapient.dao;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ForecastDataRetriever {

	RestTemplate restTemplate;

	public ForecastDataRetriever() {
		restTemplate = new RestTemplate();
	}

	public String list() {

		String result = restTemplate.getForObject(
				"https://samples.openweathermap.org/data/2.5/forecast?q=London,us&appid=b6907d289e10d714a6e88b30761fae22",
				String.class);
		return result;
	}

	public String list(String txt) {

		String result = restTemplate.getForObject(
				"https://samples.openweathermap.org/data/2.5/forecast?q=London,us&appid=b6907d289e10d714a6e88b30761fae22",
				String.class);

		JSONObject obj = new JSONObject(result);

		JSONArray arr = obj.getJSONArray("list");
		long textLong = Long.parseLong(txt);
		for (int i = 0; i < arr.length(); i++) {
			long dateInt = arr.getJSONObject(i).getLong("dt");
			System.out.println(dateInt);
			System.out.println(textLong);
			JSONObject main = arr.getJSONObject(i).getJSONObject("main");
			int temp = main.getInt("temp_max");
			System.out.println("temp: " + temp);
		
			if (dateInt == textLong) {
				if (temp > 40) {
					return "\"response\":\"Use sunscreen lotion\"";
				} else {
					JSONArray arr1 = obj.getJSONArray("weather");
					for (int j = 0; j < arr1.length(); j++) {
						String rain = arr1.getJSONObject(j).getString("main");
						if("Rain".equals(rain)) {
							return "\"response\":\"Carry Umbrella\"";
						}
					}
				}
			} else {
				continue;
			}
		}
		return result;
	}

}
