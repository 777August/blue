package week2;

import java.util.Scanner;

public class NumberBreak {
    //任何一个大于 1 的自然数 n，总可以拆分成若干个小于 n 的自然数之和。现在给你一个自然数 n，
    // 要求你求出 n 的拆分成一些数字的和。每个拆分后的序列中的数字从小到大排序。
    // 然后你需要输出这些序列，其中字典序小的序列需要优先输出。
    //1 <=  n <= 8

//基本上照着答案写的，理解起来非常吃力......
//理解了这种方法的思路，但是自己写不出来，用代码不会实现
    static int[] a = {1,0,0,0,0,0,0,0,0};
    static int n,m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = n;
        dfs(1);
    }

    public static void dfs(int b){
        for(int i = a[b-1];i<= m;i++){
            if(i == n) continue;
            a[b] = i;
            m -= i;
            if(m == 0)print(b);
            else dfs(b + 1);
            m += i;
        }
    }

    public static void print(int c){
        for(int i = 1;i < c;i++){
            System.out.print(a[i] + "+");
        }
        System.out.print(a[c]);
        System.out.println();
    }
}
