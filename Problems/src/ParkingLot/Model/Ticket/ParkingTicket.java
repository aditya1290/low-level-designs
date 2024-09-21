package ParkingLot.Model.Ticket;

import ParkingLot.Enum.ParkingTicketStatus;
import ParkingLot.Exceptions.PaymentException;
import ParkingLot.Model.ParkingSpot.ParkingSpot;
import ParkingLot.Model.Payment.IPayment;
import ParkingLot.Model.Vehicle.Vehicle;
import ParkingLot.Util.ChargeCalculator;
import lombok.Getter;

import java.time.Instant;

public class ParkingTicket {

    private final long startTime;
    private long endTime;

    @Getter
    private ParkingTicketStatus status;

    @Getter
    private final ParkingSpot spot;
    private Vehicle vehicle;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        startTime = Instant.now().toEpochMilli();
        status = ParkingTicketStatus.ACTIVE;
        this.vehicle = vehicle;
        this.spot = parkingSpot;
    }

    public boolean isValid(){
        return !spot.isSpotFree() && status.equals(ParkingTicketStatus.ACTIVE);
    }

    public void close(IPayment pts) throws PaymentException{
        long endTime = Instant.now().toEpochMilli();
        double charges = ChargeCalculator.calculator(endTime-startTime, spot.getParkingSpotType());
        boolean paid = pts.pay(charges);
        if(!paid){
            throw new PaymentException();
        }
        status = ParkingTicketStatus.COMPLETED;
        this.endTime = endTime;
        vehicle = null;
    }

}
