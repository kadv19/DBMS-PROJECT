package com.carrental.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "number_of_days", nullable = false)
    private int numberOfDays;

    @Column(name = "traveling_alone", nullable = false)
    private boolean travelingAlone;

    @Column(name = "number_of_travelers")
    private int numberOfTravelers;

    @Column(name = "traveler_phone_numbers")
    private String travelerPhoneNumbers;

    @Column(name = "drop_off_point", nullable = false)
    private String dropOffPoint;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "pickup_point", nullable = false)
    private String pickupPoint;

    @Column(name = "first_time_booking", nullable = false)
    private boolean firstTimeBooking;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "total_cost", nullable = false)
    private double totalCost;

    @Column(name = "trip_id", nullable = false)
    private String tripId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isTravelingAlone() {
        return travelingAlone;
    }

    public void setTravelingAlone(boolean travelingAlone) {
        this.travelingAlone = travelingAlone;
    }

    public int getNumberOfTravelers() {
        return numberOfTravelers;
    }

    public void setNumberOfTravelers(int numberOfTravelers) {
        this.numberOfTravelers = numberOfTravelers;
    }

    public String getTravelerPhoneNumbers() {
        return travelerPhoneNumbers;
    }

    public void setTravelerPhoneNumbers(String travelerPhoneNumbers) {
        this.travelerPhoneNumbers = travelerPhoneNumbers;
    }

    public String getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(String dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public boolean isFirstTimeBooking() {
        return firstTimeBooking;
    }

    public void setFirstTimeBooking(boolean firstTimeBooking) {
        this.firstTimeBooking = firstTimeBooking;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}