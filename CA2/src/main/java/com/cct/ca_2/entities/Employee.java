/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.entities;

/**
 *
 * @author alexsandrosaraiva
 * Classe which Helds the Employee data, with the necessary getters and a toString method for formatted output.
 */
public class Employee {

    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final String managerType;
    private final String department;

    public Employee(String firstName, String lastName, String managerType, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Trim to avoid trailing space when lastName is empty
        this.fullName = (firstName + " " + lastName).trim();
        this.managerType = managerType;
        this.department = department;
    }

    public String getFirstName()   { return firstName; }
    public String getLastName()    { return lastName; }
    public String getFullName()    { return fullName; }
    public String getManagerType() { return managerType; }
    public String getDepartment()  { return department; }


    @Override
    public String toString() {
        return String.format("%-25s | %-20s | %s", fullName, managerType, department);
    }
}