package com.cognizant.junit;

/**
 * Exercise 5: Timeout and Performance Testing
 * 
 * PerformanceTester simulates time-consuming tasks for performance/timeout validation.
 */
public class PerformanceTester {

    /**
     * Simulates a task by sleeping for the specified duration.
     * 
     * @param sleepMs the simulated task duration in milliseconds
     */
    public void performTask(long sleepMs) {
        try {
            Thread.sleep(sleepMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task execution was interrupted: " + e.getMessage());
        }
    }
}
