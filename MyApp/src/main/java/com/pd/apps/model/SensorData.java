package com.pd.apps.model;

public interface SensorData {
	public  String getSensorType();
	public void parse();
	public String getRawData();
	public String getSensorId();
	public void setRawData(String rawData);
	
}
