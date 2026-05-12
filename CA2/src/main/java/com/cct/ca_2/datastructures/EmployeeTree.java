/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.datastructures;

import com.cct.ca_2.entities.Employee;
import com.cct.ca_2.entities.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexsandrosaraiva
 * 
 * Binary tree using level-order (breadth-first) insertion.
 *
 * WHY Queue (ArrayList used as a queue here)?
 * Level-order insertion requires visiting nodes level by level (top to bottom,
 * left to right) to find the first empty spot. A queue (FIFO structure) is the
 * natural choice because it processes nodes in the exact order they were added —
 * ensuring we always fill left child first, then right, then move to the next
 * level. Without a queue, we would need complex index calculations or recursion
 * that doesn't guarantee breadth-first order and this method was also demonstrated in class
 *
 * ArrayList was used  as a simple queue (remove from index 0,
 * add to the end) to keep the code straightforward.
 */
public class EmployeeTree {

    private TreeNode root;

    public EmployeeTree() {
        this.root = null;
    }

    /**
     * Inserts a new employee using level-order insertion.
     * Uses an ArrayList as a queue to traverse the tree level by level
     * and find the first available position (left first, then right).
     */
    public void insert(Employee emp) {
        TreeNode newNode = new TreeNode(emp);

        if (root == null) {
            root = newNode;
            return;
        }

        // ArrayList used as a FIFO queue:
        // remove(0) = dequeue
        // add() = enqueue
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove(0); // dequeue first element

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }
            queue.add(current.getLeft()); // enqueue left child

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }
            queue.add(current.getRight()); // enqueue right child
        }
    }

    /**
     * Builds the tree from a list of employees.
     */
    public void buildFromList(List<Employee> employees) {
        for (Employee emp : employees) {
            insert(emp);
        }
    }

    /**
     * Displays the tree hierarchy using level-order traversal.
     * Again uses an ArrayList as a queue to visit nodes level by level.
     */
    public void displayLevelOrder() {
        if (root == null) {
            System.out.println(" [!] - tree is empty");
            return;
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("  Level " + level + ":");

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove(0);
                Employee e = current.getEmployee();
                System.out.printf("    [%s] - %s - %s%n",
                        e.getFullName(), e.getManagerType(), e.getDepartment());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null){
                    queue.add(current.getRight());
                }
            }
            level++; //increase lever after displays every node in the line
        }
    }

    public int getHeight() {
        return countHeight(root);
    }

    private int countHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(countHeight(node.getLeft()), countHeight(node.getRight()));
    }

    public int getNodeCount() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

}
