package com.railway.ticket.booking.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.ticket.booking.system.dao.SeatAllocationRepository;
import com.railway.ticket.booking.system.entity.SeatAllocation;
import com.railway.ticket.booking.system.model.SeatAllocations;
import com.railway.ticket.booking.system.projection.SeatBookingProjection;
import com.railway.ticket.booking.system.service.BookingService;
import com.railway.ticket.booking.system.service.SeatAllocationService;

@Service
public class SeatAllocationServiceImpl implements SeatAllocationService {

	@Autowired
	private SeatAllocationRepository seatallocrepo;
	
	@Autowired
	private BookingService bookingService;

	public String createSection(SeatAllocations sa) {
		SeatAllocation seataloc = null;
		for(int i=1;i<=sa.getNoOfSeat();i++)
		{
			seataloc = new SeatAllocation(sa.getSectionName(),i);
			seatallocrepo.save(seataloc);
		}	
		return seataloc.toString();
	}

	@Override
	public List<SeatAllocation> fetchAllSections() {
		// TODO Auto-generated method stub
		return seatallocrepo.findAll();
	}
	
	@Override
	public List<SeatBookingProjection> findSeatsWithPassengerDetailsBySectionName(String sectionName)
	{
		// return seatallocrepo.findSeatsWithPassengerDetailsBySectionName(sectionName);
		return null;
	}
	
	@Override
	public List<SeatAllocation> fetchSeatAllocationWithSectionName(String sectionName)
	{
		return seatallocrepo.findBySectionName(sectionName);
	}
	
	@Override
	@Transactional
	public String cancelBooking(String sectionName, int seatNo, long bookingId)
	{
		seatallocrepo.updateSeatAllocationStatusAndSeatNo(seatNo,sectionName);
		bookingService.cancelBooking(bookingId);
		return "Updated successfully";
	}
	
}
