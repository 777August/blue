package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public static void start() throws FileNotFoundException {
        List<LinkedString> list = new ArrayList<LinkedString>();
        create(list);
        display(list);
        LinkedString ls = new LinkedString("abc");
        testMethods(ls);
    }

    public static void create(List<LinkedString> list) throws FileNotFoundException {
        File data = new File("D:\\idea\\project\\DSproject\\src\\project2\\data.txt");
        Scanner sc = new Scanner(data);
        while(sc.hasNextLine()){
            list.add(new LinkedString(sc.nextLine()));
        }
    }

    public static void display(List<LinkedString> list){
        for(LinkedString ls : list){
            ls.print();
            System.out.println();
        }
    }

    public static void testMethods(LinkedString ls){
        System.out.println(ls.isEmpty());
        System.out.println(ls.charAt(0));
        System.out.println(ls.length());
        ls.substring(0,1).print();
        System.out.println();
        LinkedString ls2 = new LinkedString("testConcat");
        LinkedString ls3 = ls.concat(ls2);
        ls3.print();
    }

}
