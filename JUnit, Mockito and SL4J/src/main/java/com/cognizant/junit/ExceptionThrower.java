package com.cognizant.junit;

/**
 * Exercise 4: Exception Testing
 * 
 * ExceptionThrower is designed to demonstrate testing of expected exceptions.
 */
public class ExceptionThrower {

    /**
     * Throws an IllegalArgumentException if the provided message is null or empty.
     * 
     * @param message the message to process
     * @throws IllegalArgumentException if the message is null or empty
     */
    public void throwException(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println("Processing message: " + message);
    }
}
