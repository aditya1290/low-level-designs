package ParkingLot;

import ParkingLot.Enum.ParkingSpotType;
import ParkingLot.Exceptions.NoParkingAvailableException;
import ParkingLot.Exceptions.PaymentException;
import ParkingLot.Model.ParkingSpot.ParkingSpot;
import ParkingLot.Model.Payment.IPayment;
import ParkingLot.Model.Ticket.ParkingTicket;
import ParkingLot.Model.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ParkingLot {

    private final Object lock = new Object();
    private final List<ParkingFloor> parkingFloorList;

    public ParkingLot(){
        parkingFloorList = new ArrayList<>();
    }

    public int getNumOfFloors(){
        return parkingFloorList.size();
    }
    public ParkingFloor getFloor(int floorIndex){
        return parkingFloorList.get(floorIndex);
    }
    public ParkingFloor getFloorById(String floorId){
        Optional<ParkingFloor> pf = parkingFloorList.stream().filter(x -> x.isIdEqual(floorId)).findFirst();
        return pf.orElseThrow();
    }
    public void addFloor(String floorId){
        ParkingFloor pf = new ParkingFloor(floorId);
        parkingFloorList.add(pf);
    }
    public void addFloor(ParkingFloor pf){
        parkingFloorList.add(pf);
    }

    public ParkingTicket assignParkingAndGiveTicket(ParkingSpotType parkingSpotType, Vehicle vehicle){
        System.out.println("***************\nAssigning Parking "+parkingSpotType+" to vehicle...");
        synchronized (lock){
            for(ParkingFloor pf: parkingFloorList){
                try{
                    ParkingSpot parkingSpot = pf.getFreeParkingSpot(parkingSpotType, vehicle);
                    return new ParkingTicket(vehicle, parkingSpot);
                }
                catch (NoParkingAvailableException e){

                }
            }
            System.out.println("No Parking available for " + parkingSpotType);
            System.out.println("Failed assigning");
        }
        return null;
    }

    public boolean payAndRelease(ParkingTicket parkingTicket, IPayment pts){
        synchronized (lock){
            if(parkingTicket == null || !parkingTicket.isValid()){
                System.out.println("Ticket Already Closed");
                return false;
            }
            try{
                ParkingSpot spot = parkingTicket.getSpot();
                ParkingFloor pf = getFloorById(spot.getParkingFloorId());
                parkingTicket.close(pts);
                pf.removeParking(spot);
                return true;
            } catch(PaymentException e){
                System.out.println("Payment failed. Try again");
                return false;
            } catch(NoSuchElementException e){
                System.out.println("Floor Not found : Internal Server Error");
                return false;
            }
        }
    }

    public void showDisplay(){
        parkingFloorList.forEach(x -> {
            System.out.print("Floor "+x.getParkingFloorId() + " : ");
            x.display();
            System.out.print("\n");
        });
    }
}
