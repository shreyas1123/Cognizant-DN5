package com.cognizant.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit
 * 
 * This test class demonstrates:
 * 1. Test Fixtures: The 'account' object is the fixture set up before every test.
 * 2. Setup and Teardown Methods: '@Before' and '@After' hooks for initialization and cleanup.
 * 3. AAA Pattern: Structured tests using Arrange, Act, and Assert comments.
 */
public class BankAccountTest {

    // Test fixture instance
    private BankAccount account;

    /**
     * Setup method annotated with @Before.
     * This is executed before each test case, initializing the test fixture.
     */
    @Before
    public void setUp() {
        System.out.println("[SETUP] Creating a new BankAccount with an initial balance of $100.0");
        // Initialize the test fixture
        account = new BankAccount(100.0);
    }

    /**
     * Teardown method annotated with @After.
     * This is executed after each test case, performing necessary cleanup.
     */
    @After
    public void tearDown() {
        System.out.println("[TEARDOWN] Cleaning up and resetting the BankAccount reference to null");
        // Reset the fixture
        account = null;
    }

    /**
     * Test case demonstrating deposit functionality using AAA.
     */
    @Test
    public void testDepositUsingAAA() {
        System.out.println("[TEST] Executing testDepositUsingAAA");
        
        // 1. Arrange: Setup variables and expectations
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        // 2. Act: Perform the action under test
        account.deposit(depositAmount);

        // 3. Assert: Verify the result is as expected
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    /**
     * Test case demonstrating withdraw functionality using AAA.
     */
    @Test
    public void testWithdrawUsingAAA() {
        System.out.println("[TEST] Executing testWithdrawUsingAAA");
        
        // 1. Arrange: Setup variables and expectations
        double withdrawAmount = 40.0;
        double expectedBalance = 60.0;

        // 2. Act: Perform the action under test
        account.withdraw(withdrawAmount);

        // 3. Assert: Verify the result is as expected
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    /**
     * Test case demonstrating that withdrawing more than balance throws an exception.
     */
    @Test
    public void testWithdrawOverdraftThrowsException() {
        System.out.println("[TEST] Executing testWithdrawOverdraftThrowsException");
        
        // 1. Arrange: Setup amount exceeding balance
        double overdrawAmount = 150.0;

        // 2. Act & Assert: Verify that exception is thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(overdrawAmount);
        });
        
        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }
}
