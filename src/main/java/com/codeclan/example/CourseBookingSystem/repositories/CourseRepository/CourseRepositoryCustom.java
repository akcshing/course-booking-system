package com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;

import com.codeclan.example.CourseBookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> allCoursesForAGivenCustomer(Long customerId);
}
