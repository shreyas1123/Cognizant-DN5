package com.cognizant.mockito;

/**
 * Interface representing an external api provider.
 * This class is mock-tested using Mockito in MyServiceTest.
 */
public interface ExternalApi {
    
    // Exercise 1: Mocking and Stubbing
    String getData();
    
    // Exercise 2: Verifying Interactions
    void postData(String data);
    
    // Exercise 3: Argument Matching
    String formatName(String firstName, String lastName);
    
    // Exercise 4: Handling Void Methods
    void logMessage(String message);
    
    // Exercise 5: Mocking and Stubbing with Multiple Returns
    int getResponseCode();
    
    // Exercise 6: Verifying Interaction Order
    void openConnection();
    void closeConnection();
    
    // Exercise 7: Handling Void Methods with Exceptions
    void deleteUser(int userId) throws IllegalArgumentException;
}
