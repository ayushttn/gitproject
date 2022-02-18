package Collections;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Float> f = new ArrayList<Float>();
        for(int i = 0; i < 5; i++){
            Float input = sc.nextFloat();
            f.add(input);
        }
        Iterator<Float> n = f.iterator();
        double sum = 0.0;
        while (n.hasNext()){
            sum += n.next();
        }
        System.out.println(sum);
    }
}
