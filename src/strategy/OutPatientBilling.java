/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author ashen
 */
public class OutPatientBilling implements BillingStrategy {

    @Override
    public double calculateBill(double baseAmount) {
        return baseAmount + 1000;
    }
}
