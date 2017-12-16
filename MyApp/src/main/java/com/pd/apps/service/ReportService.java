package com.pd.apps.service;

import java.util.List;

import com.pd.apps.model.Appliance;

public interface ReportService {
	
	List<Appliance> findAllReports();
	void saveApplianceData(Appliance appliance);
}
