package com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;

import com.codeclan.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    List<Customer> allCustomersForAGivenCourse(Long courseId);
    List<Customer> allCustomersForAGivenCourseAndTown(Long courseId, String town);
    List<Customer> allCustomersForAGivenCourseAndTownAndOverACertainAge(Long courseId, String town, int age);
}
