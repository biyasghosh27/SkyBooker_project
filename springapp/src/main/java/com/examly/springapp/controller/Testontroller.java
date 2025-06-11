package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Flight;
import com.examly.springapp.service.FlightService;

@RestController
public class Testontroller {
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
