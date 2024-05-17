package org.example;
import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Derya", "Akan"));
        employees.add(new Employee(1, "Burak", "Altiparmak"));
        employees.add(new Employee(2, "Dogancan", "Kinik"));
        employees.add(new Employee(3, "Emrah", "Kiziltan"));


        System.out.println(employees);

    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        List<Employee> duplicatedEmployees = new LinkedList<>();
        Map<Integer, Employee> employeesMap= new HashMap<>();

       Iterator<Employee> iterator = employees.iterator();
       while(iterator.hasNext()){
           Employee employee = iterator.next();
           if(employee == null){
               System.out.println("No employee found !");
               continue;
           }
           if(employeesMap.containsKey(employee.getId())){
               duplicatedEmployees.add(employee);
           }
           else {
               employeesMap.put(employee.getId(), employee);
           }
       }

       return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> uniqueEmployeesMap= new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("No employee found !");
                continue;
            }
            if(!uniqueEmployeesMap.containsKey(employee.getId())){
                uniqueEmployeesMap.put(employee.getId(), employee);
            }
        }
        return uniqueEmployeesMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUniques = new LinkedList<>(uniques.values());
        onlyUniques.removeAll(duplicates);
        return onlyUniques;
        }

    }
