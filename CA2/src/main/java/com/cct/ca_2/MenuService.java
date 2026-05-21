/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2;

import com.cct.ca_2.datastructures.MergeSort;
import com.cct.ca_2.entities.Employee;
import com.cct.ca_2.enums.Department;
import com.cct.ca_2.enums.MainMenu;
import com.cct.ca_2.enums.ManagerType;
import com.cct.ca_2.utils.InputValidator;
import com.cct.ca_2.utils.SearchUtil;
import com.cct.ca_2.utils.SortUtils;
import com.cct.ca_2.utils.TreeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Service class responsible for managing the interactive menu loop.
 * Handles user navigation and delegates actions to the appropriate utility classes.
 *
 * @author alexsandrosaraiva
 */
public class MenuService {

    // The current list of employees — may be updated after sort, search, or add operations
    private List<Employee> employees;

    // Tracks only the employees added during the current session
    private final List<Employee> newlyAdded;

    // Scanner instance shared across all input operations
    private final Scanner scanner;

    /**
     * Constructs a MenuService with the loaded employee list and a shared scanner.
     *
     * @param employees The initial list of Employee objects loaded from file.
     * @param scanner   The Scanner instance used to read user input.
     */
    public MenuService(List<Employee> employees, Scanner scanner) {
        this.employees  = employees;
        this.newlyAdded = new ArrayList<>();
        this.scanner    = scanner;
    }

    /**
     * Starts and maintains the interactive menu loop.
     *
     * Displays the main menu options, reads and validates the user's choice,
     * and delegates to the corresponding operation until the user selects EXIT.
     */
    public void show() {
        boolean running = true;

        while (running) {
            // Display the main menu header and all available options
            System.out.println("\n----------------------------------------");
            System.out.println("Do You wish to SORT or SEARCH:\n");

            // Iterate over all MainMenu enum values and print each with its numeric key
            for (MainMenu option : MainMenu.values()) {
                System.out.println("  " + option.getValue() + ". " + option);
            }

            // Read and validate the user's menu selection
            MainMenu selected = InputValidator.getValidMenuOption(scanner);

            if (selected == null) {
                // Reject unrecognised input and prompt again
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (selected) {
                case SORT -> {
                    // Sort and display all employees alphabetically by full name
                    employees = SortUtils.sortAndDisplay(employees);
                }
                case SEARCH -> {
                    // Search for an employee by full name using binary search
                    employees = SearchUtil.searchAndDisplay(employees, scanner);
                }
                case ADD_RECORDS -> {
                    // Prompt the user to add a new employee record
                    addRecord();
                }
                case CREATE_BINARY_TREE -> {
                    // Build and display the employee hierarchy as a binary tree
                    TreeUtil.buildAndDisplay(employees);
                }
                case EXIT -> {
                    // Exit the menu loop and terminate the application
                    System.out.println("\n Thank you for using our program! Goodbye!");
                    running = false;
                }
            }
        }
    }

    /**
     * Prompts the user to enter details for a new employee and adds them to the list.
     *
     * Collects first name, last name, manager type, and department via validated input.
     * Adds the new employee to the main list and the session-scoped newlyAdded list,
     * then re-sorts the full list alphabetically.
     * Displays all newly added records for the current session after each addition.
     */
    private void addRecord() {
        System.out.println("\nADD RECORDS\n");

        // Collect and validate the new employee's first and last name
        String firstName = InputValidator.getValidName(scanner, "Please enter first name: ");
        String lastName  = InputValidator.getValidName(scanner, "Please enter last name: ");

        // Collect and validate the manager type and department via enum selection
        ManagerType managerType = InputValidator.getValidManagerType(scanner);
        Department  department  = InputValidator.getValidDepartment(scanner);

        // Create the new Employee object and add it to both tracking lists
        Employee newEmp = new Employee(firstName, lastName, managerType.toString(), department.toString());
        employees.add(newEmp);
        newlyAdded.add(newEmp);

        // Re-sort the employee list after insertion to maintain alphabetical order
        employees = MergeSort.sort(employees);

        // Confirm the addition to the user
        System.out.println("\n\"" + newEmp.getFullName() + "\" has been added as \""
                + managerType + "\" to \"" + department + "\" successfully!");

        // Display all employees added during the current session
        System.out.println("\n-- All Newly Added Records --\n");
        System.out.println("# | Full Name | Manager Type | Department");
        System.out.println("-".repeat(60));

        // Print each newly added employee with a 1-based index
        for (int i = 0; i < newlyAdded.size(); i++) {
            System.out.println((i + 1) + " | "
                    + newlyAdded.get(i).getFullName()    + " | "
                    + newlyAdded.get(i).getManagerType() + " | "
                    + newlyAdded.get(i).getDepartment());
        }
    }
}