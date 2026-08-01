package com.pswe03.patrones;

class TravelSystem {
    private final Flight flight;
    private final Hotel hotel;
    private final CarRental carRental;

    TravelSystem() {
        this(new Flight(), new Hotel(), new CarRental());
    }

    TravelSystem(Flight flight, Hotel hotel, CarRental carRental) {
        this.flight = flight;
        this.hotel = hotel;
        this.carRental = carRental;
    }

    public void book() {
        flight.reserve();
        hotel.reserve();
        carRental.reserve();
    }
}

class Flight {
    public void reserve() { System.out.println("Flight reserved"); }
}

class Hotel {
    public void reserve() { System.out.println("Hotel reserved"); }
}

class CarRental {
    public void reserve() { System.out.println("Car reserved"); }
}
