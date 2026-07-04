package com.cognizant.junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 3: Assertions in JUnit
 * 
 * This class validates various assertions available in JUnit 4, including:
 * - assertEquals
 * - assertTrue
 * - assertFalse
 * - assertNull
 * - assertNotNull
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals - compares expected and actual values
        assertEquals(5, 2 + 3);

        // Assert true - verifies a condition is true
        assertTrue(5 > 3);

        // Assert false - verifies a condition is false
        assertFalse(5 < 3);

        // Assert null - verifies that an object reference is null
        assertNull(null);

        // Assert not null - verifies that an object reference is not null
        assertNotNull(new Object());
    }
}
