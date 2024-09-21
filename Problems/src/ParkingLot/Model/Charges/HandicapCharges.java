package ParkingLot.Model.Charges;

public class HandicapCharges implements ICharges{
    @Override
    public double ratePerHour() {
        return 0.25;
    }
}
