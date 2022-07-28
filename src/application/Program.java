package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("How many employees will be registered? ");
        int numberEmployee = read.nextInt();

        Employee employee;
        List<Employee> listEmployees = new ArrayList<>();

        for (int i = 1; i <= numberEmployee; i++){
            System.out.println("Employee #" + i + ":");
            read.nextLine();
            System.out.print("Id: ");
            int id = read.nextInt();

            read.nextLine();
            System.out.print("Name: ");
            String name = read.nextLine();
            System.out.print("Salary: ");
            double salary = read.nextDouble();

            listEmployees.add(new Employee(id, name, salary));
        }
        for (int i = 1; i <= numberEmployee; i++){

            System.out.println();
        }





    }


}
