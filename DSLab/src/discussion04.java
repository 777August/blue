import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class discussion04 {
    public static List<Integer> C = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(gcd(a,b) == 0){
            System.out.println("No such element");
        }else{
            int c = 1;
            int d = -C.get(C.size()-1);
            int temp = 0;
            for(int i = C.size()-2;i >= 0;i--){
                temp = c;
                c = d;
                d = temp - d*C.get(i);

            }
            System.out.println(d);
        }



    }

    public static int gcd(int a,int b){
        if(a < b){
            return gcd(b,a);
        }
        if(b == 1){
            return 1;
        }else if(b == 0){
            return 0;
        }
        C.add((a-a%b)/b);
        return gcd(b,a%b);
    }
}
