package com.examly.springapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Flight;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.repository.FlightRepo;
import com.examly.springapp.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    BookingRepo bookingRepo;

    // List<Flight> flightListpre = new ArrayList<>();
    List<Flight> flightList = new ArrayList<>();
    
    public FlightServiceImpl(){
        Flight f1 = new Flight((long)1,"123456","Indigo","Delhi","Mumbai","10:20 AM","4:30 PM",1200.0,60);
        Flight f2 = new Flight((long)2,"234567","Air India","Kolkata","Dubai","4:00 AM","2:00 PM",2341.0,90);
        Flight f3 = new Flight((long) 3,"345678","Emirates","Chennai","Bhubaneswar","8:00 PM","1:00 AM",900.67,120);

        flightList.add(f1);
        flightList.add(f2);
        flightList.add(f3);
    }
    
    public List<Flight> getFlightsForPre(){
        return flightList;
    }

    public Flight createFlight(Flight flight){
        flightRepo.save(flight);
        flightList.add(flight);
        return flight;
    }

    public Optional<Flight> updateFlight(Long flightId, Flight flightDeatils){
        Optional<Flight> optionalFlight = flightRepo.findById(flightId);
        if(optionalFlight.isEmpty()){
           throw new RuntimeException(); 
        }
        Flight updatedFlight = flightRepo.save(flightDeatils);
        Optional<Flight> optionalUpdated = Optional.of(updatedFlight);
        return optionalUpdated;
    }

    public List<Flight> getFlights(){
        return flightRepo.findAll();
    }

    public Flight getFlightById(Long flightId){
        Optional<Flight> optionalFlight = flightRepo.findById(flightId);
        if(optionalFlight.isEmpty()){
            throw new RuntimeException();
        }
        Flight flight = optionalFlight.get();
        return flight;
    }

    public boolean removeFlight(Long flightId){
        Optional<Flight> optionalFlight = flightRepo.findById(flightId); 
        if(optionalFlight.isEmpty()){
            return false;
        }
        //deleting bookings manually before deleting the flight
        List<Booking> bookings = bookingRepo.findByFlightFlightId(flightId);
        bookingRepo.deleteAll(bookings);
        Flight flight = optionalFlight.get();
        flightRepo.delete(flight);
        return true;
    }

}

