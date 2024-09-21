package ParkingLot;

import ParkingLot.Enum.ParkingSpotType;
import ParkingLot.Enum.VehicleType;
import ParkingLot.Model.ParkingSpot.ParkingSpot;
import ParkingLot.Model.Ticket.ParkingTicket;
import ParkingLot.Model.Vehicle.Vehicle;
import ParkingLot.Strategy.CardPaymentStrategy;
import ParkingLot.Strategy.CashPaymentStrategy;
import ParkingLot.Util.ParkingSpotFactory;
import ParkingLot.Util.VehicleFactory;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();
        String floorId = "F1";
        List<ParkingSpot> handicapSpots = ParkingSpotFactory.create(ParkingSpotType.HANDICAP, List.of(5,6,12,13), floorId);
        List<ParkingSpot> electricSpots = ParkingSpotFactory.create(ParkingSpotType.ELECTRIC, List.of(2,3,8,9), floorId);
        List<ParkingSpot> largeSports   = ParkingSpotFactory.create(ParkingSpotType.LARGE, List.of(0,1,4,7,10,11), floorId);
        ParkingFloor pf = new ParkingFloor.Builder()
                .with(ParkingSpotType.HANDICAP, handicapSpots)
                .with(ParkingSpotType.ELECTRIC, electricSpots)
                .with(ParkingSpotType.LARGE, largeSports)
                .build(floorId);
        parkingLot.addFloor(pf);

        floorId = "F2";
        List<ParkingSpot> bikeSpots   = ParkingSpotFactory.create(ParkingSpotType.BIKE, List.of(10,1,4,7,12,11), floorId);
        pf = new ParkingFloor.Builder()
                .with(ParkingSpotType.BIKE, bikeSpots)
                .build(floorId);
        parkingLot.addFloor(pf);

        Vehicle v1 = VehicleFactory.create("v1", VehicleType.CAR, "HAND-1");
        Vehicle v2 = VehicleFactory.create("v2", VehicleType.ELECTRIC ,"HAND-2");
        Vehicle v3 = VehicleFactory.create("v3", VehicleType.CAR, "HAND-3");
        Vehicle v4 = VehicleFactory.create("v4", VehicleType.ELECTRIC, "HAND-4");
        Vehicle v5 = VehicleFactory.create("v5", VehicleType.TRUCK, "HAND-5");
        Vehicle v6 = VehicleFactory.create("v6", VehicleType.MOTORBIKE, "BIKE-1");
        Vehicle v7 = VehicleFactory.create("v7", VehicleType.MOTORBIKE, "BIKE-2");

        parkingLot.showDisplay();
        ParkingTicket t1 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.HANDICAP, v1);
        parkingLot.showDisplay();
        ParkingTicket t2 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.HANDICAP,v2);
        parkingLot.showDisplay();
        ParkingTicket t3 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.HANDICAP, v3);
        parkingLot.showDisplay();
        ParkingTicket t4 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.HANDICAP,v4);
        parkingLot.showDisplay();
        ParkingTicket t5 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.HANDICAP, v5);
        parkingLot.showDisplay();

        ParkingTicket t6 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.BIKE, v6);
        ParkingTicket t7 = parkingLot.assignParkingAndGiveTicket(ParkingSpotType.BIKE, v7);

        while(t4 != null){
            if(parkingLot.payAndRelease(t4,new CardPaymentStrategy())){
                t4 = null;
            }
        }
        parkingLot.showDisplay();

        t4 =  parkingLot.assignParkingAndGiveTicket(ParkingSpotType.HANDICAP,v4);
        parkingLot.showDisplay();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("Waiting Interrupted");
        }

        parkingLot.payAndRelease(t5,new CashPaymentStrategy());
        parkingLot.payAndRelease(t4,new CashPaymentStrategy());
        parkingLot.payAndRelease(t3,new CashPaymentStrategy());
        parkingLot.payAndRelease(t2,new CashPaymentStrategy());
        parkingLot.showDisplay();
        parkingLot.payAndRelease(t1,new CashPaymentStrategy());
        parkingLot.showDisplay();

        parkingLot.payAndRelease(t6, new CashPaymentStrategy());
        parkingLot.payAndRelease(t7, new CashPaymentStrategy());
        parkingLot.showDisplay();
    }

}
