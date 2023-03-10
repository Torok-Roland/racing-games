package org.torokrolandjanos;

import org.torokrolandjanos.utils.ScannerUtils;
import org.torokrolandjanos.vehicles.Vehicle;


public class Game {

    private Track[] tracks = new Track[3];

    public void start() {
        System.out.println("Welcome to the Racing Game!");

        initializeTracks();

        Track selectedTrack = getSelectedTrackFromUser();
        System.out.println("Selected track: " + selectedTrack.getName());

        int playerCount = getPlayerCountFromUser();

        System.out.println("Player count: " + playerCount);

        String vehicleName = getVehicleNameFromUser();

        System.out.println("Vehicle name: " + vehicleName);
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
            if (tracks[i] != null){
                System.out.println((i + 1) + ". " + tracks[i].getName() + " : " + tracks[i].getLength());
            }
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

    private Track getSelectedTrackFromUser(){
        System.out.println("PLease select a track: ");
        int trackNumber = ScannerUtils.nextIntAndMoveToNextLine();

        return tracks[trackNumber - 1];

    }

}
