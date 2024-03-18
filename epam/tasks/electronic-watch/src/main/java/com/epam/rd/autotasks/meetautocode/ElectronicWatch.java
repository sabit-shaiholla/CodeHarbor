package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int HOURS_IN_DAY = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int minutes = (seconds / SECONDS_IN_MINUTE) % SECONDS_IN_MINUTE;
        int hours = (seconds / SECONDS_IN_HOUR) % HOURS_IN_DAY;
        seconds = seconds % SECONDS_IN_MINUTE;
        System.out.printf("%d:%s:%s", hours, String.format("%02d", minutes), String.format("%02d", seconds));
    }
}
