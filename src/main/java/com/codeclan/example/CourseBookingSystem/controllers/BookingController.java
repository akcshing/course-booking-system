package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings/")

public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/date/{date}")
    public List<Booking> getBookingsByDate(@PathVariable String date){
        return bookingRepository.findBookingsByDate(date);
    }
}
