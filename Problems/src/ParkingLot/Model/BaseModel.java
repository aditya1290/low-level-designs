package ParkingLot.Model;

import lombok.Getter;

public class BaseModel {
    @Getter
    private final String id;

    public BaseModel(String id) {
        this.id = id;
    }
}
