package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@RequestMapping("/customers")


public class CustomerController extends WebConfig {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("course/{courseId}")
    public List<Customer> getAllCustomersForAGivenCourse(@PathVariable Long courseId){

        return customerRepository.allCustomersForAGivenCourse(courseId);
    }

    @GetMapping("course/{courseId}/town/{town}")
    public List<Customer> getAllCustomersInGivenTownForAGivenCourse(@PathVariable Long courseId, @PathVariable String town){
        return customerRepository.allCustomersForAGivenCourseAndTown(courseId, town);
    }

    @GetMapping("course/{courseId}/town/{town}/age/{age}")
    public List<Customer> getAllCustomersInGivenTownForAGivenCourseOverACertainAge(@PathVariable Long courseId, @PathVariable String town, @PathVariable int age){
        return customerRepository.allCustomersForAGivenCourseAndTownAndOverACertainAge(courseId, town, age);
    }


}
