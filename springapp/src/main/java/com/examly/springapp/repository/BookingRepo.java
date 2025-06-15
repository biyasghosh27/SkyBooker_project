package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Flight;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long>{
    @Query("Select coalesce(sum(b.numberOfPassengers),0) from Booking b where b.flight = :flight")
    int countPassengersByFlight(@Param("flight") Flight flight);

    //List<Booking> findByUserUserId(int userId);
}
