package Ayush;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pi = 3.14;
        System.out.println("Select any One \n 1.Area \n 2.Circumference \n 3.Exit");
        int opt = sc.nextInt();
        System.out.println("Enter Radius");
        int r = sc.nextInt();
        menu(pi, opt, r);
        }

    public static void menu(double pi, int opt, int r) {
        switch (opt) {
            case 1:
                System.out.println(area(pi, r));
                break;
            case 2:
                System.out.println(circumference(pi, r));;
                break;
            case 3:
                System.out.println("Exiting");
                return;
            default:
                return;
        }
    }
    public static double area(double pi, int r){
        double area = pi * r * r;
        return area;
    }
    public static double circumference(double pi, int r){
        double circumference = 2 * pi * r;
        return circumference;
    }
}

