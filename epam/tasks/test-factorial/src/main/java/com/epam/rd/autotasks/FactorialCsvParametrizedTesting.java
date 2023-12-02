package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCsvParametrizedTesting {

    Factorial factorial = new Factorial();

    @ParameterizedTest
    @CsvFileSource(resources = "/csvCases.csv")
    void testFactorial(String input, String output){
        String actualOutput = factorial.factorial(input);
        assertEquals(output, actualOutput, "Factorial of " + input + " should be " + output);
    }
}
