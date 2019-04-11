package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Alex", "Edinburgh", 25);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Pauline", "Glasgow", 50);
        customerRepository.save(customer2);

        Course course1 = new Course("Software", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Graphic Design", "Aberdeen", 3);
        courseRepository.save(course2);

        Booking booking1 = new Booking("19-01-2019", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("18-02-2019", course2, customer1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("18-02-2019", course2, customer2);
        bookingRepository.save(booking3);

    }

}
