package ParkingLot.Exceptions;

public class PaymentException extends Exception{
    public PaymentException(){
        super("Payment failed");
    }
}
