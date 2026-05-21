/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cct.ca_2;

import com.cct.ca_2.entities.Employee;
import com.cct.ca_2.utils.MyFileReader;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the Bank Employee Management System.
 *
 * @author alexsandrosaraiva
 */
public class CA2 {

    /**
     * Application entry point.
     * Prompts the user for a filename, loads employee records from the file,
     * and starts the interactive menu loop.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****************************************");
        System.out.println("   BANK EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("****************************************");

        // Keep prompting until a valid file with at least one record is loaded
        List<Employee> employees = null;
        while (employees == null || employees.isEmpty()) {
            System.out.print("\nPlease enter the filename to read: ");
            String filename = scanner.nextLine().trim();

            // Attempt to read employee records from the specified file
            employees = MyFileReader.readEmployees(filename);

            if (employees.isEmpty()) {
                // Warn the user if the file was empty or unreadable
                System.out.println("No records founded inside the file. Please try again.");
            } else {
                // Confirm how many records were successfully loaded
                System.out.println("File read successfully (" + employees.size() + " records loaded)");
            }
        }

        // Initialise the menu service and start the interactive loop
        MenuService menu = new MenuService(employees, scanner);
        menu.show();

        // Release the scanner resource before exiting
        scanner.close();
    }
}