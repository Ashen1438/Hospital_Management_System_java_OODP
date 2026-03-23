/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

/**
 *
 * @author ashen
 */
public abstract class Patient {
    protected String patientId;
    protected String name;
    protected int age;
    protected String disease;

    public Patient(String patientId, String name, int age, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void showPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Disease   : " + disease);
    }
}
