package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("rating/{starRating}")
    public List<Course> getCoursesByStarRating(@PathVariable int starRating){
        return courseRepository.findCourseByStarRating(starRating);
    }

    @GetMapping("customer/{customerId}")
    public List<Course> getCoursesByCustomer(@PathVariable Long customerId){
        return courseRepository.allCoursesForAGivenCustomer(customerId);
    }


}
