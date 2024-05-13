package com.railway.ticket.booking.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.projection.SeatAllocationProjection;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Long>{

	BookingDetails findByEmail(String email);
	
	@EntityGraph(attributePaths = {"seatAllocationDetails", "passenger"})
    List<BookingDetails> findAll();
	
    @Query("SELECT new com.railway.ticket.booking.system.projection.SeatAllocationProjection(bd.saId, sa.sectionName, sa.seatNo) FROM BookingDetails bd JOIN SeatAllocation sa ON bd.saId = sa.saId")
    List<SeatAllocationProjection> findAllWithSeatAllocationProjections();
    
    @Modifying
    @Query("UPDATE BookingDetails SET bookingStatus='CANCELLED' WHERE bookingId=:bookingId")
    void cancelBooking(long bookingId);

}
