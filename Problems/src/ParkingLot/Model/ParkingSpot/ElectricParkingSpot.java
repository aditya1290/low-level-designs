package ParkingLot.Model.ParkingSpot;

import ParkingLot.Enum.ParkingSpotType;

public class ElectricParkingSpot extends ParkingSpot{

    public ElectricParkingSpot(int id, String floorId){
        super(id, ParkingSpotType.ELECTRIC, floorId);
    }

}
