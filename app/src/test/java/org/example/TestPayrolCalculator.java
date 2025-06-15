package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPayrolCalculator {

    @Test
    void ZeroHoursWorked() {
        double expectedGrossPay = 0.0;
        double actualGrossPay = PayrollCalculator.calculateGrossPay(0);
        assertEquals(expectedGrossPay, actualGrossPay);
    }

    @Test
    void LessThanFortyHoursWorked() {
        double expectedGrossPay = 16.78 * 35;
        double actualGrossPay = PayrollCalculator.calculateGrossPay(35);
        assertEquals(expectedGrossPay, actualGrossPay);
    }

    @Test
    void MoreThanFortyHoursWorked() {
        double hourlyRate = 16.78;
        int hoursWorked = 45; // 5 hours overtime
        double expectedGrossPay = (hourlyRate * 40) + (hourlyRate * 1.5 * (hoursWorked - 40));
        double actualGrossPay = PayrollCalculator.calculateGrossPay(45);
        assertEquals(expectedGrossPay, actualGrossPay);
    }

    @Test
    void FourtyHoursWorked() {
        double expectedGrossPay = 16.78 * 40;
        double actualGrossPay = PayrollCalculator.calculateGrossPay(40);
        assertEquals(expectedGrossPay, actualGrossPay);
    }

    @Test
    void DeductionsWithLessThanThreeDependents() {
        double grossPay = 1000.0; // Example gross pay
        int dependents = 2; // Less than 3 dependents
        double expectedDeductions = (grossPay * 0.25) + 10.0 + 15.0; // 25% tax + $10 union dues + $15 for less than 3 dependents
        double actualDeductions = PayrollCalculator.calculateDeductions(grossPay, dependents);
        assertEquals(expectedDeductions, actualDeductions);
    }

    @Test
    void DeductionsWithMoreThanThreeDependents() {
        double grossPay = 1000.0; // Example gross pay
        int dependents = 4; // More than 3 dependents
        double expectedDeductions = (grossPay * 0.25) + 10.0 + 35.0; // 25% tax + $10 union dues + $35 for more than 3 dependents
        double actualDeductions = PayrollCalculator.calculateDeductions(grossPay, dependents);
        assertEquals(expectedDeductions, actualDeductions);
    }

    @Test
    void DeductionWithThreeDependents() {
        double grossPay = 1000.0; // Example gross pay
        int dependents = 3; // Exactly 3 dependents
        double expectedDeductions = (grossPay * 0.25) + 10.0 + 35.0; // 25% tax + $10 union dues + $35 for exactly 3 dependents
        double actualDeductions = PayrollCalculator.calculateDeductions(grossPay, dependents);
        assertEquals(expectedDeductions, actualDeductions);
    }

    @Test 
    void DeductionsWithZeroDependents() {
        double grossPay = 1000.0; // Example gross pay
        int dependents = 0; // Zero dependents
        double expectedDeductions = (grossPay * 0.25) + 10.0 + 15.0; // 25% tax + $10 union dues + $15 for less than 3 dependents
        double actualDeductions = PayrollCalculator.calculateDeductions(grossPay, dependents);
        assertEquals(expectedDeductions, actualDeductions);
    }

    @Test
    void NetPayCalculation() {
        double grossPay = 1000.0; // Example gross pay
        double deductions = 250.0; // Example deductions
        double expectedNetPay = grossPay - deductions;
        double actualNetPay = PayrollCalculator.calculateNetPay(grossPay, deductions);
        assertEquals(expectedNetPay, actualNetPay);
    }

}
