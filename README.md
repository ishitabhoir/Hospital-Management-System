# Hospital Management System

A console-based Hospital Management System developed using Java, JDBC, and MySQL to manage basic hospital operations.

## Features

- Patient Management
- Doctor Management
- Appointment Scheduling
- Billing Management
- Prescription Management
- View Patient Records
- View Doctor Records
- View Appointments
- View Billing Records
- View Prescriptions

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL

## Project Structure

```text
Hospital-Management-System/
├── src/
│   └── HospitalManagementSystem.java
├── database/
│   └── hospital_db.sql
└── README.md
```

## Database Setup

1. Install MySQL Server and a Java Development Kit (JDK).
2. Open MySQL Workbench or a MySQL command-line client.
3. Execute the SQL script in `database/hospital_db.sql`.
4. Configure the database connection details in the Java source code.
5. Ensure the MySQL JDBC driver is available when compiling and running the application.

## Running the Application

Compile and run the Java program after configuring the database connection and JDBC driver.

The application provides a menu for managing patients, doctors, appointments, billing, and prescriptions.

## Purpose

This project demonstrates basic Java programming, JDBC connectivity, SQL database operations, and CRUD-style hospital record management.
