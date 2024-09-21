package ParkingLot.Model.ParkingSpot;

import ParkingLot.Enum.ParkingSpotType;
import ParkingLot.Enum.VehicleType;
import ParkingLot.Model.BaseModel;
import ParkingLot.Model.Vehicle.Vehicle;
import lombok.Getter;

public abstract class ParkingSpot extends BaseModel {

    @Getter
    private boolean isFree;
    @Getter
    private ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    @Getter
    private String parkingFloorId;

    public ParkingSpot(int id, ParkingSpotType parkingSpotType, String parkingFloorId){
        super(String.valueOf(id));
        this.parkingFloorId = parkingFloorId;
        this.parkingSpotType = parkingSpotType;
        isFree = true;
    }

    public boolean isSpotFree(){ return isFree; }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        isFree = false;
    }

    public void vacateVehicle(){
        if(vehicle == null){
            System.out.println("Spot already empty");
        }
        vehicle = null;
        isFree = true;
    }

}
