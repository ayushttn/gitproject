package Ayush;

import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row size");
        int r = sc.nextInt();
        System.out.println("Enter column size");
        int c = sc.nextInt();
        int [][] arr = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i < r; i++){
            int sumofrow=0;
            for (int j = 0; j < c; j++){
                sumofrow += arr[i][j];
            }
            System.out.println("Sum of" +(i+1)+ "row"+sumofrow);
        }
        for (int i = 0; i < c; i++){
            int sumofcol=0;
            for (int j = 0; j < r; j++){
                sumofcol += arr[j][i];
            }
            System.out.println("Sum of" +(i+1)+ "columns"+sumofcol);
        }
    }
}
