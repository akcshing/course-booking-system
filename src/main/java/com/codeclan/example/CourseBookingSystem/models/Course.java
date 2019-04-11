package com.codeclan.example.CourseBookingSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "courses")


public class Course {

    @Column(name = "name")
    private String name;
    @Column(name = "town")
    private String town;
    @Column(name = "starRating")
    private int starRating;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnoreProperties("courses")
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)

    private List<Booking> bookings;


    public void Course(){}

    public void Course(String name, String town, int starRating){
        this.name = name;
        this.town =town;
        this.starRating = starRating;
        this.bookings = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBookings(Booking booking) {
        this.bookings.add(booking);
    }
}