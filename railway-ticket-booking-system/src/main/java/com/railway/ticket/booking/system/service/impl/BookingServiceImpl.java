package com.railway.ticket.booking.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.ticket.booking.system.dao.BookingDetailsRepository;
import com.railway.ticket.booking.system.dao.PassengerRepository;
import com.railway.ticket.booking.system.dao.SeatAllocationRepository;
import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.entity.Passenger;
import com.railway.ticket.booking.system.entity.SeatAllocation;
import com.railway.ticket.booking.system.mapper.BookingDetailsMapper;
import com.railway.ticket.booking.system.model.Ticket;
import com.railway.ticket.booking.system.projection.SeatAllocationProjection;
import com.railway.ticket.booking.system.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	PassengerRepository passengerrepo;
	
	@Autowired
	BookingDetailsRepository bookingdetailsrepo;
	
	@Autowired
	SeatAllocationRepository seatallocrepo;

	@Override
	public long createBooking(Ticket t) {
		// TODO Auto-generated method stub
		System.out.println("Service class : t.toString() : "+t.toString());
		Passenger p = new Passenger();
		SeatAllocation sa = t.getSa();
		sa.setEmail(t.getPd().getEmail());
		Optional<Passenger> po = passengerrepo.findById(t.getPd().getEmail());
		if(po.isPresent())
			p = po.get();
		if(p.getEmail() == null)
		{
			p.setEmail(t.getPd().getEmail());
			p.setFname(t.getPd().getFname());
			p.setLname(t.getPd().getLname());
			System.out.println("Passenger Saved : "+passengerrepo.save(p));
		}	
		BookingDetailsMapper bdmap = new BookingDetailsMapper(t);
		BookingDetails bd = bdmap.fetchBookingDetails();
		long bookingId=bookingdetailsrepo.save(bd).getBookingId();
		if(bookingId > 0)
		{	
			sa.setStatus("Y");
			sa.setSaId(sa.getSectionName()+"_"+sa.getSeatNo());
			seatallocrepo.save(sa);
		}	
		return bookingId;
	}

	@Override
	public BookingDetails fetchTicketByUser(String email) {
		// TODO Auto-generated method stub
		
		return bookingdetailsrepo.findByEmail(email);
	}
	
	@Override
	public List<BookingDetails> fetchAll()
	{
		return bookingdetailsrepo.findAll();
	}
	
	@Override
	public BookingDetails fetchBookingByEmail(String email)
	{
		return bookingdetailsrepo.findByEmail(email);
	}
	
	@Override
	public List<SeatAllocationProjection> findAllWithSeatAllocationProjections()
	{
		return bookingdetailsrepo.findAllWithSeatAllocationProjections();
	}
	@Override
	public void cancelBooking(long saId)
	{
		bookingdetailsrepo.cancelBooking(saId);
	}

}
