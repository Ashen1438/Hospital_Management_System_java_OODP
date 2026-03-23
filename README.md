# Hospital Management System

A console-based Hospital Management System developed in **Java** using **NetBeans IDE**. This project was created for the **Object-Oriented Design Patterns and Principles** subject to demonstrate the practical use of object-oriented concepts, design patterns, and SOLID principles in a real-world application.

## Project Overview

This application simulates basic hospital operations through a command-line interface. It helps manage patients, doctors, appointments, billing, and notifications in a structured and modular way.

The system was designed to reduce the inefficiencies of manual hospital administration by automating common tasks such as:

- Patient registration
- Doctor management
- Appointment booking
- Bill generation
- Notification handling

## Features

- Register patients as **In-Patients** or **Out-Patients**
- Add doctors with their specialization
- Book appointments for patients with doctors
- View patient details
- View doctor details
- View appointment details
- Generate bills using different billing methods
- Display appointment notifications through the console

## Technologies Used

- **Java**
- **NetBeans IDE**
- **Object-Oriented Programming (OOP)**
- Java standard libraries:
  - `java.util.Scanner`
  - `java.util.ArrayList`

## Project Structure

```text
HospitalManagementSystem
│
├── src
│   ├── hospital
│   │   └── Main.java
│   ├── patient
│   │   ├── Patient.java
│   │   ├── InPatient.java
│   │   └── OutPatient.java
│   ├── doctor
│   │   └── Doctor.java
│   ├── appointment
│   │   └── Appointment.java
│   ├── factory
│   │   └── PatientFactory.java
│   ├── strategy
│   │   ├── BillingStrategy.java
│   │   ├── InPatientBilling.java
│   │   └── OutPatientBilling.java
│   ├── database
│   │   └── HospitalDatabase.java
│   └── notification
│       ├── Observer.java
│       ├── Subject.java
│       ├── PatientObserver.java
│       └── AppointmentNotifier.java
Design Patterns Implemented

This project demonstrates the use of several design patterns:

1. Factory Pattern

Used in PatientFactory to create different patient objects such as:

InPatient
OutPatient

This separates object creation from the main business logic.

2. Strategy Pattern

Used for billing calculation through:

BillingStrategy
InPatientBilling
OutPatientBilling

This allows different billing algorithms to be selected dynamically.

3. Singleton Pattern

Used in HospitalDatabase to ensure there is only one shared database instance in the system.

4. Observer Pattern

Used in the notification module:

AppointmentNotifier
PatientObserver

This allows patients to receive notifications when appointments are booked.

SOLID Principles Applied

This project also follows key SOLID principles:

Single Responsibility Principle
Each class has a specific responsibility. For example, billing, notification, and patient creation are handled separately.
Open/Closed Principle
The system can be extended with new patient types or billing strategies without changing existing core logic.
Dependency Inversion Principle
High-level modules depend on abstractions such as interfaces like BillingStrategy and Observer.
How to Run the Project
Using NetBeans IDE
Open NetBeans IDE
Click File > Open Project
Select the HospitalManagementSystem project folder
Build and run the project
Using Command Line
Compile all Java files
Run the Main class
Sample Menu
===== HOSPITAL MANAGEMENT SYSTEM =====
1. Register Patient
2. Add Doctor
3. Book Appointment
4. View Patient Details
5. View Doctor Details
6. View Appointment Details
7. Generate Bill
8. Exit
Example Functionalities
Register Patient

Users can register patients by selecting a patient type:

IN
OUT
Add Doctor

Doctors can be added with:

Doctor ID
Doctor Name
Specialization
Book Appointment

Appointments are created by linking:

Patient ID
Doctor ID
Appointment Date
Generate Bill

Bills are generated using different billing strategies depending on patient type.

Sample Output
Patient registered successfully.
Doctor added successfully.
Appointment booked successfully.
Notification for John: Appointment booked successfully on 2025-09-15
Total Bill: 6000.0
UML Diagrams

This project includes UML diagrams for:

Factory Pattern
Strategy Pattern
Singleton Pattern
Observer Pattern

These diagrams were created as part of the project documentation and report.

Screenshots

Add your project screenshots here after uploading them to the repository.

Example:

## Screenshots

### Main Menu
![Main Menu](screenshots/main-menu.png)

### Register Patient
![Register Patient](screenshots/register-patient.png)

### Add Doctor
![Add Doctor](screenshots/add-doctor.png)

### Book Appointment
![Book Appointment](screenshots/book-appointment.png)

### Generate Bill
![Generate Bill](screenshots/generate-bill.png)
Learning Outcomes

Through this project, the following concepts were practiced:

Object-oriented design
Use of design patterns in Java
Applying SOLID principles
Modular software development
Console-based application design
Limitations

Although the system demonstrates core hospital management functions, it has some limitations:

Data is stored only in memory using ArrayList
No database integration
No graphical user interface
Notifications are simulated through console output only
Future Improvements

Possible future enhancements include:

Add database connectivity using MySQL or PostgreSQL
Develop a GUI using Java Swing or JavaFX
Add login and authentication
Store appointment history permanently
Add advanced billing and reporting features
Author

Ashen Eranga
