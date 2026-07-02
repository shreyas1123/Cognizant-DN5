package singletonpattern;

/**
 * Main class to test and demonstrate the Singleton Pattern implementation.
 * It verifies that only one instance of the Logger class is ever created.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            TESTING SINGLETON PATTERN             ");
        System.out.println("==================================================");

        // Step 1: Attempt to retrieve the Logger instance for the first time
        System.out.println("Retrieving first Logger reference (logger1)...");
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");
        System.out.println("logger1 Hashcode: " + logger1.hashCode());
        System.out.println("--------------------------------------------------");

        // Step 2: Attempt to retrieve the Logger instance for the second time
        System.out.println("Retrieving second Logger reference (logger2)...");
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");
        System.out.println("logger2 Hashcode: " + logger2.hashCode());
        System.out.println("--------------------------------------------------");

        // Step 3: Verify and prove that both references point to the exact same instance
        System.out.println("Verifying instance uniqueness...");
        
        // Output reference comparison result
        if (logger1 == logger2) {
            System.out.println("Success: Both references (logger1 and logger2) point to the SAME instance.");
            System.out.println("Verification Confirmed: Only one instance of the Logger exists in memory.");
        } else {
            System.out.println("Failure: Different references detected! Multiple instances exist.");
        }
        System.out.println("==================================================");
    }
}
