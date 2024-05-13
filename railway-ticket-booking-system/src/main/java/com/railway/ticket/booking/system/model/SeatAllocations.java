package com.railway.ticket.booking.system.model;

public class SeatAllocations {
	private String sectionName;
	private int noOfSeat;
	
	
	public SeatAllocations(String sectionName, int noOfSeat) {
		// TODO Auto-generated constructor stub
		this.sectionName=sectionName;
		this.noOfSeat=noOfSeat;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public int getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}
	

}
