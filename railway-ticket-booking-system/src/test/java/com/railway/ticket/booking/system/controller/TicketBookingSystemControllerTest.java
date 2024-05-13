package com.railway.ticket.booking.system.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.ticket.booking.system.dao.BookingDetailsRepository;
import com.railway.ticket.booking.system.dao.SeatAllocationRepository;
import com.railway.ticket.booking.system.entity.BookingDetails;
import com.railway.ticket.booking.system.entity.Passenger;
import com.railway.ticket.booking.system.entity.SeatAllocation;
import com.railway.ticket.booking.system.model.PassengerDetails;
import com.railway.ticket.booking.system.model.SeatAllocations;
import com.railway.ticket.booking.system.model.Ticket;
import com.railway.ticket.booking.system.service.BookingService;
import com.railway.ticket.booking.system.service.SeatAllocationService;

@WebMvcTest(controllers = {TicketBookingController.class, SeatAllocationController.class})
public class TicketBookingSystemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @MockBean
    private SeatAllocationService seatAllocationService;

    @MockBean
    private BookingDetailsRepository bookingDetailsRepository;

    @MockBean
    private SeatAllocationRepository seatAllocationRepository;

    @InjectMocks
    private TicketBookingController ticketBookingController;

    @InjectMocks
    private SeatAllocationController seatAllocationController;

    public TicketBookingSystemControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookTicket() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setPd(new PassengerDetails("John", "Doe", "john@example.com"));
        ticket.setSa(new SeatAllocation());
        
        when(bookingService.createBooking(any(Ticket.class))).thenReturn(1L);

        mockMvc.perform(post("/ticket/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ticket)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFetchAllTickets() throws Exception {
        List<BookingDetails> bookingDetailsList = Collections.singletonList(new BookingDetails());
        when(bookingService.fetchAll()).thenReturn(bookingDetailsList);

        mockMvc.perform(get("/ticket/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateSeatAllocation() throws Exception {
        SeatAllocations seatAllocations = new SeatAllocations("A", 10);
        when(seatAllocationService.createSection(any(SeatAllocations.class))).thenReturn("Seat Allocation Created Successfully");

        mockMvc.perform(post("/seat/allocation/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(seatAllocations)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFetchAllSeatAllocations() throws Exception {
        List<SeatAllocation> seatAllocationList = Collections.singletonList(new SeatAllocation());
        when(seatAllocationService.fetchAllSections()).thenReturn(seatAllocationList);

        mockMvc.perform(get("/seat/allocation/all"))
                .andExpect(status().isOk());
    }
}
