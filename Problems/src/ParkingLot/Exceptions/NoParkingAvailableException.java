package ParkingLot.Exceptions;

public class NoParkingAvailableException extends Exception{
    public NoParkingAvailableException() {
        super("No Parking Available for asked ParkingType");
    }
}
