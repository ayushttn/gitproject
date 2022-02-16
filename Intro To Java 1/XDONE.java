package Ayush;

import java.util.Scanner;

public class XDONE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = "";
        String s ="";
        while (!x.equals("XDONE")){
            x = sc.next();
            if(x.equals("XDONE")){
            }
            else{
                s = s + " " + x;
            }
        }
        System.out.println(s);
    }
}
