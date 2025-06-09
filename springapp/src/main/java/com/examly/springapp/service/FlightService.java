package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Flight;

@Service
public class FlightService {
    List<Flight> flightList = new ArrayList<>();
    
    public FlightService(){
        Flight f1 = new Flight(1001,"123456","Indigo","Delhi","Mumbai","10:20 AM","4:30 PM",1200.0,60);
        Flight f2 = new Flight();
        FLight f3 = new Flight();
    }
    public List<Flight> geFlights(){
        return flightList;
    }

}
