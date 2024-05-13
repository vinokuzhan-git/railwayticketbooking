package com.railway.ticket.booking.system.service;

import java.util.List;

import com.railway.ticket.booking.system.entity.SeatAllocation;
import com.railway.ticket.booking.system.model.SeatAllocations;
import com.railway.ticket.booking.system.projection.SeatBookingProjection;

public interface SeatAllocationService {
	
	public String createSection(SeatAllocations sa);
	public List<SeatAllocation> fetchAllSections();
	List<SeatBookingProjection> findSeatsWithPassengerDetailsBySectionName(String sectionName);
	public List<SeatAllocation> fetchSeatAllocationWithSectionName(String sectionName);
	public String cancelBooking(String sectionName, int seatNo, long bookingId);

}
