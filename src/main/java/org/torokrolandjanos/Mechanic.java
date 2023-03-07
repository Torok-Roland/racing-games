package org.torokrolandjanos;

public class Mechanic {
    public void repair(AutoVehicle autoVehicle){
        autoVehicle.setEngine(new Engine());

        autoVehicle.setDamaged(false);
    }
}
