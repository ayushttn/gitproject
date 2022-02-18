package Collections;

import java.util.HashMap;

class Employee{
    String name;
    int age;
    String designation;
    int salary;
    public Employee(String name, int age, String designation,int salary){
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }
}
public class Q4 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ayush", 23, "JVM", 30000);
        Employee e2 = new Employee("Piyush", 23, "JVM", 40000);
        Employee e3 = new Employee("Ram", 23, "JVM", 50000);
        HashMap<String, Integer> hs = new HashMap<>();
        hs.put(e1.name, e1.salary);
        hs.put(e2.name, e2.salary);
        hs.put(e3.name, e3.salary);
        System.out.println(hs);
    }
}
