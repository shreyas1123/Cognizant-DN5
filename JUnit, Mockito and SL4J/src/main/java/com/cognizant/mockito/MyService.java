package com.cognizant.mockito;

/**
 * MyService is the business logic service under unit test.
 * It uses ExternalApi for its remote workflows.
 */
public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    // Exercise 1: Mocking and Stubbing
    public String fetchData() {
        return externalApi.getData();
    }

    // Exercise 2: Verifying Interactions
    public void submitData(String data) {
        externalApi.postData(data);
    }

    // Exercise 3: Argument Matching
    public String greetUser(String first, String last) {
        return externalApi.formatName(first, last);
    }

    // Exercise 4: Handling Void Methods
    public void log(String msg) {
        externalApi.logMessage(msg);
    }

    // Exercise 5: Mocking and Stubbing with Multiple Returns
    public boolean checkStatus() {
        int code1 = externalApi.getResponseCode();
        int code2 = externalApi.getResponseCode();
        return code1 == 200 && code2 == 200;
    }

    // Exercise 6: Verifying Interaction Order
    public void executeConnectionWorkflow() {
        externalApi.openConnection();
        externalApi.closeConnection();
    }

    // Exercise 7: Handling Void Methods with Exceptions
    public void removeUser(int userId) {
        try {
            externalApi.deleteUser(userId);
        } catch (IllegalArgumentException e) {
            System.err.println("Exception handled in service: " + e.getMessage());
            throw e; // rethrow to let test verify
        }
    }
}
