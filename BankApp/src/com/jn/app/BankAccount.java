package com.jn.app;

import com.jn.input.UserInput;

public class BankAccount {
    UserInput userInput = new UserInput();
    float userBalance;
    float previousTransaction;
    String userName;
    String userID;
    char userOption = '\0';


    public BankAccount(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
    }

    void deposit(float amount) {
        if (amount > 0) {
            userBalance = userBalance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(float amount) {
        if (amount > 0) {
            userBalance = userBalance - amount;
            previousTransaction = amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Amount Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Amount Withdrawn: " + Math.abs(previousTransaction));   // using Math.abs forces the value to return a positive value
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    void Menu() {
        WelcomeMessage();
        DisplayOptions();
    }

    void WelcomeMessage() {
        System.out.println(
                "Welcome " + userName +
                        " Your ID is " + userID
        );
    }

    void DisplayOptions() {
        System.out.println(
                "Options \n" +
                        "_".repeat(10) +
                        "A. Check Balance \n" +
                        "B. Deposit money \n" +
                        "C. Withdraw money \n" +
                        "D. View previous transactions \n" +
                        "E. Exit"
        );
    }

    void UserChoice() {
        do {
            System.out.println("=".repeat(20));
            System.out.println("Choose an option");
            userOption = userInput.getChar();

            OptionSwitchCase(userOption);
        } while (userOption != 'E');
    }

    private void OptionSwitchCase(char userOption) {
        switch (this.userOption) {
            case 'A':
                DisplayBalance();
                break;
            case 'B':
                System.out.println(
                                "-".repeat(10) +
                                "Enter amount to deposit"
                );
                float amount = userInput.getFloat();
                deposit(amount);
        }
    }

    private void DisplayBalance() {
        System.out.println(
                        "-".repeat(10) +
                        "Balance" + userBalance +
                        "-".repeat(10)
        );
    }
}
