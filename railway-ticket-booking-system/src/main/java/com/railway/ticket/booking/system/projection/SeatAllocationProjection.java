package com.railway.ticket.booking.system.projection;

public class SeatAllocationProjection {
	
	private String saId;
	private String sectionName;
	private int seatNo;
	public SeatAllocationProjection(String saId, String sectionName, int seatNo) {
		super();
		this.saId = saId;
		this.sectionName = sectionName;
		this.seatNo = seatNo;
	}
	public String getSaId() {
		return saId;
	}
	public void setSaId(String saId) {
		this.saId = saId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	 

}
