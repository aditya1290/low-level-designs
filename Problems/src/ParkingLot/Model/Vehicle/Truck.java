package ParkingLot.Model.Vehicle;

import ParkingLot.Enum.VehicleType;

public class Truck extends Vehicle {
    public Truck(String id, String registrationNumber) {
        super(id, registrationNumber, VehicleType.TRUCK);
    }
}
