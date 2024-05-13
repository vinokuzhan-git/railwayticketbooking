package com.railway.ticket.booking.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.ticket.booking.system.entity.SeatAllocation;
import com.railway.ticket.booking.system.model.SeatAllocations;
import com.railway.ticket.booking.system.projection.SeatBookingProjection;
import com.railway.ticket.booking.system.service.SeatAllocationService;

@RestController
@RequestMapping("/seat/allocation")
public class SeatAllocationController {
	
	@Autowired
	SeatAllocationService seatallocservice;
	
	@PostMapping("/create")
	public String createSeatAllocation(@RequestBody SeatAllocations sa)
	{
		return seatallocservice.createSection(sa);
	}
	
	@GetMapping("/all")
	public List<SeatAllocation> fetchAllSeatAllocation()
	{
		return seatallocservice.fetchAllSections();
	}
	
	@GetMapping("/section/{sectionName}")
	public List<SeatAllocation> fetchSeatAllocationWithSectionName(@PathVariable("sectionName") String sectionName)
	{
		// return seatallocservice.findSeatsWithPassengerDetailsBySectionName(sectionName);
		return seatallocservice.fetchSeatAllocationWithSectionName(sectionName);
	}
	
	@PutMapping("/cancel/booking")
	public String cancelReservation(@Param("sectionName") String sectionName, @Param("seatNo") int seatNo,@Param("bookingId") long bookingId)
	{
		System.out.println("sectionName : "+sectionName+" seatNo : "+seatNo+" bookingId : "+bookingId);
		return seatallocservice.cancelBooking(sectionName, seatNo, bookingId);
	}

}
