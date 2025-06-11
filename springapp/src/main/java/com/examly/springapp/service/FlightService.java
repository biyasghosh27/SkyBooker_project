package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Flight;

public interface FlightService {
    public List<Flight> getFlights();
    public List<Flight> getFlightsForPre();
    public Flight createFlight(Flight flight);
    public Optional<Flight> updateFlight(long flightId, Flight flightDeatils);
    public Flight getFlightById(long flightId);
    public boolean removeFlight(long flightId);
}
