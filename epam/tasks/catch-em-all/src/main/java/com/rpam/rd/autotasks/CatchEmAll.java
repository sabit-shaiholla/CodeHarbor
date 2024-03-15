package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {
    static Exception exception;

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (IOException e) {
            handleIOExceptionOrFileNotFoundException(e);
        } catch (ArithmeticException | NumberFormatException e) {
            handleArithmeticOrNumberFormatException(e);
        }
    }
    private static void riskyMethod() throws Exception {
        if (exception != null) {
            throw exception;
        }
    }

    private static void handleIOExceptionOrFileNotFoundException(IOException e) {
        String message = (e instanceof FileNotFoundException) ?
                "Resource is missing" : "Resource error";
        throw new IllegalArgumentException(message, e);
    }

    private static void handleArithmeticOrNumberFormatException(RuntimeException e) {
        System.err.println(e.getMessage());
    }
}
