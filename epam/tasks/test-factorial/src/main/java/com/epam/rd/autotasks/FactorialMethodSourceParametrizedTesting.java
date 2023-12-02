package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialMethodSourceParametrizedTesting {

    Factorial factorial = new Factorial();

    @ParameterizedTest
    @MethodSource("testCases")
    void testFactorial(String in, String expected) {
        String actual = factorial.factorial(in);
        assertEquals(expected, actual, "Factorial of " + in + " should be " + expected);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "2"),
                Arguments.of("5", "120")
        );
    }
}
