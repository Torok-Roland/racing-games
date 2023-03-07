package org.torokrolandjanos;

import org.torokrolandjanos.vehicles.AutoVehicle;

public class Mechanic {
    public void repair(AutoVehicle autoVehicle){
        autoVehicle.setEngine(new Engine());

        autoVehicle.setDamaged(false);
    }
}
