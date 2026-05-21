/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.datastructures.MergeSort;
import com.cct.ca_2.entities.Employee;
import java.util.List;

/**
 * Utility class responsible for sorting and displaying employee records.
 * Delegates sorting to the MergeSort implementation.
 *
 * @author alexsandrosaraiva
 */
public class SortUtils {

    /**
     * Sorts the employee list alphabetically by full name and displays the results.
     *
     * Uses MergeSort to produce a new sorted list, then prints each employee's
     * full name in order, followed by the total number of records.
     *
     * Time complexity: O(n log n) — determined by the MergeSort algorithm.
     *
     * @param employees The unsorted list of Employee objects to sort.
     * @return          A new sorted list of Employee objects ordered alphabetically by full name.
     */
    public static List<Employee> sortAndDisplay(List<Employee> employees) {
        // Sort the employee list using MergeSort (recursive, stable, O(n log n))
        List<Employee> sorted = MergeSort.sort(employees);

        System.out.println("\nSORT selected - Merge Sort (Recursive)\n");

        // Print each employee's full name with a 1-based index
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i).getFullName());
        }

        // Display the total number of records after sorting
        System.out.println("\nTotal records: " + sorted.size());

        // Return the sorted list for potential reuse by the caller
        return sorted;
    }
}