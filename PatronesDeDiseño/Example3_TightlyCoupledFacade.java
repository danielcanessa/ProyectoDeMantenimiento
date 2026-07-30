
public class TravelSystem {
    public void book() {
        Flight flight = new Flight();
        Hotel hotel = new Hotel();
        CarRental car = new CarRental();
        flight.reserve();
        hotel.reserve();
        car.reserve();
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
