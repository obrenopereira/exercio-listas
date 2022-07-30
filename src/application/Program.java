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
            System.out.println("Employee #" + (i +1 ) + ":");
            read.nextLine();
            System.out.print("Id: ");
            int id = read.nextInt();
            while (hasId(listEmployees, id)){
                System.out.println("Id already taken! Try again:");
                id = read.nextInt();
            }


            read.nextLine();
            System.out.print("Name: ");
            String name = read.nextLine();
            System.out.print("Salary: ");
            double salary = read.nextDouble();

            Employee emp = new Employee(id, name, salary);
            listEmployees.add(emp);
        }

        System.out.println();
        System.out.println("Enter the employee id that will have salary increase : ");
        int idSalary = read.nextInt();
        Integer pos = position (listEmployees, idSalary);

        if(pos == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.print("Enter the percentage: ");
            double percentage = read.nextDouble();
            listEmployees.get(pos).increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees: ");
        for ( Employee emp: listEmployees) {
            System.out.println(emp);
        }
    }
    static Integer position(List<Employee> listEmployees, int id){
        for (int i = 0; i < listEmployees.size(); i++){
            if(listEmployees.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;

    }


}
