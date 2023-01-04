package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
    public static void start() throws FileNotFoundException, StackException {
        ArrayList<Expression> expressions = new ArrayList<>();
        create(expressions);
        displayAndMore(expressions);
    }

    private static void create(ArrayList list) throws FileNotFoundException {
        File data = new File("D:\\idea\\project\\DSproject\\src\\project3\\data.txt");
        Scanner sc = new Scanner(data);
        while(sc.hasNextLine()){
            list.add(new Expression(sc.nextLine()));
        }
    }

    private static void displayAndMore(ArrayList<Expression> list) throws StackException {
        for(Expression e : list){
            System.out.println(e.getInfix());
            System.out.println(e.inToPost());
            System.out.println("the outcome is: " + e.evaluate());
            System.out.println();
        }
    }


}
