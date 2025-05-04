package com.carrental.service;

import com.carrental.model.Booking;
import com.carrental.model.SOSRequest;
import com.carrental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SOSService {

    @Autowired
    private BookingRepository bookingRepository;

    public String handleCarIssue(Long bookingId, String issueDescription, String imageUrl) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        // Simulate SMS to admin
        String smsMessage = String.format(
                "Car Issue - Trip ID: %s, User: %s, Issue: %s, Image: %s. Please call user at %s.",
                booking.getTripId(), booking.getUserEmail(), issueDescription, imageUrl,
                booking.getTravelerPhoneNumbers());
        System.out.println("SMS Sent to Admin: " + smsMessage);

        return "Car issue reported. Admin will contact you soon.";
    }

    public String handleLifeIssue(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        // Simulate SMS to admin
        String smsMessage = String.format(
                "Life Emergency - Trip ID: %s, User: %s. Call immediately at %s.",
                booking.getTripId(), booking.getUserEmail(), booking.getTravelerPhoneNumbers());
        System.out.println("SMS Sent to Admin: " + smsMessage);

        return "Life emergency reported. Help is on the way.";
    }

    public Object createSOSRequest(SOSRequest sosRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSOSRequest'");
    }
}