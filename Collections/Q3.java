package Collections;
import java.io.*;
import java.util.*;
public class Q3{
    public static class SpecialStack{
        int[] data;
        int tos;
        Stack<Integer> minim = new Stack<>();

        public SpecialStack(int cap){
            data = new int[cap];
            tos = -1;
            minim.push(Integer.MAX_VALUE);
        }
        void push(int value){
            if(tos == data.length - 1){
                System.out.println("Stack Overflow");
            }
            else{
                tos++;
                data[tos] = value;
                if(value < minim.peek()){
                    minim.push(value);
                }
            }
        }
        int pop(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int value = data[tos];
                tos--;
                if(value == minim.peek()){
                    minim.pop();
                }
                return value;
            }
        }
        boolean isEmpty(){
            if(tos == -1){
                return true;
            }
            else {
                return false;
            }
        }
        boolean isFull(){
            if(tos == data.length - 1){
                return true;
            }
            else {
                return false;
            }
        }
        int getMin(){
            int min = minim.peek();
            return min;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SpecialStack st = new SpecialStack(n);
        String str =  br.readLine();
        while (str.equals("quit") == false){
            if (str.startsWith("push")) {
                int value = Integer.parseInt(str.split(" ")[1]);
                st.push(value);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if(str.startsWith("isEmpty")){
                if(st.isEmpty()){
                    System.out.println("Stack is Empty");
                }
                else {
                    System.out.println("Stack is not Empty");
                }
            }
            else if(str.startsWith("isFull")){
                if(st.isFull()){
                    System.out.println("Stack is full");
                }
                else {
                    System.out.println("Stack is not full");
                }
            }
            else if(str.startsWith("getMin")){
                System.out.println(st.getMin());
            }
            str = br.readLine();
        }


    }
}