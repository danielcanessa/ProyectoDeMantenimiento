package com.pswe03.patrones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Example3_TightlyCoupledFacadeTest {

    @Test
    void originalApiBooksTheCompleteTrip() {
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));

        try {
            new TravelSystem().book();
        } finally {
            System.setOut(originalOutput);
        }

        String expected = String.join(
                System.lineSeparator(),
                "Flight reserved",
                "Hotel reserved",
                "Car reserved") + System.lineSeparator();
        assertEquals(expected, capturedOutput.toString(StandardCharsets.UTF_8));
    }

    @Test
    void bookingReservesFlightHotelAndCarInOrder() {
        List<String> reservations = new ArrayList<>();
        Flight flight = new Flight() {
            @Override
            public void reserve() {
                reservations.add("flight");
            }
        };
        Hotel hotel = new Hotel() {
            @Override
            public void reserve() {
                reservations.add("hotel");
            }
        };
        CarRental carRental = new CarRental() {
            @Override
            public void reserve() {
                reservations.add("car");
            }
        };
        TravelSystem travelSystem = new TravelSystem(flight, hotel, carRental);

        travelSystem.book();

        assertEquals(List.of("flight", "hotel", "car"), reservations);
    }
}
