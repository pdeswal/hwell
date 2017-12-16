package com.pd.apps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APPLIANCE")
public abstract class Appliance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -399332519067110179L;
	@Id
	private String id;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="STATUS", nullable=false)
	private String status;
	
	@Column(name="POWER_RATING")
	private Double powerRating;
	
	@Column(name="LAYOUT_ID")
	private String layoutId;
	
	
	@Column(name="OTHER_INFO")
	private String otherInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPowerRating() {
		return powerRating;
	}

	public void setPowerRating(Double powerRating) {
		this.powerRating = powerRating;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public void turnOff(){
		System.out.println("turning off");
		this.status = "OFF";
	}
	
	public void turnOn(){
		System.out.println("turning on");
		this.status = "ON";
	}
}
