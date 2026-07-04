package com.cognizant.junit;

import org.junit.Test;

/**
 * Exercise 5: Timeout and Performance Testing
 * 
 * Verifies that PerformanceTester.performTask completes within the specified timeout.
 */
public class PerformanceTesterTest {

    private final PerformanceTester tester = new PerformanceTester();

    /**
     * Verifies that the task completes successfully within 150 milliseconds
     * when it only sleeps for 50 milliseconds.
     */
    @Test(timeout = 150)
    public void testPerformTaskWithinTimeout() {
        System.out.println("[TEST] TimeoutTesting: running task (takes 50ms) expecting completion within 150ms");
        tester.performTask(50);
    }
}
