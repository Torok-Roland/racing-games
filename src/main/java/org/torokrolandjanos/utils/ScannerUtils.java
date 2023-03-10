package org.torokrolandjanos.utils;

import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int nextIntAndMoveToNextLine() {
        int integer = SCANNER.nextInt();
        SCANNER.nextLine();
        return integer;
    }
    public static double nextDoubleAndMoveToNextLIne(){
        double value = SCANNER.nextDouble();
        SCANNER.nextLine();
        return value;
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }
}
