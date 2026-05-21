/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.entities;

/**
 *
 * @author alexsandrosaraiva
 * Class which represents a node in a binary tree, holding an Employee object and references to left and right child nodes.
 */
public class TreeNode {

    private final Employee employee;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }

    public Employee getEmployee() { return employee; }
    public TreeNode getLeft()     { return left; }
    public TreeNode getRight()    { return right; }
    public void setLeft(TreeNode left)   { this.left = left; }
    public void setRight(TreeNode right) { this.right = right; }
}