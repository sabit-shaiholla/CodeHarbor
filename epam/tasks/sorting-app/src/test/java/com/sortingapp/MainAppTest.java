package com.sortingapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(Parameterized.class)
public class MainAppTest {
    private final String[] input;
    private final int[] expected;
    private static final Logger logger = LogManager.getLogger(MainAppTest.class);

    public MainAppTest(String[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters(name = "{index}: input={0}, expected={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{}, new int[]{}},
                {new String[]{"5"}, new int[]{5}},
                {new String[]{"9", "5", "7", "1", "8", "3", "2", "4", "10", "6"},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
                {new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"},
                        null},
                {new String[]{"5", "3", "5", "1", "3"}, new int[]{1, 3, 3, 5, 5}},
        });
    }

    @Test
    public void testSortIntegers() {
        logger.info("Running testSortIntegers with input: " + Arrays.toString(input));
        int[] result = MainApp.sortIntegers(input);
        assertArrayEquals(expected, result);
        logger.info("Test passed successfully!");
    }
}
