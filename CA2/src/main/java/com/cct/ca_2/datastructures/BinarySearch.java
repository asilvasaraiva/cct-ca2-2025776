/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.datastructures;

import com.cct.ca_2.entities.Employee;
import java.util.List;

/**
 * Recursive Binary Search implementation for Employee lists.
 *
 * Why Binary Search:
 *   For this project the list will be sorted already enabling O(log n) complexity.
 *   Linear search would be O(n) per query, being inefficient for large lists.
 *
 * @author alexsandrosaraiva
 */
public class BinarySearch {

    /**
     * Recursively searches for an employee by full name within a sorted list.
     *
     * The list must be sorted alphabetically by full name (case-insensitive)
     * before calling this method, as binary search relies on sorted order.
     *
     * Time complexity:  O(log n) — halves the search space on each recursive call.
     * Space complexity: O(log n) — due to recursive call stack depth.
     *
     * @param list   The sorted list of Employee objects to search within.
     * @param target The full name of the employee to find (case-insensitive).
     * @param low    The lower bound index of the current search range.
     * @param high   The upper bound index of the current search range.
     * @return       The index of the matching employee, or -1 if not found.
     */
    public static int search(List<Employee> list, String target, int low, int high) {

        // Base case: search range is exhausted, target not found
        if (low > high) return -1;

        // Calculate the middle index of the current search range
        int mid = (low + high) / 2;

        // Compare the middle employee's full name with the target (case-insensitive)
        int cmp = list.get(mid).getFullName().compareToIgnoreCase(target);

        // Exact match found — return the current index
        if (cmp == 0) return mid;

        // Middle name is alphabetically greater — search the left half
        if (cmp > 0) return search(list, target, low, mid - 1);

        // Middle name is alphabetically smaller — search the right half
        return search(list, target, mid + 1, high);
    }
}