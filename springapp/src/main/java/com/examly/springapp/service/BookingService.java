package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Booking;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(long id);
    List<Booking> getAllBookings();
    Booking updateBooking(long id, Booking booking);
}
