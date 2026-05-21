# Bank Employee Management System

## Project Overview

This project, **Bank Employee Management System**, is an academic project developed for the **Algorithms and Constructs** course. The main goal of this project is to demonstrate the application of fundamental algorithms and data structures in a practical scenario. The system is designed to manage employee records for a fictional bank, providing functionalities such as sorting, searching, and organizing employees in a binary tree structure.

## Features

The system includes the following key features:

1. **File Reading**: 
   - Reads employee records from a CSV file.
   - Validates the file format and loads employee data into the system.

2. **Sorting**:
   - Implements **Merge Sort** to sort employee records by their full names.
   - Guarantees `O(n log n)` complexity and maintains the stability of records with the same name.

3. **Searching**:
   - Implements **Binary Search** to efficiently find employees by their full names in a sorted list.
   - Provides `O(log n)` complexity for search operations.

4. **Binary Tree**:
   - Builds a binary tree using **level-order insertion** (breadth-first).
   - Displays the tree hierarchy using level-order traversal.
   - Calculates tree statistics such as height and total node count.

5. **Input Validation**:
   - Ensures user inputs are valid, including names, menu choices, and other fields.
   - Provides clear error messages for invalid inputs.

6. **Menu-Driven Interface**:
   - Offers a user-friendly menu to interact with the system.
   - Allows users to sort, search, add records, and create/display the binary tree.

## Project Structure

The project is organized into the following main components:

- **Entities**:
  - `Employee`: Represents an employee with attributes such as name, department, and manager type.
  - `TreeNode`: Represents a node in the binary tree.

- **Data Structures**:
  - `EmployeeTree`: Implements a binary tree for organizing employees.
  - `MergeSort`: Implements the recursive merge sort algorithm.
  - `BinarySearch`: Implements the recursive binary search algorithm.

- **Utilities**:
  - `InputValidator`: Handles user input validation.
  - `MyFileReader`: Reads employee data from a CSV file.
  - `SortUtils`: Provides utilities for sorting and displaying sorted data.
  - `SearchUtil`: Provides utilities for searching and displaying search results.
  - `TreeUtil`: Handles building and displaying the binary tree.

- **Enums**:
  - `Department`: Represents different departments in the bank.
  - `ManagerType`: Represents different management roles.
  - `MainMenu`: Represents the main menu options.

- **Main Classes**:
  - `CA2`: The entry point of the application.
  - `MenuService`: Manages the menu-driven interface and user interactions.

## How to Run

1. **Prerequisites**:
   - Java 18 or higher.
   - Maven for dependency management and building the project.

2. **Build the Project**:
   - Navigate to the project directory and run:
     ```sh
     mvn clean install
     ```

3. **Run the Application**:
   - Execute the application using:
     ```sh
     java -jar target/CA2-1.0-SNAPSHOT.jar
     ```

4. **Follow the Menu**:
   - Enter the filename containing employee records.
   - Use the menu options to sort, search, add records, or create/display the binary tree.

## Academic Purpose

This project was developed to apply and reinforce the following concepts:

- Recursive algorithms (Merge Sort, Binary Search).
- Data structures (Binary Trees, Lists).
- Input validation and error handling.
- File I/O operations.
- Object-oriented programming principles.

## Author

This project was developed by **Alexsandro Saraiva** as part of the coursework for the **Algorithms and Constructs** discipline.
