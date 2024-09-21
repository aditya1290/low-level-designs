package ParkingLot.Model.Vehicle;

import ParkingLot.Enum.VehicleType;

public class Bike extends Vehicle {
    public Bike(String id, String registrationNumber) {
        super(id, registrationNumber, VehicleType.MOTORBIKE);
    }
}
