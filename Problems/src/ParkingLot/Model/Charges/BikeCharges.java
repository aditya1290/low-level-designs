package ParkingLot.Model.Charges;

public class BikeCharges implements ICharges{
    @Override
    public double ratePerHour() {
        return 0.5;
    }
}
