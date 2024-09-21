package ParkingLot.Strategy;

import ParkingLot.Model.Payment.IPayment;

import java.util.Random;

public class CardPaymentStrategy implements IPayment {
    @Override
    public boolean pay(double amount) {
        // To make it random, and failing it sometimes
        boolean x = new Random().nextInt(2) == 1;
        if(x){
            System.out.println(amount + " paid via card");
        }
        return x;
    }
}
