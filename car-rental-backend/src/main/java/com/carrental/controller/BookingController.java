package com.carrental.controller;

import com.carrental.model.Booking;
import com.carrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(booking);
    }

    public static class BookingRequest {
        private Long carId;
        private String userEmail;
        private String destination;
        private int numberOfDays;
        private boolean travelingAlone;
        private int numberOfTravelers;
        private String travelerPhoneNumbers;
        private String dropOffPoint;
        private String purpose;
        private String pickupPoint;
        private boolean firstTimeBooking;
        private LocalDate startDate;
        private LocalDate endDate;

        // Getters and Setters
        public Long getCarId() {
            return carId;
        }

        public void setCarId(Long carId) {
            this.carId = carId;
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
    }
}