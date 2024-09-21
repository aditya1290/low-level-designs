package ParkingLot.Util;

import ParkingLot.Enum.VehicleType;
import ParkingLot.Model.Vehicle.*;

public class VehicleFactory {
    public static Vehicle create(String id, VehicleType vehicleType, String registrationNumber){
        return switch (vehicleType){
            case CAR -> new Car(id, registrationNumber);
            case MOTORBIKE -> new Bike(id,registrationNumber);
            case ELECTRIC -> new Electric(id, registrationNumber);
            case TRUCK -> new Truck(id, registrationNumber);
            default -> null;
        };
    }
}
