package com.pd.apps.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pd.apps.model.AccessControlSensorData;
import com.pd.apps.model.User;
import com.pd.apps.service.SensorService;

@RestController
@RequestMapping("/api")
public class SesnsorController {
	
	Logger log = Logger.getLogger(SesnsorController.class);
	
	@Autowired
	SensorService sensorService;
	
	@RequestMapping(value = "/sensor/card/", method = RequestMethod.POST)
	public ResponseEntity<?> inputSensorData(@RequestBody AccessControlSensorData data) {
		try{
			sensorService.processSensorData(data);
			System.out.println(data);
		}catch(Exception e){
			log.error(e.getMessage(), e);
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
		return new ResponseEntity<Object>("", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sensor/card/", method = RequestMethod.GET)
	public ResponseEntity<Object> getInputSensorData() {
		try{
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}
		return new ResponseEntity<Object>("working", HttpStatus.OK);
	}
	
}
