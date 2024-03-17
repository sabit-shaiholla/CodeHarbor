package com.epam.rd.autotasks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 2);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 5);
            System.out.println(Arrays.toString(array));
        }

        {
            int[] array1 = new int[]{1, 2, 3, 4, 5};
            int[] array2 = new int[]{1, 2, 3, 4, 5};
            System.out.println("Original Array: " + Arrays.toString(array1));
            CycleSwap.cycleSwapWithAssignment(array1);
            System.out.println("After Cyclic Shift (with assignment): " + Arrays.toString(array1));
            CycleSwap.cycleSwapWithoutAssignment(array2);
            System.out.println("After Cyclic Shift (without assignment): " + Arrays.toString(array2));
        }
    }
}
