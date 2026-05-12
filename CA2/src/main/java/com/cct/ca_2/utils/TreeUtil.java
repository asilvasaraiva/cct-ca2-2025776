/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.datastructures.EmployeeTree;
import com.cct.ca_2.entities.Employee;
import java.util.List;

/**
 *
 * @author alexsandrosaraiva
 * Handles building and displaying the employee binary tree.
 */
public class TreeUtil {

    /**
     * Builds a binary tree from the employee list and displays the hierarchy.
     */
    public static void buildAndDisplay(List<Employee> employees) {
        System.out.println("\nEMPLOYEE HIERARCHY - Binary Tree (Level-Order Insertion)\n");

        EmployeeTree tree = new EmployeeTree();
        tree.buildFromList(employees);

        System.out.println("Inserted " + employees.size() + " employee(s).\n");
        System.out.println("-- Hierarchy (Level-Order Traversal) --\n");
        tree.displayLevelOrder();

        System.out.println("\n-- Tree Statistics --");
        System.out.println("Height: " + tree.getHeight());
        System.out.println("Total Nodes: " + tree.getNodeCount());
    }
}
