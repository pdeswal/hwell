package com.pd.apps.service;

import java.util.List;

import com.pd.apps.model.Appliance;
import com.pd.apps.model.SensorData;
import com.pd.apps.model.SensorHistory;
import com.pd.apps.model.Sensors;

public interface SensorService {
	public List<Sensors> getSensorData();
	public List<Appliance> getAppliances();
	public Sensors getSensorData(int id);
	public void processSensorData(SensorData data);
	public void createInitialDataSet();
	public List<SensorHistory> getSensorHistory();
}
