package com.railway.ticket.booking.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.ticket.booking.system.dao.PassengerRepository;
import com.railway.ticket.booking.system.entity.Passenger;

@RestController
@RequestMapping("/passenger")
public class PassangerController {
	
	@Autowired
	PassengerRepository prepository;
	
	@PostMapping("/create")
	public String createPassanger(@RequestBody Passenger p)
	{
		Passenger ps=prepository.save(p);
		return ps.toString();
	}
	
	@GetMapping("/all")
	public List<Passenger> getAllPassanger()
	{
		return prepository.findAll();
	}

}
