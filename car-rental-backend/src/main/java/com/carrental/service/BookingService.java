package com.carrental.service;

import com.carrental.controller.BookingController;
import com.carrental.model.Booking;
import com.carrental.model.Car;
import com.carrental.repository.BookingRepository;
import com.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    public Booking createBooking(BookingController.BookingRequest request) {
        if (request.getStartDate().isAfter(request.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }

        Car car = carRepository.findById(request.getCarId())
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));

        Booking booking = new Booking();
        booking.setCar(car);
        booking.setUserEmail(request.getUserEmail());
        booking.setDestination(request.getDestination());
        booking.setNumberOfDays(request.getNumberOfDays());
        booking.setTravelingAlone(request.isTravelingAlone());
        booking.setNumberOfTravelers(request.getNumberOfTravelers());
        booking.setTravelerPhoneNumbers(request.getTravelerPhoneNumbers());
        booking.setDropOffPoint(request.getDropOffPoint());
        booking.setPurpose(request.getPurpose());
        booking.setPickupPoint(request.getPickupPoint());
        booking.setFirstTimeBooking(request.isFirstTimeBooking());
        booking.setStartDate(request.getStartDate());
        booking.setEndDate(request.getEndDate());
        booking.setBookingDate(LocalDateTime.now());

        // Calculate total cost (daily rate * days + ₹500 for first-time)
        double totalCost = car.getDailyRate() * request.getNumberOfDays();
        if (request.isFirstTimeBooking()) {
            totalCost += 500;
        }
        booking.setTotalCost(totalCost);

        // Generate tripId (e.g., VAR8790DD)
        String destinationCode = request.getDestination().substring(0, Math.min(3, request.getDestination().length()))
                .toUpperCase();
        String carNumber = car.getCarNumber();
        String userInitials = request.getUserEmail().substring(0, 1).toUpperCase() +
                request.getUserEmail()
                        .substring(request.getUserEmail().indexOf('.') + 1, request.getUserEmail().indexOf('.') + 2)
                        .toUpperCase();
        booking.setTripId(destinationCode + carNumber + userInitials);

        return bookingRepository.save(booking);
    }
}