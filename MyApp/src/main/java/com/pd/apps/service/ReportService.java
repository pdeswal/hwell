package com.pd.apps.service;

import java.util.List;

import com.pd.apps.model.User;

public interface ReportService {
	
	List<User> findAllReports();
	void saveApplianceData(User user);
}
