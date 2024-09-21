package ParkingLot.Strategy;

import ParkingLot.Model.Payment.IPayment;

public class CashPaymentStrategy implements IPayment {

    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid via cash");
        return true;
    }
}
