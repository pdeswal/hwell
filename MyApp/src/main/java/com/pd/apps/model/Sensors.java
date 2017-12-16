package com.pd.apps.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name="Sensors")
public class Sensors implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String sId;

	@Column(name="S_Type", nullable=false)
	private String sType;

	@Column(name="Layout_ID", nullable=false)
	private String layoutId;

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getLayoutid() {
		return layoutId;
	}

	public void setLayoutid(String layoutid) {
		this.layoutId = layoutid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((layoutId == null) ? 0 : layoutId.hashCode());
		result = prime * result + ((sId == null) ? 0 : sId.hashCode());
		result = prime * result + ((sType == null) ? 0 : sType.hashCode());
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
		if (layoutId == null) {
			if (other.layoutId != null)
				return false;
		} else if (!layoutId.equals(other.layoutId))
			return false;
		if (sId == null) {
			if (other.sId != null)
				return false;
		} else if (!sId.equals(other.sId))
			return false;
		if (sType == null) {
			if (other.sType != null)
				return false;
		} else if (!sType.equals(other.sType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sensors [sId=" + sId + ", sType=" + sType + ", layoutId=" + layoutId + "]";
	}

	
	


}