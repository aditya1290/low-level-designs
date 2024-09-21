package ParkingLot.Model.Vehicle;

import ParkingLot.Enum.VehicleType;
import ParkingLot.Model.BaseModel;

public abstract class Vehicle extends BaseModel {

    private final VehicleType vehicleType;
    private final String registrationNumber;

    public Vehicle(String id, String registrationNumber, VehicleType vehicleType) {
        super(id);
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
}
