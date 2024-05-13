package com.railway.ticket.booking.system.model;

import com.railway.ticket.booking.system.entity.SeatAllocation;

public class Ticket {
	private String from;
	private String to;
	private PassengerDetails pd;
	private SeatAllocation sa;
	private double pricePaid;
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
	public PassengerDetails getPd() {
		return pd;
	}
	public void setPd(PassengerDetails pd) {
		this.pd = pd;
	}
	public SeatAllocation getSa() {
		return sa;
	}
	public void setSa(SeatAllocation sa) {
		this.sa = sa;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	@Override
	public String toString() {
		return "Ticket [from=" + from + ", to=" + to + ", pd=" + pd + ", sa=" + sa + ", pricePaid=" + pricePaid + "]";
	}
	

}
