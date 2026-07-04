package com.cognizant.junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 4: Exception Testing
 * 
 * This test class verifies that ExceptionThrower.throwException(String)
 * behaves correctly when given null or empty inputs by asserting exceptions.
 */
public class ExceptionThrowerTest {

    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowExceptionWithNullMessage() {
        System.out.println("[TEST] ExceptionTesting: testing null message");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });
        assertEquals("Message cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testThrowExceptionWithEmptyMessage() {
        System.out.println("[TEST] ExceptionTesting: testing empty message");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("   ");
        });
        assertEquals("Message cannot be null or empty", exception.getMessage());
    }
}
