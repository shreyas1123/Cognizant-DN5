package com.cognizant.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 1: SLF4J and Logback setup
 * 
 * LoggingExample demonstrates setting up and using the SLF4J Logger
 * with Logback bindings.
 */
public class LoggingExample {
    
    // Obtain the logger instance for LoggingExample class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Log messages at different levels
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
    }
}
