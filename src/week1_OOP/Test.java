package week1_OOP;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BookLost b1 = new BookLost(20220711,"8211","八教1楼失物招领处","活着","余华");
        BookLost b2 = new BookLost(20220710,"图书馆3楼","图书馆1楼失物招领处","兄弟","余华");
        BookLost b3 = new BookLost(20220712,"莘莘食堂","莘莘食堂失物招领处","斗罗大陆","唐家三少");
        CardLost c1 = new CardLost(20220711,"5401","五教1楼失物招领处","李博伦",2021215023,2021,"国际学院");
        CardLost c2 = new CardLost(20220713,"莘莘食堂","莘莘食堂失物招领处","小王",2020214732,2020,"理学院");

        Lost[] l = {b1,b2,b3,c1,c2};

        Solution a = new Solution();
        a.sortLost(l);

        //获取关键词
        System.out.print("请输入关键词（领取地点）:");
        Scanner sc = new Scanner(System.in);
        String keyWord = sc.next();
        Lost[] h = a.selectByKeyword(l,keyWord);

        System.out.println("可能的结果:");
        for(Lost i : h){
            System.out.println(i);
            System.out.println();
        }
    }
}
