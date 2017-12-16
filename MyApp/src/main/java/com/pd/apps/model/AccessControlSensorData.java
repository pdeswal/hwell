package com.pd.apps.model;

import com.pd.apps.util.AppConstants;

public class AccessControlSensorData implements SensorData{

	private String rawData;
	
	private String cardId;
	private String sensorId;
	private String date;
	
	
	
	@Override
	public String getSensorType() {
		return AppConstants.CARD_SENSOR;
	}

	@Override
	public void parse() {
		//validation will go here
		String[] data = rawData.split(",");
		sensorId = data[0];
		cardId = data[1];
		date = data[2];
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
