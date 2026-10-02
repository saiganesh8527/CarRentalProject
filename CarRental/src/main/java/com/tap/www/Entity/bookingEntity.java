package com.tap.www.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class bookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	private LocalDate startDate;
	private LocalDate endDate;
	private double totalAmount;
	private String bookingStatus;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private customerEntity customer;
	
	@ManyToOne
	@JoinColumn(name = "vehical_id")
	private vehicalEntity vehical;
	
	

	





	public bookingEntity(Long bookingId, LocalDate startDate, LocalDate endDate, double totalAmount,
			String bookingStatus, customerEntity customer, vehicalEntity vehical) {
		super();
		this.bookingId = bookingId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalAmount = totalAmount;
		this.bookingStatus = bookingStatus;
		this.customer = customer;
		this.vehical = vehical;
	}


	public bookingEntity() {
		// TODO Auto-generated constructor stub
	}




	public Long getBookingId() {
		return bookingId;
	}





	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}





	public LocalDate getStartDate() {
		return startDate;
	}





	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}





	public LocalDate getEndDate() {
		return endDate;
	}





	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}





	public double getTotalAmount() {
		return totalAmount;
	}





	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}





	public String getBookingStatus() {
		return bookingStatus;
	}





	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}





	public customerEntity getCustomer() {
		return customer;
	}





	public void setCustomer(customerEntity customer) {
		this.customer = customer;
	}





	public vehicalEntity getVehical() {
		return vehical;
	}





	public void setVehical(vehicalEntity vehical) {
		this.vehical = vehical;
	}





	@Override
	public String toString() {
		return "bookingEntity [bookingId=" + bookingId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", totalAmount=" + totalAmount + ", bookingStatus=" + bookingStatus + ", customer=" + customer
				+ ", vehical=" + vehical + "]";
	}


	
	
	
	
	

}
