package com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;

import com.codeclan.example.CourseBookingSystem.models.Customer;

import java.util.List;


public interface CustomerRepositoryCustom {

    List<Customer> allCustomersForAGivenCourse(Long courseId);
    List<Customer> allCustomersForAGivenCourseAndTown(Long courseId, String town);
    List<Customer> allCustomersForAGivenCourseAndTownAndOverACertainAge(Long courseId, String town, int age);
}
