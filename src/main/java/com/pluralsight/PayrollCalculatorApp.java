package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculatorApp {
    public static void main(String[] args) {
        String fileName = "payroll.csv";

        try {
            // buffer to read doc
            BufferedReader reader = new BufferedReader(new FileReader("payroll.csv"));

            String data;
            System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Gross Pay");
            System.out.println("____________________________________________\n");

            while ((data = reader.readLine()) != null) {
//                System.out.println(data);

                // regex to split employee data by ' | '
                String[] empdata = data.split("\\|");

                int employeeId = Integer.parseInt(empdata[0]);
                String name = empdata[1];
                double hoursWorked = Double.parseDouble(empdata[2]);
                double payRate = Double.parseDouble(empdata[3]);

                // generate employee object
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate );
//                System.out.println(employee);

                System.out.printf("%-10d %-20s $%.2f%n", employee.getEmployeeId(),
                        employee.getName(), employee.getGrossPay());
            }
            reader.close();
        //catch io
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
