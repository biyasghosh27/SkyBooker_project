package com.examly.springapp.service.serviceImpl;

import java.util.List;

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
    public Booking getBookingById(long id) {
        Optional<Booking> 
    }

    @Override
    public List<Booking> getAllBookings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBookings'");
    }

    @Override
    public Booking updateBooking(long id, Booking booking) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }
    
}
