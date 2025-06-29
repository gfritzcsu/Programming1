//  Program Name: Calculate Average Witholding
//  Author: Greg Fritz
//  University: CSU Global
//  Professor: Dr. Gonzalez
//  Class: CSC320-2
//  Date: 29 June 2025
// -------------------------------------------
//  Pseudocode:
// -------------------------------------------
// START
//     SET income = -1
//     WHILE income <= 0 DO
//         PROMPT user to enter weekly income as a positive whole number
//         IF input is an integer THEN
//             READ income
//             IF income <= 0 THEN
//                 DISPLAY "Income must be a positive number"
//             END IF
//         ELSE
//             DISPLAY "Invalid input. Please enter a whole number"
//             DISCARD invalid input
//         END IF
//     END WHILE
//     IF income < 500 THEN
//         taxRate = 0.10
//     ELSE IF income < 1500 THEN
//         taxRate = 0.15
//     ELSE IF income < 2500 THEN
//         taxRate = 0.20
//     ELSE
//         taxRate = 0.30
//     END IF
//     taxWithheld = income * taxRate
//     DISPLAY "Your weekly tax withholding is: $" + taxWithheld + " (" + (taxRate * 100) + "% rate)"
// END

import java.util.Scanner;

public class CriticalThinkingMod3Opt1Fritz {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int income = -1;

        // Input validation loop to ensures the user enters a valid positive integer for income
        while (income <= 0) {
            System.out.print("Enter your weekly income as a positive whole number: ");

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                income = scanner.nextInt();

                // Check if the integer is positive
                if (income <= 0) {
                    System.out.println("Income must be a positive number.");
                }
            } else {
                // Handle invalid (non-integer) input
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Clear the invalid token if a positive integer was not met earlier from the scanner buffer
            }
        }

        // Determine the appropriate tax rate based on the income brackets
        double taxRate;

        if (income < 500) {
            taxRate = 0.10;
        } else if (income < 1500) {
            taxRate = 0.15;
        } else if (income < 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }

        // Calculate the tax withholding based on the income and tax rate the income amount falls into
        double taxWithheld = income * taxRate;

        // Print the final result with proper formatting
        System.out.printf("Your weekly tax withholding is: $%.2f (%.0f%% rate)%n", taxWithheld, taxRate * 100);

        // Close the scanner
        scanner.close();
    }
}