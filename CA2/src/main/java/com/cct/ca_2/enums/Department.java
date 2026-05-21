/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.enums;

/**
 *
 * @author alexsandrosaraiva
 * Class which represents the Department enum, with a value and label for each department, and a method to get the enum from an integer value.
 */
public enum Department {
    CUSTOMER_SERVICE(1, "Customer Service"),
    HR(2, "HR"),
    FINANCE(3, "Finance"),
    IT_DEVELOPMENT(4, "IT Development"),
    SALES(5, "Sales");

    private final int value;
    private final String label;

    Department(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() { return value; }

    @Override
    public String toString() { return label; }

    public static Department fromValue(int v) {
        for (Department d : values()) {
            if (d.value == v) return d;
        }
        return null;
    }
}