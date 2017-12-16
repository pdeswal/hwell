package com.pd.apps.model;

public class AirCondition extends Appliance implements TempratureControllabe {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7311489569026966715L;
	
	@Override
	public void setTempretaure(double temprature) {
		setStatus("ON-"+temprature + " degrees");
		setOtherInfo(temprature+"");
	}
	
	@Override
	public void turnOn(){
		setStatus("ON-"+getTemprature() + " degrees");
	}

	@Override
	public String getTemprature() {
		return getOtherInfo();
	};
	
	
}
