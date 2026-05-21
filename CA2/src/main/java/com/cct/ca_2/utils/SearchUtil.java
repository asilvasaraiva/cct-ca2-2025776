/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.datastructures.BinarySearch;
import com.cct.ca_2.datastructures.MergeSort;
import com.cct.ca_2.entities.Employee;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class responsible for handling employee search operations.
 * Sorts the employee list before performing a binary search by full name.
 *
 * @author alexsandrosaraiva
 */
public class SearchUtil {

    /**
     * Sorts the employee list and searches for a specific employee by full name.
     *
     * First sorts the list using MergeSort (required for binary search to work correctly),
     * then prompts the user to enter a first and last name, and performs a recursive
     * BinarySearch on the sorted list. Displays the result or a not-found message.
     *
     * Time complexity: O(n log n) for sorting + O(log n) for searching.
     *
     * @param employees The unsorted list of Employee objects to search within.
     * @param scanner   The Scanner instance used to read user input.
     * @return          The sorted list of Employee objects after the search operation.
     */
    public static List<Employee> searchAndDisplay(List<Employee> employees, Scanner scanner) {
        // Sort the employee list alphabetically before performing binary search
        List<Employee> sorted = MergeSort.sort(employees);

        System.out.println("\n SEARCH selected - Binary Search (Recursive)\n");

        // Prompt the user to enter the first and last name of the employee to find
        String firstName = InputValidator.getValidName(scanner, "Enter first name: ");
        String lastName  = InputValidator.getValidName(scanner, "Enter last name: ");

        // Combine first and last name to form the full name search target
        String target = firstName + " " + lastName;

        // Perform recursive binary search on the sorted list using the full name
        int index = BinarySearch.search(sorted, target, 0, sorted.size() - 1);

        if (index != -1) {
            // Retrieve and display the matched employee's details
            Employee found = sorted.get(index);
            System.out.println("\n --- RECORD FOUND ---");
            System.out.println("Name: "         + found.getFullName());
            System.out.println("Manager Type: " + found.getManagerType());
            System.out.println("Department: "   + found.getDepartment());
        } else {
            // Notify the user that no matching record was found
            System.out.println("\n\"" + target + "\" was NOT found in the list.");
        }

        // Return the sorted list for potential reuse by the caller
        return sorted;
    }
}