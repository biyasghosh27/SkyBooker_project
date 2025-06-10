package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Flight;

public interface FlightService {
    public List<Flight> getFlights();
    public Flight createFlight(Flight flight);
    public Optional<Flight> updateFlight(int flightId, Flight flightDeatils);
}
