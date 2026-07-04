package com.cognizant.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertTrue;

/**
 * Exercise 3: Test Execution Order
 * 
 * Demonstrates how to control execution order of test methods in JUnit 4.
 * Since JUnit 4.11+, we can use @FixMethodOrder with MethodSorters.NAME_ASCENDING
 * to execute tests in alphabetic order of method names.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderedTests {

    @Test
    public void testA_firstStep() {
        System.out.println("[TEST] OrderedTests: Executed Step 1 (testA_firstStep)");
        assertTrue(true);
    }

    @Test
    public void testB_secondStep() {
        System.out.println("[TEST] OrderedTests: Executed Step 2 (testB_secondStep)");
        assertTrue(true);
    }

    @Test
    public void testC_thirdStep() {
        System.out.println("[TEST] OrderedTests: Executed Step 3 (testC_thirdStep)");
        assertTrue(true);
    }
}
