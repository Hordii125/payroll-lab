package org.example;

public class PayrollCalculator {
    public static double calculateGrossPay(int hoursWorked) {
        if (hoursWorked <= 40) {
            return 16.78 * hoursWorked;
        } else {
            double overtimeHours = hoursWorked - 40;
            double overtimeRate = 16.78 * 1.5;
            return (16.78 * 40) + (overtimeRate * overtimeHours);
        }
    }

    public static double calculateDeductions(double grossPay, int dependents) {
        double social_security_tax = 0.06; // 6% withheld for social security tax
        double federal_tax = 0.14; // 14% withheld for federal income tax
        double state_tax = 0.05; // 5% withheld for state income tax
        double total_taxRate = social_security_tax + federal_tax + state_tax;
        double union_dues = 10.00; // $10.00 union dues per pay check
        double totalTax = grossPay * total_taxRate;
        double deductions = totalTax + union_dues;
        double less_then_3_dependents = 15; // $15 per pay check
        double more_then_3_dependents = 35; // $35 per pay check
        if (dependents < 3) {
            deductions += less_then_3_dependents;
        } else if (dependents >= 3) {
            deductions += more_then_3_dependents; // $35 per pay check
        }

        return deductions;
    }

    public static double calculateNetPay(double grossPay, double deductions) {
        return grossPay - deductions;
    }

}
