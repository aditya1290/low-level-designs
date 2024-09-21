package ParkingLot;

import ParkingLot.Enum.ParkingSpotType;
import ParkingLot.Exceptions.NoParkingAvailableException;
import ParkingLot.Model.ParkingSpot.ParkingSpot;
import ParkingLot.Model.Vehicle.Vehicle;
import lombok.Builder;
import lombok.Getter;

import java.util.*;

public class ParkingFloor {

    @Getter
    private final Map<ParkingSpotType, PriorityQueue<ParkingSpot>> parkingSpots;
    @Getter
    private final List<ParkingSpot> inUseParkingSpot;
    @Getter
    private final String parkingFloorId;

    public ParkingFloor(String floorId){
        inUseParkingSpot = new LinkedList<>();
        parkingFloorId = floorId;
        parkingSpots = new HashMap<>();
        for(ParkingSpotType spotType: ParkingSpotType.values()){
            parkingSpots.put(spotType, new PriorityQueue<>());
        }
    }

    public ParkingFloor(Builder b){
        this.inUseParkingSpot = b.inUseParkingSpot;
        this.parkingSpots = b.parkingSpots;
        this.parkingFloorId = b.parkingFloorId;
    }

    public boolean isIdEqual(String floorId){
        return floorId.equals(parkingFloorId);
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.computeIfAbsent(parkingSpot.getParkingSpotType(), k -> new PriorityQueue<>()).add(parkingSpot);
    }

    private void assignParking(ParkingSpot parkingSpot, Vehicle vehicle){
        inUseParkingSpot.add(parkingSpot);
        parkingSpot.assignVehicle(vehicle);
    }
    public void removeParking(ParkingSpot parkingSpot){
        inUseParkingSpot.remove(parkingSpot);
        addParkingSpot(parkingSpot);
        parkingSpot.vacateVehicle();
    }

    public void display(){
        parkingSpots.keySet().forEach(x -> System.out.print(" ( "+ x + ":"+parkingSpots.get(x).size() + "), "));
    }

    public ParkingSpot getFreeParkingSpot(ParkingSpotType parkingSpotType, Vehicle vehicle) throws NoParkingAvailableException {
        if(!parkingSpots.containsKey(parkingSpotType) || parkingSpots.get(parkingSpotType).isEmpty())       throw new NoParkingAvailableException();
        ParkingSpot ps = parkingSpots.get(parkingSpotType).poll();
        assignParking(ps, vehicle);
        return ps;
    }

    public static class Builder {
        private List<ParkingSpot> inUseParkingSpot;
        private String parkingFloorId;
        private final Map<ParkingSpotType, PriorityQueue<ParkingSpot>> parkingSpots = new HashMap<>();
        public Builder with(ParkingSpotType parkingSpotType, List<ParkingSpot>parkingSpots){
            PriorityQueue<ParkingSpot> pq = new PriorityQueue<>(Comparator.comparing(ParkingSpot::getId));
            pq.addAll(parkingSpots);
            this.parkingSpots.put(parkingSpotType, pq);
            return this;
        }

        public ParkingFloor build(String id){
            this.inUseParkingSpot = new LinkedList<>();
            this.parkingFloorId = id;
            return new ParkingFloor(this);
        }

    }

}
