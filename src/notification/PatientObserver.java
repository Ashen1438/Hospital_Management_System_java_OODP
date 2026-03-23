/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notification;

/**
 *
 * @author ashen
 */
public class PatientObserver implements Observer {

    private String patientName;

    public PatientObserver(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + patientName + ": " + message);
    }
}
