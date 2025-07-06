package com.examly.springapp.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.SeatsExceededException;
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Flight;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.repository.FlightRepo;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

    private BookingRepo bookingRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    public void setBookingRepo(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking createBooking(Booking booking) {
        
        //fetching full flight from db
        long flightId = booking.getFlight().getFlightId();
        Flight flight = flightRepo.findById(flightId).orElseThrow(()->
        new RuntimeException("Flight not found"));

        //fetching anf validating user
        int userId = booking.getUser().getUserId();
        User user = userRepo.findById(userId).orElseThrow(()->
        new RuntimeException("User not found"));
        
        //check seat availability
        int alreadyBooked = bookingRepo.countPassengersByFlight(flight);
        int newPassengers = booking.getNumberOfPassengers();

        if(alreadyBooked + newPassengers > flight.getTotalSeats()){
            throw new SeatsExceededException("Booking failed. Only " + (flight.getTotalSeats()-alreadyBooked) + " seats are left");
        }

        //decrease total seats
        int updatedSeats = flight.getTotalSeats() - newPassengers;
        flight.setTotalSeats(updatedSeats);
        
        //saving it to db
        flightRepo.save(flight);

        //attaching the updated flight and user to booking before saving
        booking.setFlight(flight);
        booking.setUser(user);
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
        //fetching existing booking
        Booking existing = bookingRepo.findById(id).orElse(null);
        if(existing==null)return null;

        //flight from the booking
        Flight flight = flightRepo.findById(existing.getFlight().getFlightId()).orElseThrow(()->
        new RuntimeException("Flight not found"));

        //user from the booking
        int userId = booking.getUser().getUserId();
        User user = userRepo.findById(userId).orElseThrow(()->
        new RuntimeException("User not found"));

        int totalBooked = bookingRepo.countPassengersByFlight(flight);
        int oldCount = existing.getNumberOfPassengers();
        int newCount = booking.getNumberOfPassengers();
        int change = newCount - oldCount;
        if(totalBooked + change > flight.getTotalSeats()){
            throw new SeatsExceededException("Cannot update. Only " + (flight.getTotalSeats()-totalBooked) + " additional seats available.");
        }

        //adjusting the total seats
        flight.setTotalSeats(flight.getTotalSeats()-change);//reduce if increase, increase if decrease
        flightRepo.save(flight);//persist the seat change

        //updating booking info
        //we are not using setters for user or flight here because they are not updating in the logic
        //its the same user and same flight assigned to this booking
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
