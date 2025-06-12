package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Flight;

public interface FlightService {
    public List<Flight> getFlights();
    public List<Flight> getFlightsForPre();
    public Flight createFlight(Flight flight);
    public Optional<Flight> updateFlight(Long flightId, Flight flightDeatils);
    public Flight getFlightById(Long flightId);
    public boolean removeFlight(Long flightId);
}
