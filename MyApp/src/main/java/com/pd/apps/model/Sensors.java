package com.pd.apps.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name="Sensors")
public class Sensors implements Serializable{

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;

@NotEmpty
@Column(name="S_ID", nullable=false)
private String s_id;

@Column(name="S_Type", nullable=false)
private Integer s_Type;

@Column(name="Layout_ID", nullable=false)
private double layout_ID;

public int getId() {
return id;
}



public String getS_id() {
return s_id;
}



public void setS_id(String s_id) {
this.s_id = s_id;
}



public Integer getS_Type() {
return s_Type;
}



public void setS_Type(Integer s_Type) {
this.s_Type = s_Type;
}



public double getLayout_ID() {
return layout_ID;
}



public void setLayout_ID(double layout_ID) {
this.layout_ID = layout_ID;
}



public void setId(int id) {
this.id = id;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	long temp;
	temp = Double.doubleToLongBits(layout_ID);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((s_Type == null) ? 0 : s_Type.hashCode());
	result = prime * result + ((s_id == null) ? 0 : s_id.hashCode());
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Sensors other = (Sensors) obj;
	if (id != other.id)
		return false;
	if (Double.doubleToLongBits(layout_ID) != Double.doubleToLongBits(other.layout_ID))
		return false;
	if (s_Type == null) {
		if (other.s_Type != null)
			return false;
	} else if (!s_Type.equals(other.s_Type))
		return false;
	if (s_id == null) {
		if (other.s_id != null)
			return false;
	} else if (!s_id.equals(other.s_id))
		return false;
	return true;
}



@Override
public String toString() {
	return "Sensors [id=" + id + ", s_id=" + s_id + ", s_Type=" + s_Type + ", layout_ID=" + layout_ID + "]";
}




}