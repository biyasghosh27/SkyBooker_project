package com.examly.springapp.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.SeatsExceededException;
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Flight;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

    private BookingRepo bookingRepo;

    @Autowired
    public void setBookingRepo(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking createBooking(Booking booking) {
    //    Flight flight = booking.getFlight();
    //    int alreadyBooked = bookingRepo.countPassengersByFlight(flight);
    //    int newPassengers = booking.getNumberOfPassengers();
    //    if(alreadyBooked+newPassengers > flight.getTotalSeats()){
    //     throw new SeatsExceededException("Booking failed. Only " + (flight.getTotalSeats()-alreadyBooked) + " seats are left");
    //    }
       return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        Optional<Booking> bop = bookingRepo.findById(id);
        if(bop.isEmpty()){
            return null;
        }
        return bop.get();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking existing = bookingRepo.findById(id).orElse(null);
        if(existing==null)return null;

        Flight flight = existing.getFlight();

        int totalBooked = bookingRepo.countPassengersByFlight(flight);
        int oldCount = existing.getNumberOfPassengers();
        int newCount = booking.getNumberOfPassengers();
        int change = newCount - oldCount;
        if(totalBooked+ change > flight.getTotalSeats()){
            throw new SeatsExceededException("Cannot update. Only " + (flight.getTotalSeats()-totalBooked) + " additional seats available.");
        }
        existing.setNumberOfPassengers(newCount);
        existing.setStatus(booking.getStatus());
        existing.setBookingDate(booking.getBookingDate());
        return bookingRepo.save(existing);
    }

    @Override
    public List<Booking> getBookingsByUserId(int userId) {
        return bookingRepo.findByUserUserId(userId);
    }
    
}
