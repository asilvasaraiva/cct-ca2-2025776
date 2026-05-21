/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.datastructures.EmployeeTree;
import com.cct.ca_2.entities.Employee;
import java.util.List;

/**
 * Utility class responsible for building and displaying the employee binary tree.
 * Delegates tree construction and traversal to the EmployeeTree data structure.
 *
 * @author alexsandrosaraiva
 */
public class TreeUtil {

    /**
     * Builds a binary tree from the given employee list and displays its hierarchy.
     *
     * Constructs an EmployeeTree using level-order (BFS) insertion, then prints
     * the full tree hierarchy via level-order traversal. Also displays tree
     * statistics such as height and total node count.
     *
     * Time complexity: O(n) — each employee is inserted and visited exactly once.
     *
     * @param employees The list of Employee objects to insert into the binary tree.
     */
    public static void buildAndDisplay(List<Employee> employees) {
        System.out.println("\nEMPLOYEE HIERARCHY - Binary Tree (Level-Order Insertion)\n");

        // Initialise a new empty binary tree
        EmployeeTree tree = new EmployeeTree();

        // Populate the tree with all employees from the list
        tree.buildFromList(employees);

        // Confirm how many employees were inserted into the tree
        System.out.println("Inserted " + employees.size() + " employee(s).\n");
        System.out.println("-- Hierarchy (Level-Order Traversal) --\n");

        // Display the full tree level by level
        tree.displayLevelOrder();

        // Print tree statistics: height and total number of nodes
        System.out.println("\n-- Tree Statistics --");
        System.out.println("Height: "      + tree.getHeight());
        System.out.println("Total Nodes: " + tree.getNodeCount());
    }
}