package com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;

import com.codeclan.example.CourseBookingSystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;
    @Transactional

    public List<Course> allCoursesForAGivenCustomer(Long customerId){
        List<Course> results =null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.customer.id", customerId));
            results = cr.list();
        }  catch(HibernateException ex){
        ex.printStackTrace();
    } finally {
        session.close();
    }
        return results;
}


}
