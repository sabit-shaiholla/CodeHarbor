package com.sortingapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MainApp is a class that provides a simple program for sorting integer values entered by the user.
 */
public class MainApp {

    private static final int MAX_ARGUMENTS = 10;
    private static final Logger logger = LogManager.getLogger(MainApp.class);

    /**
     * The main method of the program. It reads user input, sorts integers, and logs the results.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            logger.info("Enter integer values separated by spaces: ");
            String inputLine = scanner.nextLine();

            while (!inputLine.isEmpty()) {
                if (inputLine.equalsIgnoreCase("ESC")) {
                    logger.info("Exiting the program.");
                    System.exit(0);
                }

                String[] userInput = inputLine.trim().split("\\s+");
                int[] sortedIntegers = sortIntegers(userInput);
                logger.info("Sorted values: " + Arrays.toString(sortedIntegers));
                logger.info("Enter more values or press Enter to exit:");
                inputLine = scanner.nextLine();
            }
        } catch (IllegalArgumentException e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    /**
     * Sorts the given array of integers in ascending order.
     *
     * @param inputString An array of strings representing integer values.
     * @return An array of integers sorted in ascending order.
     */
    public static int[] sortIntegers(String[] inputString) {
        if (inputString.length > MAX_ARGUMENTS) {
            return null;
        }
        int[] integers = Arrays.stream(inputString)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(integers);
        return integers;
    }
}