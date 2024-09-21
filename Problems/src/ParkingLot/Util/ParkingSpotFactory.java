package ParkingLot.Util;

import ParkingLot.Enum.ParkingSpotType;
import ParkingLot.Model.ParkingSpot.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotFactory {

    public static List<ParkingSpot> create(ParkingSpotType parkingSpotType, List<Integer>ids, String floorId){
        List<ParkingSpot> ps = new ArrayList<>();
        switch(parkingSpotType){
            case LARGE -> ids.forEach(x -> ps.add(new LargeParkingSpot(x, floorId)));
            case HANDICAP -> ids.forEach(x -> ps.add(new HandicapParkingSpot(x, floorId)));
            case ELECTRIC -> ids.forEach(x -> ps.add(new ElectricParkingSpot(x, floorId)));
            case BIKE -> ids.forEach(x -> ps.add(new BikeParkingSpot(x, floorId)));
        }
        return ps;
    }

}
