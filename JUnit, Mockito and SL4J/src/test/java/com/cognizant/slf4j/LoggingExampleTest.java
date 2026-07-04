package com.cognizant.slf4j;

import org.junit.Test;

/**
 * Test class to execute the LoggingExample app and output the logs to the console
 * during the Maven surefire execution phase.
 */
public class LoggingExampleTest {

    @Test
    public void testLoggingOutput() {
        System.out.println("[TEST] Executing LoggingExample.main to verify SLF4J + Logback output format:");
        LoggingExample.main(new String[]{});
    }
}
