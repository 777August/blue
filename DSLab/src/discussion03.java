import java.util.Scanner;

public class discussion03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a decimal number");
        int n = sc.nextInt();
        System.out.println("enter one of 2,3,8,10or16");
        int b = sc.nextInt();
        int c = 0;
        int m = n;

        // find the biggest pow(b,?), for example, n = 17,b = 2, pow(2,4)in the biggest,so c = 4
        while(true){
            if(m/b>=1){
                c++;
                m/=b;
            }else{
                break;
            }
        }
        //print the answer
        for(int i = 0;i <= c;i++){
            System.out.print(n/(int)Math.pow(b,c-i)+" ");
            n = n%(int)Math.pow(b,c-i);
        }

    }
}
