package Collections;
import java.util.*;
class Emp{
    double age;
    double salary;
    String Name;
    public Emp(double age, double salary, String Name){
        this.age=age;
        this.salary=salary;
        this.Name=Name;
    }
}
//class NameComparator implements Comparator{
//    public int compare(Object o1, Object o2){
//        Emp e1 = (Emp)o1;
//        Emp e2 = (Emp) o2;
//        return e1.Name.compareTo(e2.Name);
//    }
//}
class SalaryComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Emp e1 = (Emp)o1;
        Emp e2 = (Emp)o2;
        if(e1.salary == e2.salary){
            return 0;
        }
        else if(e1.salary>e2.salary){
            return 1;
        }
        else {
            return -1;
        }
    }
}
public class Q2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
//        al.add(new Emp(29,60000,"Ayush Sharma"));
//        al.add(new Emp(23,40000,"Ayush Tyagi"));
//        al.add(new Emp(25,20000,"Ram Verma"));

        Emp e2 = new Emp(29,60000,"Ayush Sharma");
        Emp e1 = new Emp(23,40000,"Ayush Tyagi");
        Emp e3 = new Emp(25,20000,"Ram Verma");
        al.add(e1);
        al.add(e2);
        al.add(e3);

        //Default Sorting Method
        System.out.println("Sorting by name");
        Set<String> treeset = new TreeSet<>();
        treeset.add(e1.Name);
        treeset.add(e2.Name);
        treeset.add(e3.Name);

        for (String element: treeset){
            System.out.println(element);
        }
        //Using Comparator Method
//        Collections.sort(al, new NameComparator());
//        Iterator itr = al.iterator();
//        while (itr.hasNext()){
//            Emp e =(Emp)itr.next();
//            System.out.println(e.age + " " + e.Name + " " + e.salary);
//        }
        System.out.println("Sorting by Salary");
        Collections.sort(al, new SalaryComparator());
        Iterator itr2 = al.iterator();
        while (itr2.hasNext()){
            Emp e =(Emp)itr2.next();
            System.out.println(e.age + " " + e.Name + " " + e.salary);
        }
    }
}
