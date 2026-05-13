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
 *
 * @author alexsandrosaraiva
 */
public class InputValidator {
    /**
     * Asks the user for a single name and validates it.
     */
    public static String getValidName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            if (isValidName(name)) {
                return name;
            }
        }
    }
    
    /**
     * Validates that a name is not empty and contains only letters.
     */
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: name cannot be empty.");
            return false;
        }
        if (!name.trim().matches("[a-zA-Z]+")) {
            System.out.println("Error: name must contain only letters.");
            return false;
        }
        return true;
    }
/**
     * Validates that the user typed a single digit number.
     * @param userInput the raw input string
     * @return 0 if invalid, otherwise the parsed number
     */
    public static int validateUserInput(String userInput) {
        if (userInput.trim().matches("[a-zA-Z]") || userInput.trim().length() > 1) {
            System.out.println("Wrong input, please insert only numbers");
            return 0;
        }
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, please insert only numbers");
            return 0;
        }
    }

    /**
     * Asks the user for a menu choice and validates it.
     */
    public static int getValidChoice(Scanner scanner) {
        int choice = 0;
        while (choice == 0) {
            System.out.print("\nEnter choice: ");
            String input = scanner.nextLine();
            choice = validateUserInput(input);
        }
        return choice;
    }
    
    
    /**
     * Asks the user to select a valid ManagerType.
     */
    public static ManagerType getValidManagerType(Scanner scanner) {
        System.out.println("\nPlease select from the following Management Staff:\n");
        for (ManagerType mt : ManagerType.values()) {
            System.out.println("  " + mt.getValue() + ". " + mt);
        }

        ManagerType selected = null;
        while (selected == null) {
            int choice = getValidChoice(scanner);
            selected = ManagerType.fromValue(choice);
            if (selected == null) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return selected;
    }

    /**
     * Asks the user to select a valid Department.
     */
    public static Department getValidDepartment(Scanner scanner) {
        System.out.println("\nPlease select the Department:\n");
        for (Department dept : Department.values()) {
            System.out.println("  " + dept.getValue() + ". " + dept);
        }

        Department selected = null;
        while (selected == null) {
            int choice = getValidChoice(scanner);
            selected = Department.fromValue(choice);
            if (selected == null) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return selected;
    }

    /**
     * Asks the user to select a valid MainMenu option.
     */
    public static MainMenu getValidMenuOption(Scanner scanner) {
        int choice = getValidChoice(scanner);
        return MainMenu.fromValue(choice);
    }
    
}
