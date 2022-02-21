package JAVA_8;
interface myInterface{
    int Ope(int a, int b);
}
public class Q2{
    public int add(int a, int b){
        System.out.println("Addition of the given numbers:");
        return a+b;
    }
    public int sub(int a, int b){
        System.out.println("Subtraction of a from b:");
        return b-a;
    }
    public static int multiply(int a, int b){
        System.out.println("Product of the given numbers:");
        return a*b;
    }

    public static void main(String[] args) {
        myInterface m1 = new Q2()::add;
        System.out.println(m1.Ope(4,5));
        myInterface m2 = new Q2()::sub;
        System.out.println(m2.Ope(3,5));
        myInterface m3 = Q2::multiply;
        System.out.println(m3.Ope(3,2));
    }
}
