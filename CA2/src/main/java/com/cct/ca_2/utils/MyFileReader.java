/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cct.ca_2.utils;

import com.cct.ca_2.entities.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexsandrosaraiva
 */
public class MyFileReader {

    /**
     * Reads employee records from a CSV file.
     * Expected header: First name,Last name,Gender,Email,Salary,Department,Position,Job title,Company
     */
    public static List<Employee> readEmployees(String filename) {
        List<Employee> list = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("Error: file '" + filename + "' not found.");
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // skip header

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length < 9) continue;

                String firstName  = parts[0].trim();
                String lastName   = parts[1].trim();
                String department = parts[5].trim();
                String jobTitle   = parts[7].trim();

                list.add(new Employee(firstName, lastName, jobTitle, department));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }
}