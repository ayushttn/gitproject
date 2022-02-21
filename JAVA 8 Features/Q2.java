package JAVA_8;
interface myInterface{
    int Ope(int a, int b);
}
public class Q2{
    public int add(int a, int b){
        System.out.println("Addition of the given numbers:");
        return a+b;
    }
    public static int multiply(int a, int b){
        System.out.println("Product of the given numbers:");
        return a*b;
    }

    public static void main(String[] args) {
        myInterface m1 = new Q2()::add;
        System.out.println(m1.Ope(4,5));
        myInterface m2 = Q2::multiply;
        System.out.println(m2.Ope(3,2));
    }
}
