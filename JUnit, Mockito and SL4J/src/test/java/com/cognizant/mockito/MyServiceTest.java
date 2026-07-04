package com.cognizant.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * MyServiceTest implements all 7 mandatory Mockito exercises:
 * 1. Mocking and Stubbing
 * 2. Verifying Interactions
 * 3. Argument Matching
 * 4. Handling Void Methods
 * 5. Mocking and Stubbing with Multiple Returns
 * 6. Verifying Interaction Order
 * 7. Handling Void Methods with Exceptions
 */
@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    private MyService service;

    @Before
    public void setUp() {
        service = new MyService(mockApi);
    }

    /**
     * Exercise 1: Mocking and Stubbing
     * Stub getData() to return a specific value and verify MyService returns it.
     */
    @Test
    public void testMockingAndStubbing() {
        System.out.println("[TEST] Exercise 1: Mocking and Stubbing");
        
        // Arrange
        when(mockApi.getData()).thenReturn("Mocked Data Response");

        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Mocked Data Response", result);
    }

    /**
     * Exercise 2: Verifying Interactions
     * Verify that postData() is actually called with the correct argument.
     */
    @Test
    public void testVerifyingInteractions() {
        System.out.println("[TEST] Exercise 2: Verifying Interactions");
        
        // Act
        service.submitData("Some Payload");

        // Assert
        verify(mockApi).postData("Some Payload");
    }

    /**
     * Exercise 3: Argument Matching
     * Use anyString() and eq() matchers to stub formatName().
     */
    @Test
    public void testArgumentMatching() {
        System.out.println("[TEST] Exercise 3: Argument Matching");
        
        // Arrange
        when(mockApi.formatName(anyString(), eq("Doe"))).thenReturn("Formatted John Doe");

        // Act
        String result = service.greetUser("John", "Doe");

        // Assert
        assertEquals("Formatted John Doe", result);
        verify(mockApi).formatName("John", "Doe");
    }

    /**
     * Exercise 4: Handling Void Methods
     * Verify calling a void method and confirm that we can doNothing() or simply verify it.
     */
    @Test
    public void testHandlingVoidMethods() {
        System.out.println("[TEST] Exercise 4: Handling Void Methods");
        
        // Arrange
        doNothing().when(mockApi).logMessage(anyString());

        // Act
        service.log("Info Message");

        // Assert
        verify(mockApi).logMessage("Info Message");
    }

    /**
     * Exercise 5: Mocking and Stubbing with Multiple Returns
     * Stub getResponseCode() to return 200 first, then 404, or multiple returns sequentially.
     */
    @Test
    public void testMockingAndStubbingWithMultipleReturns() {
        System.out.println("[TEST] Exercise 5: Mocking and Stubbing with Multiple Returns");
        
        // Arrange
        when(mockApi.getResponseCode())
            .thenReturn(200)  // First call
            .thenReturn(404); // Second call

        // Act
        int firstCall = mockApi.getResponseCode();
        int secondCall = mockApi.getResponseCode();
        int thirdCall = mockApi.getResponseCode(); // Should continue to return the last configured value (404)

        // Assert
        assertEquals(200, firstCall);
        assertEquals(404, secondCall);
        assertEquals(404, thirdCall);
    }

    /**
     * Exercise 6: Verifying Interaction Order
     * Verify that openConnection() is called BEFORE closeConnection().
     */
    @Test
    public void testVerifyingInteractionOrder() {
        System.out.println("[TEST] Exercise 6: Verifying Interaction Order");
        
        // Act
        service.executeConnectionWorkflow();

        // Assert
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).openConnection();
        inOrder.verify(mockApi).closeConnection();
    }

    /**
     * Exercise 7: Handling Void Methods with Exceptions
     * Configure deleteUser() to throw IllegalArgumentException and verify exception throwing.
     */
    @Test
    public void testHandlingVoidMethodsWithExceptions() {
        System.out.println("[TEST] Exercise 7: Handling Void Methods with Exceptions");
        
        // Arrange
        doThrow(new IllegalArgumentException("Invalid User ID")).when(mockApi).deleteUser(-1);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.removeUser(-1);
        });

        assertEquals("Invalid User ID", exception.getMessage());
        verify(mockApi).deleteUser(-1);
    }
}
