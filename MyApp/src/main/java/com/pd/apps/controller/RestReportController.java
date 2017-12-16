package com.pd.apps.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pd.apps.model.Appliance;
import com.pd.apps.model.User;
import com.pd.apps.service.ReportService;
import com.pd.apps.util.CustomErrorType;

@RestController
@RequestMapping("/reportApi")
public class RestReportController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping(value = "/report/", method = RequestMethod.GET)
	public ResponseEntity<List<Appliance>> listAllReports() {
		List<Appliance> reports = reportService.findAllReports();
		if (reports.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Appliance>>(reports, HttpStatus.OK);
	}
	
	// -------------------Add Appliance Report-------------------------------------------

		@RequestMapping(value = "/report/", method = RequestMethod.POST)
		public ResponseEntity<List<Appliance>> addApplianceData(@RequestBody Appliance appliance, UriComponentsBuilder ucBuilder) {
			logger.info("Adding Report : {}", appliance);			
			reportService.saveApplianceData(appliance);
			List<Appliance> reports = reportService.findAllReports();
			if (reports.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Appliance>>(reports, HttpStatus.OK);
		}

}
