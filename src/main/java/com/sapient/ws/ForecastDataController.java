package com.sapient.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.service.ForecastDataService;

@RestController
@RequestMapping(value ="/data")
public class ForecastDataController {
	
	@Autowired
	ForecastDataService service;
	
	
	@RequestMapping(value="/listAll" , method = RequestMethod.GET, produces= "application/json")
	public @ResponseBody String listData() {
		
		return service.list();
	}
	
	@RequestMapping(value="/list" , method = RequestMethod.GET, produces= "application/json")
	public @ResponseBody String listDataByFilter(@RequestParam("date") String txt) {
		
		return service.list(txt);
	}
	

}
