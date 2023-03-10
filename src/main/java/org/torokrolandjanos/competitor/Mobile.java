package org.torokrolandjanos.competitor;

public interface Mobile {

    double accelerate(double speed, double durationInHours);

    double getTotalTraveledDistance();

    boolean canMove();

    String getName();
}
