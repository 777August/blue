package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Helper {
    public static void start() throws FileNotFoundException, TreeExceptions {
        database db = new database();
        create(db);
        display(db);
    }

    public static void create(database db) throws FileNotFoundException, TreeExceptions {
        File data = new File("D:\\idea\\project\\DSproject\\src\\project4\\data.txt");
        Scanner sc = new Scanner(data);
        classSection a;
        MyTreeNode<classSection> aa;
        while(sc.hasNextLine()){
            StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
            a = new classSection();
            a.setClassNumber(Integer.valueOf(st.nextToken()));
            a.setCourseSubject(st.nextToken());
            a.setCatalogNumber(Integer.valueOf(st.nextToken()));
            a.setClassTitle(st.nextToken());
            a.setLevel(st.nextToken());
            aa = new MyTreeNode<classSection>(a,null,null);
            db.insert(aa);
        }
    }

    public static void display(database db){

        LinkedList<MyTreeNode> list = db.sort();
        for(MyTreeNode mt:list){
            System.out.println(mt.getElement());
        }
    }

}
