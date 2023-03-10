package org.torokrolandjanos;

import org.torokrolandjanos.competitor.Mobile;
import org.torokrolandjanos.utils.ScannerUtils;
import org.torokrolandjanos.competitor.vehicle.Car;
import org.torokrolandjanos.competitor.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    private Track[] tracks = new Track[3];
    private List<Mobile> competitors = new ArrayList<>();



    public void start() {
        System.out.println("Welcome to the Racing Game!");

        initializeTracks();

        Track selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected track: " + selectedTrack.getName());

        initializeCompetitors();

        playOneRounde();
    }

    private void playOneRounde() {
        System.out.println("New round.");


        for(Mobile competitor : competitors){
            System.out.println("It's " + competitor.getName() + "'s turn.");

            double speed = getAccelerationSpeedFromUser();
            competitor.accelerate(speed, 1);
        }

    }

    private void initializeTracks() {
        Track track1 = new Track();
        track1.setName("Highway");
        track1.setLength(200);

        tracks[0] = track1;

        Track track2 = new Track();
        track2.setName("Street Circuit");
        track2.setLength(100);

        tracks[1] = track2;

        displayTracks();

    }

    // classic for
    private void displayTracks() {
        System.out.println("Available tracks: ");
        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] != null) {
                System.out.println((i + 1) + ". " + tracks[i].getName() + " : " + tracks[i].getLength());
            }
        }
    }

    private void initializeCompetitors() {
        int playerCount = getPlayerCountFromUser();

        for (int i = 1; i <= playerCount; i++) {
            System.out.println("Preparing player " + i + " for the race. ");
            Vehicle vehicle = new Car();
            vehicle.setName(getVehicleNameFromUser());
            vehicle.setFuelLevel(30);
            vehicle.setMaxSpeed(300);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8, 15));

            System.out.println("Fuel level for " + vehicle.getName() + " : " + vehicle.getFuelLevel());
            System.out.println("Max speed for " + vehicle.getName() + " : " + vehicle.getMaxSpeed());
            System.out.println("Mileage for " + vehicle.getName() + " : " + vehicle.getMileage());
            System.out.println();

            competitors.add(vehicle);
        }
    }


    private int getPlayerCountFromUser() {
        System.out.println("Please enter number of players: ");
        return ScannerUtils.nextIntAndMoveToNextLine();

    }

    private String getVehicleNameFromUser() {
        System.out.println("Please enter vehicle name: ");
        return ScannerUtils.nextLine();
    }

    private Track getSelectedTrackFromUser() {
        System.out.println("PLease select a track: ");
        int trackNumber = ScannerUtils.nextIntAndMoveToNextLine();

        return tracks[trackNumber - 1];

    }

    private double getAccelerationSpeedFromUser(){
        System.out.println("Please enter acceleration speed: ");
        return ScannerUtils.nextDoubleAndMoveToNextLIne();
    }

}
