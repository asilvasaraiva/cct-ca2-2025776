/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2;

import com.cct.ca_2.datastructures.MergeSort;
import com.cct.ca_2.entities.Employee;
import com.cct.ca_2.enums.Department;
import com.cct.ca_2.enums.MainMenu;
import com.cct.ca_2.enums.ManagerType;
import com.cct.ca_2.utils.InputValidator;
import com.cct.ca_2.utils.SearchUtil;
import com.cct.ca_2.utils.SortUtils;
import com.cct.ca_2.utils.TreeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexsandrosaraiva
 */
public class MenuService {

    private List<Employee> employees;
    private final List<Employee> newlyAdded;
    private final Scanner scanner;

    public MenuService(List<Employee> employees, Scanner scanner) {
        this.employees = employees;
        this.newlyAdded = new ArrayList<>();
        this.scanner = scanner;
    }

    public void show() {
        boolean running = true;

        while (running) {
            //Text following the assignment example
            System.out.println("\n----------------------------------------");
            System.out.println("Do You wish to SORT or SEARCH:\n");
            for (MainMenu option : MainMenu.values()) { //Loop getting each manu value and showing in the screen
                System.out.println("  " + option.getValue() + ". " + option);
            }

            MainMenu selected = InputValidator.getValidMenuOption(scanner);

            if (selected == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (selected) {
                case SORT ->{
                    employees = SortUtils.sortAndDisplay(employees);
                }
                case SEARCH-> {
                    employees = SearchUtil.searchAndDisplay(employees, scanner);
                }
                case ADD_RECORDS->{
                    addRecord();
                }
                case CREATE_BINARY_TREE->{
                    TreeUtil.buildAndDisplay(employees);
                }
                case EXIT -> {
                    System.out.println("\n Thank you for using our program! Goodbye!");
                    running = false;
                }
            }
        }
    }

    private void addRecord() {
        System.out.println("\nADD RECORDS\n");

        String firstName = InputValidator.getValidName(scanner, "Please enter first name: ");
        String lastName  = InputValidator.getValidName(scanner, "Please enter last name: ");

        ManagerType managerType = InputValidator.getValidManagerType(scanner);
        Department department   = InputValidator.getValidDepartment(scanner);

        Employee newEmp = new Employee(firstName, lastName, managerType.toString(), department.toString());
        employees.add(newEmp);
        newlyAdded.add(newEmp);

        employees = MergeSort.sort(employees);

        System.out.println("\n\"" + newEmp.getFullName() + "\" has been added as \"" + managerType + "\" to \"" + department + "\" successfully!");

        System.out.println("\n-- All Newly Added Records --\n");
        System.out.println("# | Full Name | Manager Type | Department");
        System.out.println("-".repeat(60)); // to print 60 times the " - "
        for (int i = 0; i < newlyAdded.size(); i++) {
            System.out.println((i + 1) + " | " + newlyAdded.get(i).getFullName() + " | " + newlyAdded.get(i).getManagerType() + " | " + newlyAdded.get(i).getDepartment());
        }
    }
}
