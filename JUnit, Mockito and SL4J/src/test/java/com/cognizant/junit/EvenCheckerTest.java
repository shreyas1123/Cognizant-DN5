package com.cognizant.junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

/**
 * Exercise 1: Parameterized Tests
 * 
 * This class runs parameterized tests on EvenChecker.isEven(int).
 * It tests multiple even and odd numbers.
 */
@RunWith(Parameterized.class)
public class EvenCheckerTest {

    private int inputNumber;
    private boolean expectedResult;
    private EvenChecker evenChecker;

    // Constructor to receive parameters
    public EvenCheckerTest(int inputNumber, boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        evenChecker = new EvenChecker();
    }

    // Parameters data generator
    @Parameterized.Parameters(name = "Testing number {0}, expecting isEven to be {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            { 2, true },    // Even
            { 4, true },    // Even
            { 10, true },   // Even
            { 0, true },    // Even
            { -6, true },   // Even
            { 3, false },   // Odd
            { 7, false },   // Odd
            { 15, false },  // Odd
            { -1, false },  // Odd
            { 101, false }  // Odd
        });
    }

    @Test
    public void testIsEven() {
        System.out.println("[TEST] Parameterized: Checking if " + inputNumber + " is even. Expected: " + expectedResult);
        assertEquals(expectedResult, evenChecker.isEven(inputNumber));
    }
}
