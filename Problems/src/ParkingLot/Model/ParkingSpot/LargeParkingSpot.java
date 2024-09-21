package ParkingLot.Model.ParkingSpot;

import ParkingLot.Enum.ParkingSpotType;

public class LargeParkingSpot extends ParkingSpot{

    public LargeParkingSpot(int id, String floorId){
        super(id, ParkingSpotType.LARGE, floorId);
    }

}
