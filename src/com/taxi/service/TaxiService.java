package com.taxi.service;

import com.taxi.model.Taxi;
import com.taxi.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    private List<Taxi> taxis;
    private static int bookingCounter = 1;

    public TaxiService(int taxiCount) {
        taxis = new ArrayList<>();

        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }
    public void bookTaxi(int customerId, char from, char to, int pickupTime) {

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {

            // Taxi must be free
            if (taxi.getFreeTime() <= pickupTime) {

                int distance = Math.abs(taxi.getCurrentLocation() - from);

                if (selectedTaxi == null) {
                    selectedTaxi = taxi;
                    minDistance = distance;
                }

                else {

                    if (distance < minDistance) {
                        selectedTaxi = taxi;
                        minDistance = distance;
                    }

                    else if (distance == minDistance) {

                        if (taxi.getTotalEarnings() < selectedTaxi.getTotalEarnings()) {
                            selectedTaxi = taxi;
                        }
                    }
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("Booking Rejected. No taxi available.");
            return;
        }

        int travelPoints = Math.abs(to - from);
        int dropTime = pickupTime + travelPoints;

        int distanceKm = travelPoints * 15;
        int fare = calculateFare(distanceKm);

        Booking booking = new Booking(
                bookingCounter++,
                customerId,
                from,
                to,
                pickupTime,
                dropTime,
                fare
        );

        selectedTaxi.setCurrentLocation(to);
        selectedTaxi.setFreeTime(dropTime);
        selectedTaxi.setTotalEarnings(selectedTaxi.getTotalEarnings() + fare);
        selectedTaxi.getBookings().add(booking);

        System.out.println("Taxi-" + selectedTaxi.getTaxiId() + " is allotted.");
    }

    private int calculateFare(int distanceKm) {

        if (distanceKm <= 5)
            return 100;
        else
            return 100 + (distanceKm - 5) * 10;
    }

    public void displayTaxiDetails() {

        for (Taxi taxi : taxis) {

            if (taxi.getBookings().isEmpty())
                continue;

            System.out.println("\nTaxi-" + taxi.getTaxiId() +
                    " Total Earnings: Rs. " + taxi.getTotalEarnings());

            System.out.println("BookingID CustomerID From To PickupTime DropTime Amount");

            for (Booking b : taxi.getBookings()) {

                System.out.println(
                        b.getBookingId() + "        " +
                        b.getCustomerId() + "        " +
                        b.getFrom() + "    " +
                        b.getTo() + "    " +
                        b.getPickupTime() + "        " +
                        b.getDropTime() + "        " +
                        b.getAmount()
                );
            }
        }
    }
}
