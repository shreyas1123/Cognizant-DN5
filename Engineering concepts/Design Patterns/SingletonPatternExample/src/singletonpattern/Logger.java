package singletonpattern;

/**
 * Logger class implements the Singleton Design Pattern.
 * This ensures that only one instance of the Logger is created and used
 * across the entire application, serving as a global point of access.
 */
public class Logger {

    // 1. Private static variable to hold the single instance of the class
    private static Logger instance;

    /**
     * 2. Private constructor to prevent instantiation from outside the class.
     * This forces clients to use the getInstance() method.
     */
    private Logger() {
        System.out.println("[Logger Constructor] Logger object initialized.");
    }

    /**
     * 3. Public static method that provides global access to the single instance.
     * If the instance doesn't exist yet, it instantiates it (Lazy Initialization).
     * 
     * @return the single, shared Logger instance
     */
    public static Logger getInstance() {
        // If the instance is null, create it. Otherwise, return the existing one.
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * A simple log method to demonstrate functionality.
     * 
     * @param message the message to log
     */
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}