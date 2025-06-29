package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String bookingDate;
    private int numberOfPassengers;
    private String status;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;
    private User user;
    
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
