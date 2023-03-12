package org.torokrolandjanos.domain.competitor.vehicle;

public abstract class AutoVehicle extends Vehicle {
    //has a relationship (aggregation)
    private Engine engine;

    //constructor overloading
    public AutoVehicle(){
        this(new Engine());
    }

    public AutoVehicle(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "AutoVehicle{" +
                "engine=" + engine +
                "} " + super.toString();
    }
}
