package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class helper {
    public static void start() throws FileNotFoundException, itemNotFoundException, indexOutOfBoundException {
        ADTBag test = new ADTBag();
        create(test);
        test.insert(1);

        //test insert
        System.out.println("test insert");
        String  t = "hhh";
        test.insert(t);
        test.insert(6);
        display(test);
        System.out.println();

        //test removeLast
        System.out.println("test removeLast");
        test.removeLast();
        display(test);
        System.out.println();

        //test get(Object item)
        System.out.println("test get(Object item)");
        System.out.println(test.get("Apple"));

        //test get(int index)
        System.out.println("test get(int index)");
        System.out.println(test.get(1));

        //test size
        System.out.println("test size");
        System.out.println(test.size());

        //test isEmpty
        System.out.println("test isEmpty");
        System.out.println(test.isEmpty());

        //test removeRandom
        System.out.println("test removeRandom");
        test.removeRandom();
        display(test);
        System.out.println();

        //test makeEmpty
        System.out.println("test makeEmpty");
        test.makeEmpty();
        display(test);
    }
    public static void create(ADTBag bag) throws FileNotFoundException {
        File data = new File("D:\\idea\\project\\DSproject\\src\\project1\\data.txt");
        Scanner sc = new Scanner(data);
        while(sc.hasNextLine()){
            bag.insert(sc.nextLine());
        }
    }

    public static void display(ADTBag bag){
        Object[] items = bag.getBag();
        for(int i = 0;i < items.length;i++){
            if(items[i] != null){
                System.out.println(items[i].toString());
            }

        }
    }
}
