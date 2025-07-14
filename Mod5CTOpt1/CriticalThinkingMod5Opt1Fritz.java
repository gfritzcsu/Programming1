//  Program Name: Weekly Temperature Averages
//  Author: Greg Fritz
//  University: CSU Global
//  Professor: Dr. Gonzalez
//  Class: Programming 1 CSC320-2
//  Date: 13 July 2025
// -------------------------------------------
//  Pseudocode:
// -------------------------------------------
// START
// Create list called days
// Create list called temperatures
// Create array weekDays with values: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
// DISPLAY "Please enter the average temperature for each day of the week."
// FOR each day IN weekDays DO
//     SET validInput to false
//     WHILE validInput is false DO
//         PROMPT "Enter average temperature for [day]:"
//         IF user enters a numeric value THEN
//             STORE value in temp
//             ADD day to days list
//             ADD temp to temperatures list
//             SET validInput to true
//         ELSE
//             DISPLAY "Invalid input. Please enter a numeric value."
//             DISCARD invalid input
//         ENDIF
//     ENDWHILE
// ENDFOR
// PROMPT "Type 'week' to see all temperatures and the weekly average:"
// GET input from user
// IF input equals "week" (case-insensitive) THEN
//     DISPLAY "Temperature Report:"
//     SET sum = 0
//     FOR index FROM 0 TO size of days list - 1 DO
//         DISPLAY day at index + ": " + temperature at index + "°"
//         ADD temperature at index to sum
//     ENDFOR
//     CALCULATE average = sum / number of temperatures
//     DISPLAY "Weekly Average Temperature: " + average
// ELSE
//     DISPLAY "Unrecognized input. Program exiting."
// ENDIF
// END

import java.util.ArrayList;
import java.util.Scanner;

public class CriticalThinkingMod5Opt1Fritz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        String[] weekDays = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

        System.out.println("Please enter the average temperature for each day of the week.");

        for (String day : weekDays) {
            double temp = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter average temperature for " + day + ": ");
                if (scanner.hasNextDouble()) {
                    temp = scanner.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // clear invalid input
                }
            }

            days.add(day);
            temperatures.add(temp);
        }

        System.out.print("\nType 'week' to see all temperatures and the weekly average: ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("week")) {
            System.out.println("\nTemperature Report:");
            double sum = 0;

            for (int i = 0; i < days.size(); i++) {
                System.out.println(days.get(i) + ": " + temperatures.get(i) + "°");
                sum += temperatures.get(i);
            }

            double average = sum / temperatures.size();
            System.out.printf("\nWeekly Average Temperature: %.2f°\n", average);
        } else {
            System.out.println("Unrecognized input. Program exiting.");
        }

        scanner.close();
    }
}