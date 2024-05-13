package com.railway.ticket.booking.system.entity;

import java.util.Objects;

import com.railway.ticket.booking.system.projection.SeatAllocationProjection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "booking_details")
public class BookingDetails {
	@Id
	@GeneratedValue
	@Column(name="BOOKING_ID")
	private long bookingId;
	@Column(name="EMAIL")
	private String email;
	@Column(name="SA_ID")
	private String saId;
	@Column(name = "STARTING_POINT")
	private String from;
	@Column(name = "DESTINATION")
	private String to;
	@Column(name="PRICE_PAID")
	private double pricePaid;
	
	@Column(name="BOOKING_STATUS", columnDefinition = "VARCHAR(50) DEFAULT 'CONFIRMED'")
	private String bookingStatus;

	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SA_ID", referencedColumnName = "SA_ID", insertable = false, updatable = false)
	private SeatAllocation seatAllocationDetails;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", insertable = false, updatable = false)
	private Passenger passenger;

	
	
	
	

	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public SeatAllocation getSeatAllocationDetails() {
		return seatAllocationDetails;
	}
	public void setSeatAllocationDetails(SeatAllocation seatAllocationDetails) {
		this.seatAllocationDetails = seatAllocationDetails;
	}
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSaId() {
		return saId;
	}
	public void setSaId(String saId) {
		this.saId = saId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", email=" + email + ", saId=" + saId + ", from=" + from
				+ ", to=" + to + ", pricePaid=" + pricePaid + "]";
	}
	
	
	
	
	

}
