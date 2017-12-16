package com.pd.apps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APPLIANCE")
public class Appliance implements Serializable{
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
	
	
}
