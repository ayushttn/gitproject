package Ayush;
class info{
    static int age = 24;
    static{
        System.out.println("Ayush");
    }
    public static void lastname(){
        System.out.println("Tyagi");
    }
}

public class Details {
    public static void main(String[] args) {
        info.lastname();
        System.out.println("My age is " + info.age);
    }
}
