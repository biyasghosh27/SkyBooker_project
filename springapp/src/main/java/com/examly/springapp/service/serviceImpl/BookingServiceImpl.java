package com.examly.springapp.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        Optional<Booking> bop = bookingRepo.findById(id);
        if(bop.isEmpty()){
            return null;//exception throw
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
            return null;//exception throw
        }
        Booking b = bop.get();
        b.setBookingDate(booking.getBookingDate());
        b.setFlight(booking.getFlight());
        b.setNumberOfPassengers(booking.getNumberOfPassengers());
        b.setStatus(booking.getStatus());
        return bookingRepo.save(booking);
    }
    
}
