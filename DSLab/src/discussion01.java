import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class discussion01 {
    public static   String[] u = {"1","2","3","4","5","6","7","8","9","10"};
    public static void main(String[] args) {
        System.out.print("enter a set a: ");
        Scanner s = new Scanner(System.in);
        String a = s.next();
        String[] a1 = a.split(",");
        System.out.print("enter a set b: ");
        String b = s.next();
        String[] b1 = b.split(",");
        String[] aaa = complement(a1);
        String[] bbb = complement(b1);
        String[] ccc = union(a1,b1);
        String[] ddd = intersection(a1,b1);
        String[] eee = difference(a1,b1);
        String[] fff = difference(b1,a1);

        System.out.print("the complement of a is: ");
        print(aaa);
        System.out.print("the complement of b is: ");
        print(bbb);
        System.out.print("the  union of the sets A and B is: ");
        print(ccc);
        System.out.print("the intersection of sets A and B is: ");
        print(ddd);
        System.out.print("A - B is: ");
        print(eee);
        System.out.print("B - A is: ");
        print(fff);

    }

    //输出集合
    public static void print(String[] s){

        for(int i = 0;i < s.length - 1;i++){
            System.out.print(s[i]+",");
        }
        if(s.length == 0){

        }else{
            System.out.print(s[s.length-1]);
        }

        System.out.println();
    }

    //转化成0和1
    public static int[] bit(String[] sub){
        int[] a = new int[u.length];
        boolean flag = false;
        for(int i = 0;i <u.length;i++){
            for(int j = 0;j < sub.length;j++){
                if(u[i].equals(sub[j])){
                    flag = true;
                }
            }
            if(flag){
                a[i]=1;
            }
            flag = false;
        }
        return a;
    }

    //求某个集合的补集
    public static String[] complement(String[] a){
        int[] a1 = bit(a);
        List<String> ans = new ArrayList<>();
        boolean flag = false;
        for(int i = 0;i < u.length;i++){
            for(int j = 0;j < a.length;j++){
                if(u[i].equals(a[j])){
                    flag = true;
                }
            }
            if(!flag){
                ans.add(u[i]);
            }
            flag = false;
        }
        String[] s = new String[ans.size()];
        for(int i = 0;i < s.length;i++){
            s[i]= ans.get(i);
        }
        return s;
    }

    //求两个集合的并集
    public static String[] union(String[] a,String[] b){
        int[] a1 = bit(a);
        int[] b1 = bit(b);
        int[] c = new int[u.length];
        List<String> ans = new ArrayList<>();
        for(int i = 0;i < u.length;i++){
            if(a1[i]==1 || b1[i] ==1){
                c[i] = 1;
            }else{
                c[i] = 0;
            }
        }
        for(int i = 0;i < u.length;i++){
            if(c[i] == 1){
                ans.add(u[i]);
            }
        }
        String[] s = new String[ans.size()];
        for(int i = 0;i < s.length;i++){
            s[i]= ans.get(i);
        }
        return s;
    }

    //求两个集合的交集
    public static String[] intersection(String[] a,String[] b){
        int[] a1 = bit(a);
        int[] b1 = bit(b);
        int[] c = new int[u.length];
        List<String> ans = new ArrayList<>();
        for(int i = 0;i < u.length;i++){
            if(a1[i]==1 && b1[i] ==1){
                c[i] = 1;
            }else{
                c[i] = 0;
            }
        }
        for(int i = 0;i < u.length;i++){
            if(c[i] == 1){
                ans.add(u[i]);
            }
        }
        String[] s = new String[ans.size()];

        for(int i = 0;i < s.length;i++){
            s[i]= ans.get(i);
        }
        return s;
    }

    //求两个集合的差集
    public static String[] difference(String[] a,String[] b){
        int[] a1 = bit(a);
        int[] b1 = bit(b);
        int[] c = new int[u.length];
        List<String> ans = new ArrayList<>();
        for(int i = 0;i < u.length;i++){
            if(a1[i]==1 && b1[i] ==0){
                c[i] = 1;
            }else{
                c[i] = 0;
            }
        }
        for(int i = 0;i < u.length;i++){
            if(c[i] == 1){
                ans.add(u[i]);
            }
        }
        String[] s = new String[ans.size()];
        for(int i = 0;i < s.length;i++){
            s[i]= ans.get(i);
        }
        return s;
    }
}
