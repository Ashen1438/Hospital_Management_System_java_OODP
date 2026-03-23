/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointment;

/**
 *
 * @author ashen
 */
import doctor.Doctor;
import patient.Patient;
import strategy.BillingStrategy;

public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private BillingStrategy billingStrategy;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String date, BillingStrategy billingStrategy) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.billingStrategy = billingStrategy;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void showAppointmentDetails() {
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient Name   : " + patient.getName());
        System.out.println("Doctor Name    : " + doctor.getName());
        System.out.println("Date           : " + date);
    }

    public double generateBill(double baseAmount) {
        return billingStrategy.calculateBill(baseAmount);
    }
}
