package com.cognizant.junit;

/**
 * Exercise 1: Parameterized Tests
 * 
 * EvenChecker provides utility methods to check numerical properties.
 */
public class EvenChecker {

    /**
     * Checks if a given integer is even.
     * 
     * @param number the number to check
     * @return true if the number is even, false otherwise
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
