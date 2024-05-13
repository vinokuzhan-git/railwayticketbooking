package com.railway.ticket.booking.system.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.entity.SeatAllocation;
import com.railway.ticket.booking.system.projection.SeatBookingProjection;

@Repository
public interface SeatAllocationRepository extends JpaRepository<SeatAllocation,String> {
	
	List<SeatAllocation> findBySectionName(String sectionName);

/*	@Query("SELECT NEW com.railway.ticket.booking.system.projection.SeatBookingProjection(s, bd, p)\r\n"
			+ "FROM SeatAllocation sa, BookingDetails bd, Passenger p\r\n"
			+ "WHERE sa.saId = bd.saId AND bd.email = p.email")
	List<SeatBookingProjection> findSeatsWithPassengerDetailsBySectionName(String sectionName); */

	@EntityGraph(attributePaths = {"passenger"})
    List<SeatAllocation> findAll();
	
	@Modifying
	@Query("UPDATE SeatAllocation sa SET sa.email = NULL, sa.status = 'N' WHERE sa.seatNo = :seatNo AND sa.sectionName = :sectionName AND sa.status = 'Y'")
	int updateSeatAllocationStatusAndSeatNo(@Param("seatNo") int seatNo,
	                                        @Param("sectionName") String sectionName);


}