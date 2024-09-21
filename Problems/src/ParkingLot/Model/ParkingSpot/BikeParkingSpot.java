package ParkingLot.Model.ParkingSpot;

import ParkingLot.Enum.ParkingSpotType;

public class BikeParkingSpot extends ParkingSpot{

    public BikeParkingSpot(int id, String floorId){
        super(id, ParkingSpotType.BIKE, floorId);
    }

}
