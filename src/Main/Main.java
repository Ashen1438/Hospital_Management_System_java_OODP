/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ashen
 */
import appointment.Appointment;
import database.HospitalDatabase;
import doctor.Doctor;
import factory.PatientFactory;
import notification.AppointmentNotifier;
import notification.PatientObserver;
import patient.Patient;
import strategy.InPatientBilling;
import strategy.OutPatientBilling;
import strategy.BillingStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalDatabase db = HospitalDatabase.getInstance();
        AppointmentNotifier notifier = new AppointmentNotifier();

        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patient Details");
            System.out.println("5. View Doctor Details");
            System.out.println("6. View Appointment Details");
            System.out.println("7. Generate Bill");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Patient Type (IN/OUT): ");
                    String type = sc.nextLine();

                    System.out.print("Patient ID: ");
                    String pid = sc.nextLine();

                    System.out.print("Patient Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    Patient patient = PatientFactory.createPatient(type, pid, pname, age, disease);

                    if (patient != null) {
                        db.addPatient(patient);
                        notifier.attach(new PatientObserver(pname));
                        System.out.println("Patient registered successfully.");
                    } else {
                        System.out.println("Invalid patient type.");
                    }
                    break;

                case 2:
                    System.out.print("Doctor ID: ");
                    String did = sc.nextLine();

                    System.out.print("Doctor Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Specialization: ");
                    String spec = sc.nextLine();

                    Doctor doctor = new Doctor(did, dname, spec);
                    db.addDoctor(doctor);
                    System.out.println("Doctor added successfully.");
                    break;

                case 3:
                    System.out.print("Appointment ID: ");
                    String aid = sc.nextLine();

                    System.out.print("Patient ID: ");
                    String appPid = sc.nextLine();

                    System.out.print("Doctor ID: ");
                    String appDid = sc.nextLine();

                    System.out.print("Date: ");
                    String date = sc.nextLine();

                    Patient foundPatient = db.findPatient(appPid);
                    Doctor foundDoctor = db.findDoctor(appDid);

                    if (foundPatient != null && foundDoctor != null) {
                        BillingStrategy strategy;

                        if (foundPatient.getClass().getSimpleName().equals("InPatient")) {
                            strategy = new InPatientBilling();
                        } else {
                            strategy = new OutPatientBilling();
                        }

                        Appointment appointment = new Appointment(aid, foundPatient, foundDoctor, date, strategy);
                        db.addAppointment(appointment);
                        notifier.notifyObservers("Appointment booked successfully on " + date);
                        System.out.println("Appointment booked successfully.");
                    } else {
                        System.out.println("Patient or Doctor not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Patient ID: ");
                    String searchPid = sc.nextLine();

                    Patient p = db.findPatient(searchPid);
                    if (p != null) {
                        p.showPatientDetails();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Doctor ID: ");
                    String searchDid = sc.nextLine();

                    Doctor d = db.findDoctor(searchDid);
                    if (d != null) {
                        d.showDoctorDetails();
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Appointment ID: ");
                    String searchAid = sc.nextLine();

                    Appointment a = db.findAppointment(searchAid);
                    if (a != null) {
                        a.showAppointmentDetails();
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Appointment ID: ");
                    String billAid = sc.nextLine();

                    Appointment billApp = db.findAppointment(billAid);
                    if (billApp != null) {
                        System.out.print("Enter Base Amount: ");
                        double base = sc.nextDouble();
                        sc.nextLine();

                        double total = billApp.generateBill(base);
                        System.out.println("Total Bill: " + total);
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
