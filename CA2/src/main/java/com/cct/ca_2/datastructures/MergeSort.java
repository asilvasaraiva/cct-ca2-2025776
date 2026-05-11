/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.datastructures;

import com.cct.ca_2.entities.Employee;
import java.util.ArrayList;
import java.util.List;


/**
 * @author alexsandrosaraiva
 * Recursive Merge Sort for Employee lists.
 *
 * Why Merge Sort:
 *   Guarantees O(n log n) worst-case, unlike Quick Sort which degrades to O(n^2)
 *     on sorted or nearly-sorted inputs.
 *   Employees with the same name keep their original relative order.
 *   Naturally recursive divide-and-conquer structure.
 */
public class MergeSort {

    public static List<Employee> sort(List<Employee> list) {
        if (list.size() <= 1){
            return new ArrayList<>(list);
        }

        int mid = list.size() / 2;
        List<Employee> left  = sort(list.subList(0, mid));
        List<Employee> right = sort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private static List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getFullName().compareToIgnoreCase(right.get(j).getFullName()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()){
            result.add(left.get(i++));
        }
        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
}