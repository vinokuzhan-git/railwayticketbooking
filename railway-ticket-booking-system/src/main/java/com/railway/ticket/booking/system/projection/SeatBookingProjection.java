package com.railway.ticket.booking.system.projection;

import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.entity.Passenger;
import com.railway.ticket.booking.system.entity.SeatAllocation;

public class SeatBookingProjection {

	private SeatAllocation seatAllocation;
    private BookingDetails bookingDetails;
    private Passenger passenger;
	public SeatBookingProjection(SeatAllocation seatAllocation, BookingDetails bookingDetails, Passenger passenger) {
		super();
		this.seatAllocation = seatAllocation;
		this.bookingDetails = bookingDetails;
		this.passenger = passenger;
	}
	public SeatAllocation getSeatAllocation() {
		return seatAllocation;
	}
	public void setSeatAllocation(SeatAllocation seatAllocation) {
		this.seatAllocation = seatAllocation;
	}
	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
    
	
}
