package com.railway.ticket.booking.system.service;

import java.util.List;

import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.model.Ticket;
import com.railway.ticket.booking.system.projection.SeatAllocationProjection;

public interface BookingService {

	public long createBooking(Ticket t);
	public BookingDetails fetchTicketByUser(String email);
	public List<BookingDetails> fetchAll();
	public List<SeatAllocationProjection> findAllWithSeatAllocationProjections();
	BookingDetails fetchBookingByEmail(String email);
	void cancelBooking(long bookingId);
}
