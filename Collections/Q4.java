package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee{
    String name;
    int age;
    String designation;
    int salary;
    public Employee(String name, int age, String designation){
        this.name = name;
        this.age = age;
        this.designation = designation;
    }
}
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Employee, Double> hs = new HashMap<>();
        for (int i = 0; i < 1; i++){
            System.out.println("Enter name, age, designation");
            Employee e = new Employee(sc.next(), sc.nextInt(), sc.next());
            System.out.println("Enter Salary");
            hs.put(e, sc.nextDouble());
        }
        for(Map.Entry<Employee, Double> entry: hs.entrySet()){
            System.out.println(entry.getKey().name + " and Salary is " + entry.getValue());
        }
    }
}
