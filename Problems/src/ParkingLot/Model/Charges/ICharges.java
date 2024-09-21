package ParkingLot.Model.Charges;

public interface ICharges {

    default double calculate(long timeInMilliSecond){
        return Math.ceil((timeInMilliSecond/3600.0)*ratePerHour());
    }

    double ratePerHour();
}
