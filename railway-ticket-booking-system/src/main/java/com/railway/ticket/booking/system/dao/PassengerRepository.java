package com.railway.ticket.booking.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.ticket.booking.system.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,String> {

}
