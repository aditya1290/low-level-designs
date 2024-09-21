package ParkingLot.Model.Vehicle;

import ParkingLot.Enum.VehicleType;

public class Electric extends Vehicle {
    public Electric(String id, String registrationNumber) {
        super(id, registrationNumber, VehicleType.ELECTRIC);
    }
}
