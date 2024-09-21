package ParkingLot.Model.Vehicle;

import ParkingLot.Enum.VehicleType;

public class Car extends Vehicle {
    public Car(String id, String registrationNumber) {
        super(id, registrationNumber, VehicleType.CAR);
    }
}
