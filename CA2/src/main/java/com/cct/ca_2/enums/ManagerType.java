/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.enums;

/**
 *
 * @author alexsandrosaraiva
 */
public enum ManagerType {
    HEAD_MANAGER(1, "Head Manager"),
    SENIOR_MANAGER(2, "Senior Manager"),
    ASSISTANT_MANAGER(3, "Assistant Manager"),
    TEAM_LEAD(4, "Team Lead");

    private final int value;
    private final String label;

    ManagerType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() { return value; }

    @Override
    public String toString() { return label; }

    public static ManagerType fromValue(int v) {
        for (ManagerType m : values()) {
            if (m.value == v) return m;
        }
        return null;
    }
}
