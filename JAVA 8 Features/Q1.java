package JAVA_8;

import java.util.Locale;
@FunctionalInterface
interface GreaterCheck{
    public boolean check(int a, int b);
}
@FunctionalInterface
interface Incre{
    public int inc(int a);
}
@FunctionalInterface
interface addStrings{
    public String add(String s1, String s2);
}
@FunctionalInterface
interface convertString{
    public String convert(String s);
}
public class Q1 {
    public static void main(String[] args) {
        GreaterCheck checking = (a,b) -> a>b;
        System.out.println(checking.check(3,4));
        Incre increase = (a) -> ++a;
        System.out.println(increase.inc(4));
        addStrings adding = (s1, s2) -> s1+s2;
        System.out.println(adding.add("HI", " My Name is Ayush"));
        convertString converting = (s) -> s.toUpperCase(Locale.ROOT);
        System.out.println(converting.convert("hi my name is ayush"));
    }
}
