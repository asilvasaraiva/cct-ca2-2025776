/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.datastructures;

import com.cct.ca_2.entities.Employee;
import java.util.List;

/**
 *
 * @author alexsandrosaraiva
  * Recursive Binary Search for Employee lists.
 *
 * Why Binary Search:
 *   For this project the list will be sorted already enabling O(log n) complexity.
 *   Linear search would be O(n) per query, being inefficient for large lists.
 */
public class BinarySearch {
       /**
     * Returns the index of the employee with the given full name, or -1 if not found.
     * @param list
     * @param target
     * @param low
     * @param high
     * @return index expected or -1 if not found
     */
    public static int search(List<Employee> list, String target, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int cmp = list.get(mid).getFullName().compareToIgnoreCase(target);

        if (cmp == 0)     return mid;
        if (cmp > 0)      return search(list, target, low, mid - 1);
        return search(list, target, mid + 1, high);
    }
}
