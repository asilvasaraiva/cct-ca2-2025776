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
 * Utility class responsible for reading employee records from a CSV file.
 *
 * @author alexsandrosaraiva
 */
public class MyFileReader {

    /**
     * Reads employee records from a CSV file and returns them as a list.
     *
     * Expected CSV header (skipped during parsing):
     *   First name, Last name, Gender, Email, Salary, Department, Position, Job title, Company
     *
     * Only the following columns are extracted:
     *   - Index 0: First name
     *   - Index 1: Last name
     *   - Index 5: Department
     *   - Index 7: Job title
     *
     * Lines with fewer than 9 columns are silently skipped.
     *
     * @param filename The path to the CSV file to read.
     * @return         A list of Employee objects parsed from the file;
     *                 returns an empty list if the file is not found or an error occurs.
     */
    public static List<Employee> readEmployees(String filename) {
        List<Employee> list = new ArrayList<>();
        File file = new File(filename);

        // Check whether the specified file exists before attempting to read it
        if (!file.exists()) {
            System.out.println("Error: file '" + filename + "' not found.");
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Skip the header line — it contains column labels, not data
            br.readLine();

            String line;
            // Read each remaining line until end of file
            while ((line = br.readLine()) != null) {
                // Split the line by comma, keeping empty trailing fields
                String[] parts = line.split(",", -1);

                // Skip malformed lines that do not have the expected number of columns
                if (parts.length < 9) continue;

                // Extract the relevant fields from the CSV columns
                String firstName  = parts[0].trim();
                String lastName   = parts[1].trim();
                String department = parts[5].trim();
                String jobTitle   = parts[7].trim();

                // Create a new Employee and add it to the result list
                list.add(new Employee(firstName, lastName, jobTitle, department));
            }
        } catch (IOException e) {
            // Notify the user if an I/O error occurs during file reading
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }
}