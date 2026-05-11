/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.datastructures.MergeSort;
import com.cct.ca_2.entities.Employee;
import java.util.List;

/**
 *
 * @author alexsandrosaraiva
 */
public class SortUtils {
       public static List<Employee> sortAndDisplay(List<Employee> employees) {
        List<Employee> sorted = MergeSort.sort(employees);

        System.out.println("\nSORT selected - Merge Sort (Recursive)\n");

        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i).getFullName());
        }
        System.out.println("\nTotal records: " + sorted.size());

        return sorted;
    }
    
}
