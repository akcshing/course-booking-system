package com.codeclan.example.CourseBookingSystem;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetCoursesWithGivenRating(){
		List<Course> found = courseRepository.findCourseByStarRating(5);
		assertEquals(1, found.size());

		assertEquals("Software", found.get(0).getName());
	}

	@Test
	public void canGetCustomersOfCourse(){
		List<Customer> found = customerRepository.allCustomersForAGivenCourse(2L);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCoursesForCustomer(){
		List<Course> found = courseRepository.allCoursesForAGivenCustomer(1L);
		assertEquals(2,found.size());

		assertEquals("Software", found.get(0).getName());
		assertEquals("Graphic Design", found.get(1).getName());
	}

	@Test
	public void canGetBookingsByDate(){
		List<Booking> result = bookingRepository.findBookingsByDate("18-02-2019");
		assertEquals(2, result.size());
	}

	@Test
	public void canGetAllCustomersInAGivenTownForAGivenCourse(){
		List<Customer> result = customerRepository.allCustomersForAGivenCourseAndTown(2L, "Glasgow");
		assertEquals(1, result.size());

		assertEquals("Pauline", result.get(0).getName());
	}

	@Test
	public void canGetAllCustomersInAGivenTownForAGivenCourseOverACertainAge(){
		List<Customer> result = customerRepository.allCustomersForAGivenCourseAndTownAndOverACertainAge(2L, "Glasgow", 23);
		assertEquals(1, result.size());

		assertEquals("Pauline", result.get(0).getName());
	}

}
