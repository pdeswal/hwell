package com.pd.apps.model;

import com.pd.apps.util.AppConstants;

public class TempSensorData implements SensorData{
	private String rawData;
	
	private String sensorId;
	private String temp;
	private String humidity;

	@Override
	public String getSensorType() {
		return AppConstants.TEMP_SENSOR;
	}

	@Override
	public void parse() {
		String[] data = rawData.split(",");
		sensorId = data[0];
		temp = data[1];
		humidity = data[2];
	}

	@Override
	public String getRawData() {
		return rawData;
	}
	
	@Override
	public void setRawData(String rawData){
		this.rawData = rawData;
	}

	@Override
	public String getSensorId() {
		return sensorId;
	}
	
}
