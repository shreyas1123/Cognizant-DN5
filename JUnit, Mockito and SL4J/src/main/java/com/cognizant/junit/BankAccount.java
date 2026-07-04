package com.cognizant.junit;

/**
 * BankAccount represents a simple bank account with basic deposit and withdrawal operations.
 * This class is used to demonstrate the Arrange-Act-Assert (AAA) testing pattern
 * along with setup and teardown test fixtures in Exercise 4.
 */
public class BankAccount {
    private double balance;

    /**
     * Constructs a BankAccount with an initial balance.
     * 
     * @param initialBalance the initial balance of the account
     */
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    /**
     * Returns the current balance.
     * 
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a positive amount into the account.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    /**
     * Withdraws a positive amount from the account if funds are sufficient.
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }
}
