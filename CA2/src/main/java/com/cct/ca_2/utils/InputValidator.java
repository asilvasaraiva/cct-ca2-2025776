/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.enums.Department;
import com.cct.ca_2.enums.MainMenu;
import com.cct.ca_2.enums.ManagerType;
import java.util.Scanner;

/**
 * Utility class providing input validation methods for user interactions.
 * Handles name, numeric, and enum-based input validation throughout the application.
 *
 * @author alexsandrosaraiva
 */
public class InputValidator {

    /**
     * Repeatedly prompts the user for a single name until a valid one is entered.
     * Delegates validation to isValidName() on each attempt.
     *
     * @param scanner The Scanner instance used to read user input.
     * @param prompt  The message displayed to the user before each input request.
     * @return        A validated, trimmed name string containing only letters.
     */
    public static String getValidName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            // Return the name only if it passes validation
            if (isValidName(name)) {
                return name;
            }
        }
    }

    /**
     * Checks whether a given name string is valid.
     * A valid name must be non-null, non-empty, and contain only alphabetic characters.
     *
     * @param name The name string to validate.
     * @return     true if the name is valid; false otherwise, with an error message printed.
     */
    public static boolean isValidName(String name) {
        // Reject null or blank names
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: name cannot be empty.");
            return false;
        }
        // Reject names containing non-alphabetic characters
        if (!name.trim().matches("[a-zA-Z]+")) {
            System.out.println("Error: name must contain only letters.");
            return false;
        }
        return true;
    }

    /**
     * Validates that the user typed a single-digit number.
     * Rejects input that contains letters or has more than one character.
     *
     * @param userInput The raw input string entered by the user.
     * @return          0 if the input is invalid; otherwise the parsed integer value.
     */
    public static int validateUserInput(String userInput) {
        // Reject input that is a single letter or longer than one character
        if (userInput.trim().matches("[a-zA-Z]") || userInput.trim().length() > 1) {
            System.out.println("Wrong input, please insert only numbers");
            return 0;
        }
        try {
            // Attempt to parse the trimmed input as an integer
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            // Notify the user if parsing fails
            System.out.println("Wrong input, please insert only numbers");
            return 0;
        }
    }

    /**
     * Repeatedly prompts the user for a menu choice until a valid non-zero integer is entered.
     * Delegates validation to validateUserInput() and retries on invalid input.
     *
     * @param scanner The Scanner instance used to read user input.
     * @return        The validated integer choice entered by the user.
     */
    public static int getValidChoice(Scanner scanner) {
        int choice = 0;
        while (choice == 0) {
            System.out.print("\nEnter choice: ");
            String input = scanner.nextLine();
            // Keep looping until a valid non-zero value is returned
            choice = validateUserInput(input);
        }
        return choice;
    }

    /**
     * Displays all available ManagerType options and prompts the user to select one.
     * Keeps prompting until the input maps to a valid ManagerType enum value.
     *
     * @param scanner The Scanner instance used to read user input.
     * @return        The valid ManagerType selected by the user.
     */
    public static ManagerType getValidManagerType(Scanner scanner) {
        System.out.println("\nPlease select from the following Management Staff:\n");

        // Display each ManagerType with its associated numeric value
        for (ManagerType mt : ManagerType.values()) {
            System.out.println("  " + mt.getValue() + ". " + mt);
        }

        ManagerType selected = null;
        while (selected == null) {
            int choice = getValidChoice(scanner);

            // Attempt to match the numeric choice to a ManagerType enum constant
            selected = ManagerType.fromValue(choice);

            if (selected == null) {
                // Inform the user if no matching ManagerType was found
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return selected;
    }

    /**
     * Displays all available Department options and prompts the user to select one.
     * Keeps prompting until the input maps to a valid Department enum value.
     *
     * @param scanner The Scanner instance used to read user input.
     * @return        The valid Department selected by the user.
     */
    public static Department getValidDepartment(Scanner scanner) {
        System.out.println("\nPlease select the Department:\n");

        // Display each Department with its associated numeric value
        for (Department dept : Department.values()) {
            System.out.println("  " + dept.getValue() + ". " + dept);
        }

        Department selected = null;
        while (selected == null) {
            int choice = getValidChoice(scanner);

            // Attempt to match the numeric choice to a Department enum constant
            selected = Department.fromValue(choice);

            if (selected == null) {
                // Inform the user if no matching Department was found
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return selected;
    }

    /**
     * Prompts the user for a numeric input and maps it to a MainMenu enum option.
     * Does not loop — returns null if the choice does not match any MainMenu value.
     *
     * @param scanner The Scanner instance used to read user input.
     * @return        The MainMenu option matching the user's input, or null if invalid.
     */
    public static MainMenu getValidMenuOption(Scanner scanner) {
        int choice = getValidChoice(scanner);
        // Map the numeric choice to a MainMenu enum constant
        return MainMenu.fromValue(choice);
    }
}