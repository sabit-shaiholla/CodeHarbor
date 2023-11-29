package com.epam.rd.autotasks;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {

    Sorting sorting = new Sorting();

    @Test(expected = IllegalArgumentException.class)
    public void testNullCase(){
        int[] array = null;
        sorting.sort(array);
    }

    @Test
    public void testEmptyCase(){
        int[] array = {};
        sorting.sort(array);
        assertArrayEquals(array, new int[]{});
    }

    @Test
    public void testSingleElementArrayCase() {
        int[] array = {4};
        sorting.sort(array);
        assertArrayEquals(array, new int[]{4});
    }

    @Test
    public void testSortedArraysCase() {
        int[] array = {1, 2, 3, 4, 5};
        sorting.sort(array);
        assertArrayEquals(array, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testOtherCases() {
        int[] array = {5, 1, 3, 4, 2};
        sorting.sort(array);
        assertArrayEquals(array, new int[]{1, 2, 3, 4, 5});
    }

}