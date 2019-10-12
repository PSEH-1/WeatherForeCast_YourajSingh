package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.ForecastDataRetriever;

@Service
public class ForecastDataService {

	@Autowired
	ForecastDataRetriever retriever;
	public String list() {
		
		return retriever.list();
		
	}
	public String list(String txt) {
		return retriever.list(txt);
	}
}
