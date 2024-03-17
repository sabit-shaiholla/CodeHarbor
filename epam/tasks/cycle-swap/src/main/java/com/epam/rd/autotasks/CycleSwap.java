package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length > 1) {
            int lastElement = array[array.length - 1];
            System.arraycopy(array,
                    0,
                    array,
                    1,
                    array.length - 1);
            array[0] = lastElement;
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length > 1 && shift % array.length != 0) {
            int[] temp = Arrays.copyOf(array, array.length);
            System.arraycopy(temp,
                    0,
                    array,
                    shift % array.length,
                    array.length - shift % array.length);
            System.arraycopy(temp,
                    array.length - shift % array.length,
                    array,
                    0,
                    shift % array.length);
        }
    }

    static void cycleSwapWithAssignment(int[] array) {
        if (array.length > 1) {
            int lastElement = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = lastElement;
        }
    }

    static void cycleSwapWithoutAssignment(int[] array) {
        if (array.length > 1) {
            //int lastElement = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
        }
    }
}
