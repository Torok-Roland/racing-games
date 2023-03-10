package org.torokrolandjanos.competitor.vehicle;

public class Mechanic {
    public void repair(AutoVehicle autoVehicle){
        autoVehicle.setEngine(new Engine());

        autoVehicle.setDamaged(false);
    }
}
