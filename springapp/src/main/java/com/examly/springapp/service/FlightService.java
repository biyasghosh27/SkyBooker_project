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
        Flight f2 = new Flight(1002,"234567","Air India","Kolkata","Dubai","4:00 AM","2:00 PM",2341.0,90);
        Flight f3 = new Flight(1003,"345678","Emirates","Chennai","Bhubaneswar","8:00 PM","1:00 AM",900.67,120);

        flightList.add(f1);
        flightList.add(f2);
        flightList.add(f3);
    }
    
    public List<Flight> geFlights(){
        return flightList;
    }

}
