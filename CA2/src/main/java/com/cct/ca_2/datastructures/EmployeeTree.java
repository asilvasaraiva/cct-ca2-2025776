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
 * Binary tree using level-order (breadth-first) insertion.
 *
 * WHY Queue (ArrayList used as a queue here)?
 * Level-order insertion requires visiting nodes level by level (top to bottom,
 * left to right) to find the first empty spot. A queue (FIFO structure) is the
 * natural choice because it processes nodes in the exact order they were added —
 * ensuring we always fill left child first, then right, then move to the next
 * level. Without a queue, we would need complex index calculations or recursion
 * that doesn't guarantee breadth-first order and this method was also demonstrated in class.
 *
 * ArrayList was used as a simple queue (remove from index 0,
 * add to the end) to keep the code straightforward.
 *
 * @author alexsandrosaraiva
 */
public class EmployeeTree {

    // Root node of the binary tree
    private TreeNode root;

    /**
     * Constructs an empty EmployeeTree.
     * The root is initialised to null, representing an empty tree.
     */
    public EmployeeTree() {
        this.root = null;
    }

    /**
     * Inserts a new employee into the tree using level-order (BFS) insertion.
     *
     * Traverses the tree level by level using an ArrayList as a FIFO queue,
     * placing the new node in the first available left or right child slot.
     * This ensures the tree remains as balanced as possible.
     *
     * Time complexity: O(n) — must traverse existing nodes to find the insertion point.
     *
     * @param emp The Employee object to insert into the tree.
     */
    public void insert(Employee emp) {
        // Wrap the employee in a new tree node
        TreeNode newNode = new TreeNode(emp);

        // If the tree is empty, assign the new node as the root
        if (root == null) {
            root = newNode;
            return;
        }

        // ArrayList used as a FIFO queue:
        // remove(0) = dequeue front element
        // add()     = enqueue to the back
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Dequeue the front node for inspection
            TreeNode current = queue.remove(0);

            // Insert as left child if the slot is empty
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }
            // Otherwise enqueue the left child for further traversal
            queue.add(current.getLeft());

            // Insert as right child if the slot is empty
            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }
            // Otherwise enqueue the right child for further traversal
            queue.add(current.getRight());
        }
    }

    /**
     * Builds the binary tree by inserting all employees from the given list.
     * Iterates through the list and calls insert() for each employee.
     *
     * @param employees The list of Employee objects to populate the tree with.
     */
    public void buildFromList(List<Employee> employees) {
        for (Employee emp : employees) {
            insert(emp);
        }
    }

    /**
     * Displays the tree hierarchy using level-order (BFS) traversal.
     *
     * Visits each node level by level using an ArrayList as a queue,
     * printing each employee's full name, manager type, and department.
     * Each level is clearly labelled for readability.
     *
     * Time complexity: O(n) — every node is visited exactly once.
     */
    public void displayLevelOrder() {
        // Handle the edge case of an empty tree
        if (root == null) {
            System.out.println(" [!] - tree is empty");
            return;
        }

        // Initialise the queue with the root node to begin traversal
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            // Capture the number of nodes at the current level
            int size = queue.size();
            System.out.println("  Level " + level + ":");

            // Process all nodes belonging to the current level
            for (int i = 0; i < size; i++) {
                // Dequeue the next node and retrieve its employee data
                TreeNode current = queue.remove(0);
                Employee e = current.getEmployee();

                // Print the employee details in a formatted line
                System.out.printf("    [%s] - %s - %s%n",
                        e.getFullName(), e.getManagerType(), e.getDepartment());

                // Enqueue the left child if it exists
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                // Enqueue the right child if it exists
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            // Increment level counter after all nodes in the current level are displayed
            level++;
        }
    }

    /**
     * Returns the height of the binary tree.
     * Delegates the calculation to the recursive countHeight() helper.
     *
     * @return The height of the tree (number of levels).
     */
    public int getHeight() {
        return countHeight(root);
    }

    /**
     * Recursively calculates the height of the subtree rooted at the given node.
     * Height is defined as the number of edges on the longest path from root to leaf.
     *
     * Time complexity: O(n) — visits every node once.
     *
     * @param node The root node of the subtree to measure.
     * @return     0 if the node is null; otherwise 1 plus the maximum height of its subtrees.
     */
    private int countHeight(TreeNode node) {
        // Base case: a null node contributes 0 to the height
        if (node == null) return 0;

        // Recursively find the taller subtree and add 1 for the current node
        return 1 + Math.max(countHeight(node.getLeft()), countHeight(node.getRight()));
    }

    /**
     * Returns the total number of nodes in the binary tree.
     * Delegates the calculation to the recursive countNodes() helper.
     *
     * @return The total node count of the tree.
     */
    public int getNodeCount() {
        return countNodes(root);
    }

    /**
     * Recursively counts all nodes in the subtree rooted at the given node.
     *
     * Time complexity: O(n) — every node is visited exactly once.
     *
     * @param node The root node of the subtree to count.
     * @return     0 if the node is null; otherwise 1 plus the count of both subtrees.
     */
    private int countNodes(TreeNode node) {
        // Base case: a null node contributes 0 to the count
        if (node == null) return 0;

        // Count the current node plus all nodes in both subtrees
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
}