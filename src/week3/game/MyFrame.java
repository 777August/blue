package week3.game;

import javax.swing.*;


//程序入口
//wasd移动，j射击
//没想到怎么在控制台输出，所以用一下好像已经淘汰的东西
public class MyFrame extends JFrame {
    MyPanel mp = null;

    public MyFrame(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
        new Thread(mp).start();
    }

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();

    }
}
