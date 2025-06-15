package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.service.BookingService;
import com.examly.springapp.service.BookingServiceImpl;

@RestController
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/api/bookings")
    public ResponseEntity<Booking> 
    
}
