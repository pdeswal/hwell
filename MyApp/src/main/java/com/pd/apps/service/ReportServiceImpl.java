package com.pd.apps.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pd.apps.model.User;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService{

	@Override
	public List<User> findAllReports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveApplianceData(User user) {
		// TODO Auto-generated method stub
		
	}

}
