/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

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

    
}
