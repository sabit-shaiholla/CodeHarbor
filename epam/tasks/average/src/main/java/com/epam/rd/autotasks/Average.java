package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int averageValue = averageFromString(scanner.nextLine());
        System.out.println(averageValue);
    }

    public static int averageFromString(String input) {
        String[] array = input.split(" ");
        int[] intArray = new int[array.length];
        try {
            for (int i = 0; i < array.length; i++) {
                intArray[i] = Integer.parseInt(array[i]);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return average(intArray);
    }
    public static int average(int[] array) {
        int sum = 0;
        int count = 0;
        for (int i : array) {
            if (i != 0) {
                sum += i;
                count++;
            }
        }
        return sum / count;
    }
}