package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Booking;
import com.examly.springapp.service.BookingService;

@RestController
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/api/bookings")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
        bookingService.createBooking(booking);
        return new ResponseEntity<>(booking,HttpStatus.CREATED);
    }

    @GetMapping("/api/bookings/{id}")
    public ResponseEntity<Booking> getBookById(@PathVariable Long id){
        Booking booking = bookingService.getBookingById(id);
        if(booking != null){
            return new ResponseEntity<>(booking,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/bookings")
    public ResponseEntity<List<Booking>> getAllBooking(){
        List<Booking> blist = bookingService.getAllBookings();
        return new ResponseEntity<>(blist,HttpStatus.OK);
    }

    @PutMapping("/api/bookings/{id}")
    public ResponseEntity<Booking> modifyBooking(@PathVariable Long id, @RequestBody Booking booking){
        Booking b = bookingService.updateBooking(id, booking);
        if(b!= null){
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/bookings/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable int userId){
        return bookingService.getBookingsByUserId(userId);
    }
    
}
