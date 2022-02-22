package JAVA_8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Employee{
    String fullName;
    Long salary;
    String city;
    Employee(String fullName, Long salary, String city) {
        this.fullName = fullName;
        this.salary = salary;
        this.city = city;
    }
}
public class Q4 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(l1.stream().filter(e -> e%2 == 0).collect(Collectors.toList()));
        Employee emp = new Employee("Ayush Tyagi", 3000L, "Delhi");
        Employee emp2 = new Employee("Ayush Kumar", 5000L, "Bihar");
        Employee emp3 = new Employee("Mirnal Dhingra", 2000L, "Delhi");
        Employee emp4 = new Employee("Mirnal Arora", 300000L, "Faridabad");
        Employee emp5 = new Employee("Khushboo Chaudhary", 10000L, "UP");
        Employee emp6 = new Employee("Khushboo Rawat", 4000L, "UK");
        List<Employee> li = Arrays.asList(emp, emp2, emp3, emp4, emp5, emp6);
        System.out.println(li.stream()
                .filter(sal->sal.salary<5000)
                .filter(ci->ci.city.equals("Delhi"))
                .map(name->name.fullName.split(" ")[0]).distinct()
                .collect(Collectors.toList()));
    }
}
