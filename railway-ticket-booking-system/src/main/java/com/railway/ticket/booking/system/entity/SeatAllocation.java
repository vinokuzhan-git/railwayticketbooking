package com.railway.ticket.booking.system.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seat_allocation")
public class SeatAllocation {
	@Id
	@Column(name="SA_ID")
	private String saId;
	@Column(name = "SECTION_NAME",length = 20, nullable = false)
	private String sectionName;
	@Column(name = "SEAT_NO", nullable = false)
	private int seatNo;
	
	@Column(name = "EMAIL")
    private String email;
	
	@Column(name = "BOOKING_STATUS")
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", insertable = false, updatable = false)
	private Passenger passenger;
	
	
	

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public SeatAllocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeatAllocation(String sectionName, int seatNo) {
		super();
		this.sectionName = sectionName;
		this.seatNo = seatNo;
		this.saId=sectionName+"_"+seatNo;
		this.status="N";
	}

	public String getSaId() {
		return saId;
	}

	public void setSaId(String saId) {
		this.saId = saId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SeatAllocation [saId=" + saId + ", sectionName=" + sectionName + ", seatNo=" + seatNo + ", email="
				+ email + ", status=" + status + "]";
	}


	
	

}
