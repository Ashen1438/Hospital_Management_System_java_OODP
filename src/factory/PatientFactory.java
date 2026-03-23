/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author ashen
 */
import patient.InPatient;
import patient.OutPatient;
import patient.Patient;

public class PatientFactory {

    public static Patient createPatient(String type, String id, String name, int age, String disease) {

        if (type.equalsIgnoreCase("IN")) {
            return new InPatient(id, name, age, disease);
        } else if (type.equalsIgnoreCase("OUT")) {
            return new OutPatient(id, name, age, disease);
        }

        return null;
    }
}











