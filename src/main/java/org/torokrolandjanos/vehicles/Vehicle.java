package org.torokrolandjanos.vehicles;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vehicle {

    //class variable (static variable)
    private static int totalVehicleCount;

    //instance variables
    private String name;
    private double fuelLevel;
    private double mileage;
    protected double totalTraveledDistance;
    private double maxSpeed;

    private boolean damaged;
    private String color;

    private LocalDate manufacturingDate = LocalDate.now();

    public Vehicle() {
        totalVehicleCount++;
    }

    //method overloading
    public double accelerate(double speed){
        return accelerate(speed, 1);
    }

    public double accelerate(double speed, double durationInHours) {
        if (fuelLevel <= 0 || damaged) {
            System.out.println("You cannot accelerate.");
            return 0;
        }

        if (speed > maxSpeed) {
            System.out.println("Max speed exceeded.");
            return 0;
        } else if (speed == maxSpeed) {
            System.out.println("Careful, max speed reached");
        } else {
            System.out.println("Valid speed entered.");
        }


        System.out.println(name + " is accelerating with " + speed + " km/h for " + durationInHours + "h");
        double distance = speed * durationInHours;

        totalTraveledDistance = totalTraveledDistance + distance;

        System.out.println("Total traveled distance for vehicle " + name + ": " + totalTraveledDistance);

        double mileageMultiplier = 1;

        if (speed > 120) {
            mileageMultiplier = speed / 100;
        }

        double useFuel = (distance * mileage * mileageMultiplier) / 100;

        fuelLevel -= useFuel;

        System.out.println("Remaining fuel for vehicle " + name + ": " + fuelLevel);

        return distance;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }

    public void setTotalTraveledDistance(double totalTraveledDistance) {
        this.totalTraveledDistance = totalTraveledDistance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    // read only property
    public static int getTotalVehicleCount() {
        return totalVehicleCount;
    }
}
