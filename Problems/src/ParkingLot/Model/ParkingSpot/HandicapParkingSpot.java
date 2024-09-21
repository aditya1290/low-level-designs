package ParkingLot.Model.ParkingSpot;

import ParkingLot.Enum.ParkingSpotType;

public class HandicapParkingSpot extends ParkingSpot{
    public HandicapParkingSpot(int id, String floorId){
        super(id, ParkingSpotType.HANDICAP, floorId);
    }
}
