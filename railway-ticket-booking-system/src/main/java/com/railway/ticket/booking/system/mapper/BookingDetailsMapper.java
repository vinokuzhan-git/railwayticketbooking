package com.railway.ticket.booking.system.mapper;

import org.springframework.beans.BeanUtils;

import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.model.Ticket;

public class BookingDetailsMapper {
	
	private BookingDetails bd = new BookingDetails();
	private Ticket t;
	public BookingDetailsMapper(Ticket t) {
		super();
		this.t = t;
		System.out.println("Mapper class : t.toString() : "+t.toString());
		System.out.println("this Mapper class : t.toString() : "+this.t.toString());
		BeanUtils.copyProperties(t, bd);
		System.out.println("After coppy property : Mapper class : t.toString() : "+t.toString());
		bd.setEmail(t.getPd().getEmail());
		bd.setSaId(t.getSa().getSectionName()+"_"+t.getSa().getSeatNo());
		bd.setFrom(t.getFrom());
		bd.setTo(t.getTo());
		bd.setPricePaid(t.getPricePaid());
		System.out.println(bd.toString());
		System.out.println(t.toString());
		System.out.println(t.getFrom());
		System.out.println(t.getTo());
		System.out.println(t.getPricePaid());
		
	}
	
	public BookingDetails fetchBookingDetails()
	{
		return bd;
	}
	
	

}
