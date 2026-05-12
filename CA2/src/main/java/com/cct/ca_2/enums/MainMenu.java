/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.enums;

/**
 *
 * @author alexsandrosaraiva
 */
public enum MainMenu {
    SORT(1, "SORT"),
    SEARCH(2, "SEARCH"),
    ADD_RECORDS(3, "ADD RECORDS"),
    CREATE_BINARY_TREE(4, "Create Binary Tree"),
    EXIT(5, "EXIT");

    private final int value;
    private final String label;

    MainMenu(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() { return value; }

    @Override
    public String toString() { return label; }

    public static MainMenu fromValue(int v) {
        for (MainMenu m : values()) {
            if (m.value == v) return m;
        }
        return null;
    }
}