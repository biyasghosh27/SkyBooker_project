package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Flight;
import com.examly.springapp.service.FlightService;

@RestController
public class TestController {
    FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/api/test/welcome")
    public String testWelcomeApi (){
        return "Welcome to the Flight Booking Application";
    }

    @GetMapping("api/test/flights")
    public List<Flight> showFlights(){
        return flightService.getFlightsForPre();
    }
    
}
