package com.examly.springapp.model;

public class Flight {
    private long flightId;
    private String flightNumber;
    private String airline;
    private String departureLocation;
    private String arrivalLocation;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private int totalSeats;
    
    public long getFlightId() {
        return flightId;
    }
    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getDepartureLocation() {
        return departureLocation;
    }
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }
    public String getArrivalLocation() {
        return arrivalLocation;
    }
    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    public Flight(long flightId, String flightNumber, String airline, String departureLocation, String arrivalLocation,
            String departureTime, String arrivalTime, double price, int totalSeats) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.totalSeats = totalSeats;
    }
    public Flight() {
    }

    
    
}
