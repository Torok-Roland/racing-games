package org.torokrolandjanos.controller;

import org.torokrolandjanos.controller.utils.ScannerUtils;

public class StdinController implements UserInputController{
    @Override
    public int getPlayerCount() {
        System.out.println("Please enter number of players: ");
        return ScannerUtils.nextIntAndMoveToNextLine();
    }

    @Override
    public String getVehicleName() {
        System.out.println("Please enter vehicle name: ");
        return ScannerUtils.nextLine();
    }

    @Override
    public int getSelectedTrack() {
        System.out.println("PLease select a track: ");
        return ScannerUtils.nextIntAndMoveToNextLine();
    }

    @Override
    public double getAccelerationSpeed() {
        System.out.println("Please enter acceleration speed: ");
        return ScannerUtils.nextDoubleAndMoveToNextLIne();
    }
}
