package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Factorial {

    public String factorial(String n) {
        if(n == null){
            throw new IllegalArgumentException("Input must not be null.");
        }
        if (!isNonNegativeInteger(n)) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        if (n.equals("0")) {
            return "1";
        }

        BigInteger result = BigInteger.ONE;
        BigInteger num = new BigInteger(n);

        while (!num.equals(BigInteger.ZERO)) {
            result = result.multiply(num);
            num = num.subtract(BigInteger.ONE);
        }

        return result.toString();
    }

    private static boolean isNonNegativeInteger(String str) {
        try {
            return new BigInteger(str).compareTo(BigInteger.ZERO) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
