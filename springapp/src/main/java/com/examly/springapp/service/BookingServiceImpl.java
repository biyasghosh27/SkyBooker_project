package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.SeatsExceededException;
import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public Booking createBooking(Booking booking) {
        try{
            return bookingRepo.save(booking);
        }catch(SeatsExceededException e){

        }
        
    }

    @Override
    public Booking getBookingById(Long id) {
        Optional<Booking> bop = bookingRepo.findById(id);
        if(bop.isEmpty()){
            throw new RuntimeException();
        }
        return bop.get();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Optional<Booking> bop = bookingRepo.findById(id);
        if(bop.isEmpty()){
            throw new RuntimeException();
        }
        Booking b = bop.get();
        b.setBookingDate(booking.getBookingDate());
        b.setFlight(booking.getFlight());
        b.setNumberOfPassengers(booking.getNumberOfPassengers());
        b.setStatus(booking.getStatus());
        return bookingRepo.save(b);
    }
    
}
