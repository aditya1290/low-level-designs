package ParkingLot.Model.Charges;

public class ElectricCharges implements ICharges{
    @Override
    public double ratePerHour() {
        return 2;
    }
}
