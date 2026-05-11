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
 *
 * @author alexsandrosaraiva
 */
public class SearchUtil {
     public static List<Employee> searchAndDisplay(List<Employee> employees, Scanner scanner) {
        List<Employee> sorted = MergeSort.sort(employees);

        System.out.println("\n SEARCH selected - Binary Search (Recursive)\n");

        String firstName = InputValidator.getValidName(scanner, "Enter first name: ");
        String lastName  = InputValidator.getValidName(scanner, "Enter last name: ");
        String target = firstName + " " + lastName;

        int index = BinarySearch.search(sorted, target, 0, sorted.size() - 1);

        if (index != -1) {
            Employee found = sorted.get(index);
            System.out.println("\n*** RECORD FOUND ***");
            System.out.println("Name: " + found.getFullName());
            System.out.println("Manager Type: " + found.getManagerType());
            System.out.println("Department: " + found.getDepartment());
        } else {
            System.out.println("\n\"" + target + "\" was NOT found in the list.");
        }

        return sorted;
    }
}
