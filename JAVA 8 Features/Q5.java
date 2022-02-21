package JAVA_8;
interface myinterface{
    default void print(){
        System.out.println("Printing");
    }
}
class A implements myinterface{
    public void sayHi(){
        System.out.println("HI Everyone");
    }
}
class B implements myinterface{
    @Override
    public void print() {
        System.out.println("Printing in Class B");
    }
}
public class Q5 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.print();
        b.print();
    }
}
