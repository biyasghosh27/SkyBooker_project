package com.examly.springapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Flight;
import com.examly.springapp.repository.FlightRepo;
import com.examly.springapp.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepo flightRepo;

    List<Flight> flightListpre = new ArrayList<>();
    //List<Flight> flightList = new ArrayList<>();
    
    public FlightServiceImpl(){
        Flight f1 = new Flight(1001,"123456","Indigo","Delhi","Mumbai","10:20 AM","4:30 PM",1200.0,60);
        Flight f2 = new Flight(1002,"234567","Air India","Kolkata","Dubai","4:00 AM","2:00 PM",2341.0,90);
        Flight f3 = new Flight(1003,"345678","Emirates","Chennai","Bhubaneswar","8:00 PM","1:00 AM",900.67,120);

        flightListpre.add(f1);
        flightListpre.add(f2);
        flightListpre.add(f3);
    }
    
    public List<Flight> getFlightsForPre(){
        return flightListpre;
    }

    public Flight createFlight(Flight flight){
        flightRepo.save(flight);
        return flight;
    }

    public Optional<Flight> updateFlight(long flightId, Flight flightDeatils){
        Optional<Flight> optionalFlight = flightRepo.findById(flightId);
        if(optionalFlight.isEmpty()){
           throw new RuntimeException("error"); 
        }
        Flight updatedFlight = flightRepo.save(flightDeatils);
        Optional<Flight> optionalUpdated = Optional.of(updatedFlight);
        return optionalUpdated;
    }

    public List<Flight> getFlights(){
        return flightListpre;
    }

    public Flight getFlightById(long flightId){
        Optional<Flight> optionalFlight = flightRepo.findById(flightId);
        if(optionalFlight.isEmpty()){
            throw new RuntimeException("");
        }
        Flight flight = optionalFlight.get();
        return flight;
    }

    public boolean removeFlight(long flightId){
        Optional<Flight> optionalFlight = flightRepo.findById(flightId); 
        if(optionalFlight.isEmpty()){
            return false;
        }
        Flight flight = optionalFlight.get();
        flightRepo.delete(flight);
        return true;
    }

}
