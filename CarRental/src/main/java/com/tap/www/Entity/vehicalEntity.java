package com.tap.www.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class vehicalEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long VehicalId;
	private String Brand;
	private String Model;
	private double RentPerDay;
	private String AvailabilityStatus;
	
	
	
	public vehicalEntity(Long VehicalId, String Brand, String Model, double RentPerDay, String AvailabilityStatus) {
		super();
		this.VehicalId = VehicalId;
		this.Brand = Brand;
		this.Model = Model;
		this.RentPerDay = RentPerDay;
		this.AvailabilityStatus = AvailabilityStatus;
	}



	public vehicalEntity() {
		// TODO Auto-generated constructor stub
	}



	public Long getVehicalId() {
		return VehicalId;
	}



	public void setVehicalId(Long VehicalId) {
		this.VehicalId = VehicalId;
	}



	public String getBrand() {
		return Brand;
	}



	public void setBrand(String Brand) {
		this.Brand = Brand;
	}



	public String getModel() {
		return Model;
	}



	public void setModel(String Model) {
	this.	Model = Model;
	}



	public double getRentPerDay() {
		return RentPerDay;
	}



	public void setRentPerDay(double RentPerDay) {
		this.RentPerDay = RentPerDay;
	}



	public String getAvailabilityStatus() {
		return AvailabilityStatus;
	}



	public void setAvailabilityStatus(String AvailabilityStatus) {
		this.AvailabilityStatus = AvailabilityStatus;
	}



	@Override
	public String toString() {
		return "vehicalEntity [VehicalId=" + VehicalId + ", Brand=" + Brand + ", Model=" + Model + ", RentPerDay="
				+ RentPerDay + ", AvailabilityStatus=" + AvailabilityStatus + "]";
	}
	
	
	
	
	
	

}
