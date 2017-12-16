package com.pd.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pd.apps.model.Appliance;
import com.pd.apps.repositories.ApplianceRepository;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ApplianceRepository applianceRepository;
	
	@Override
	public List<Appliance> findAllReports() {
		return applianceRepository.findAll();
	}

	@Override
	public void saveApplianceData(Appliance appliance) {
		savereport(appliance);
		
	}

	public void savereport(Appliance appliance) {
		applianceRepository.save(appliance);
		
	}

}
