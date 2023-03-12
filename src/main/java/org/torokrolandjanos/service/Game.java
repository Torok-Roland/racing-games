package org.torokrolandjanos.service;

import org.torokrolandjanos.controller.StdinController;
import org.torokrolandjanos.controller.UserInputController;
import org.torokrolandjanos.domain.Track;
import org.torokrolandjanos.domain.competitor.Mobile;
import org.torokrolandjanos.domain.competitor.MobileComparator;
import org.torokrolandjanos.domain.competitor.vehicle.Car;
import org.torokrolandjanos.domain.competitor.vehicle.Vehicle;
import org.torokrolandjanos.persistence.FileRankingRepository;
import org.torokrolandjanos.persistence.RankingsRepository;
import org.torokrolandjanos.controller.utils.ScannerUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    private Track[] tracks = new Track[3];
    private List<Mobile> competitors = new ArrayList<>();
    private Set<Mobile> outOfRaceCompetitors = new HashSet<>();
    private boolean winnerNotKnown = true;
    private Track selectedTrack;

    private UserInputController userInputController = new StdinController();
    private RankingsRepository rankingsRepository = new FileRankingRepository();

    public void start() throws Exception {
        System.out.println("Welcome to the Racing Game!");

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser();

        System.out.println("Selected track: " + selectedTrack.getName());

        initializeCompetitors();

        loopRounds();

        processRankings();
    }

    private void processRankings() {
        competitors.sort(Collections.reverseOrder(new MobileComparator()));

        System.out.println("Rankings: ");

        for (int i = 0; i < competitors.size(); i++) {
            System.out.println((i + 1) + ". " + competitors.get(i).getName() + " : "
                    + competitors.get(i).getTotalTraveledDistance() + " km.");

            rankingsRepository.addRankingItem(i + 1, competitors.get(i).getName(), competitors.get(i).getTotalTraveledDistance());
        }

        rankingsRepository.close();
    }

    private void loopRounds() {
        while (winnerNotKnown && outOfRaceCompetitors.size() < competitors.size()) {
            playOneRounde();
        }
    }

    private void playOneRounde() {
        System.out.println("New round.");


        for (Mobile competitor : competitors) {
            System.out.println("It's " + competitor.getName() + "'s turn.");

            if (!competitor.canMove()) {
                System.out.println("Sorry you cannot continue the race...");
                outOfRaceCompetitors.add(competitor);
                continue;
            }

            double speed = getAccelerationSpeedFromUser();
            competitor.accelerate(speed, 1);

            if (competitor.getTotalTraveledDistance() >= selectedTrack.getLength()) {
                System.out.println("The winner is: " + competitor.getName());
                winnerNotKnown = false;
                break;
            }
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
        int playerCount = userInputController.getPlayerCount();

        for (int i = 1; i <= playerCount; i++) {
            System.out.println("Preparing player " + i + " for the race. ");
            Vehicle vehicle = new Car();
            vehicle.setName(userInputController.getVehicleName());
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

    private Track getSelectedTrackFromUser() throws Exception {
        try {
            int trackNumber = userInputController.getSelectedTrack();
            return tracks[trackNumber - 1];

        } catch (InputMismatchException e) {
            throw new Exception("You have entered an invalid value.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("You have entered an invalid number.");
        } finally {
            System.out.println("Finally block is always executed");
        }
    }

    private double getAccelerationSpeedFromUser() {

        try {
            return userInputController.getAccelerationSpeed();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value please try again");
            // recursion
            return getAccelerationSpeedFromUser();
        }
    }
}