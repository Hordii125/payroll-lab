package org.example;

import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        System.out.println("                Welcome to the Payroll Calculator!");

        System.out.println("--------------------------------------------------");

        System.out.println("Please enter the number of Dependents: ");
        Scanner scanner = new Scanner(System.in);
        int dependents = scanner.nextInt();

        System.out.println("Please enter the number of Hours Worked: ");
        int hoursWorked = scanner.nextInt();

        System.out.println("--------------------------------------------------");

        System.out.println("You entered " + dependents + " dependents and " + hoursWorked + " hours worked.");

        scanner.close();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Calculating your pay...");

        double grossPay = PayrollCalculator.calculateGrossPay(hoursWorked);
        double deductions = PayrollCalculator.calculateDeductions(grossPay, dependents);
        double netPay = PayrollCalculator.calculateNetPay(grossPay, deductions);

        System.out.println("--------------------------------------------------");
        System.out.printf("Your gross Pay: $%.2f%n", grossPay);
        System.out.printf("Your deductions: $%.2f%n", deductions);
        System.out.printf("Your net Pay: $%.2f%n", netPay);
        System.out.println("--------------------------------------------------");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------");

        System.out.println("Thank you for using the Payroll Calculator!");
        System.out.println("Have a great day!");

    }
}   
