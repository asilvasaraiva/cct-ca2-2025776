/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.datastructures;

import com.cct.ca_2.entities.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * Recursive Merge Sort implementation for Employee lists.
 *
 * Why Merge Sort:
 *   Guarantees O(n log n) worst-case, unlike Quick Sort which degrades to O(n^2)
 *   on sorted or nearly-sorted inputs.
 *   Employees with the same name keep their original relative order (stable sort).
 *   Naturally recursive divide-and-conquer structure.
 *
 * @author alexsandrosaraiva
 */
public class MergeSort {

    /**
     * Recursively sorts a list of employees by full name (case-insensitive).
     *
     * Divides the list into two halves, recursively sorts each half,
     * then merges the sorted halves back together.
     *
     * Time complexity:  O(n log n) — guaranteed for all cases.
     * Space complexity: O(n)       — new lists are created at each merge step.
     *
     * @param list The list of Employee objects to sort.
     * @return     A new sorted list of Employee objects ordered alphabetically by full name.
     */
    public static List<Employee> sort(List<Employee> list) {
        // Base case: a list of 0 or 1 elements is already sorted
        if (list.size() <= 1) {
            return new ArrayList<>(list);
        }

        // Find the midpoint to divide the list into two halves
        int mid = list.size() / 2;

        // Recursively sort the left half
        List<Employee> left  = sort(list.subList(0, mid));

        // Recursively sort the right half
        List<Employee> right = sort(list.subList(mid, list.size()));

        // Merge the two sorted halves and return the result
        return merge(left, right);
    }

    /**
     * Merges two sorted employee lists into a single sorted list.
     *
     * Compares the front elements of each list and appends the smaller one
     * to the result. Once one list is exhausted, the remaining elements
     * of the other list are appended directly.
     *
     * Time complexity:  O(n) because each element is visited exactly once.
     * Space complexity: O(n) because a new result list is allocated.
     *
     * @param left  The left sorted sub-list.
     * @param right The right sorted sub-list.
     * @return      A new merged and sorted list combining both inputs.
     */
    private static List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int i = 0, j = 0;

        // Compare elements from both lists and append the smaller one to result
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getFullName().compareToIgnoreCase(right.get(j).getFullName()) <= 0) {
                // Left element is smaller or equal — append it and advance left pointer
                result.add(left.get(i++));
            } else {
                // Right element is smaller — append it and advance right pointer
                result.add(right.get(j++));
            }
        }

        // Append any remaining elements from the left list
        while (i < left.size()) {
            result.add(left.get(i++));
        }

        // Append any remaining elements from the right list
        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
}