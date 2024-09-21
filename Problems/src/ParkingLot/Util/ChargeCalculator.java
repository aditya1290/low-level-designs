package ParkingLot.Util;

import ParkingLot.Enum.ParkingSpotType;
import ParkingLot.Model.Charges.BikeCharges;
import ParkingLot.Model.Charges.CarCharges;
import ParkingLot.Model.Charges.ElectricCharges;
import ParkingLot.Model.Charges.HandicapCharges;

public class ChargeCalculator {

    public static double calculator(long timeElapsedInMillis, ParkingSpotType parkingSpotType){
        double charge = 0;
        switch(parkingSpotType){
            case ELECTRIC -> charge = new ElectricCharges().calculate(timeElapsedInMillis);
            case BIKE -> charge = new BikeCharges().calculate(timeElapsedInMillis);
            case HANDICAP -> charge = new HandicapCharges().calculate(timeElapsedInMillis);
            case LARGE -> charge = new CarCharges().calculate(timeElapsedInMillis);
        }
        return charge;
    }

}
