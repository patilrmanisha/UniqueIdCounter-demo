package com.fetchrewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fetchrewards.service.CounterService;

@RestController
@RequestMapping(value = "/api/v1/email")
public class CounterController{
	
	@Autowired 
	CounterService counterService;
	
	@RequestMapping(value="/idCount", method=RequestMethod.GET,consumes="application/json", produces="application/json")
	public ResponseEntity<Integer> countUniqueEmail(@RequestBody List<String> idList){
	
		int ct = counterService.getUniqueIdCount(idList);
		return new ResponseEntity<Integer>(ct, HttpStatus.OK);
		
	}
	
}

/*
Sample Json 
[ 
"test@gmail.com",
"test1@gmail.com",
"test+spam@gmail.com"
]
*/