package week3.game;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Enemy extends Plane implements Runnable{

    CopyOnWriteArrayList<Shoot> shoots = new CopyOnWriteArrayList<>();

    public Enemy(int x, int y) {
        super(x, y);
    }

    public void paintEnemy(Graphics g){
        g.setColor(Color.red);
        g.fill3DRect(getX() -5, getY(),10,40,false);
        g.fill3DRect(getX() -20, getY() -10,7,25,false);
        g.fill3DRect(getX()+13,getY()-10,7,25,false);
        g.fill3DRect(getX()-27,getY()-15,8,5,false);
        g.fill3DRect(getX()+19,getY()-15,8,5,false);

        g.drawLine(getX()-18,getY()-33,getX(),getY()+24);
        g.drawLine(getX()-18,getY()-34,getX(),getY()+25);
        g.drawLine(getX()-18,getY()-35,getX(),getY()+26);
        g.drawLine(getX()-18,getY()-36,getX(),getY()+27);
        g.drawLine(getX()+18,getY()-33,getX(),getY()+24);
        g.drawLine(getX()+18,getY()-34,getX(),getY()+25);
        g.drawLine(getX()+18,getY()-35,getX(),getY()+26);
        g.drawLine(getX()+18,getY()-36,getX(),getY()+27);
    }
    public void shootHero(){
        Shoot s = new Shoot(getX(),getY(),false);
        shoots.add(s);
        new Thread(s).start();
    }


    //启动线程后敌人飞机会自己跑，而且不会往上跑
    @Override
    public void run() {
        Random r = new Random();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int x = r.nextInt(3);
            switch (x){
                case 0:moveDown();break;
                case 1:moveLeft();moveLeft();break;
                case 2:moveRight();moveRight();break;
            }
            if(getX()<0){
                setIsAlive(false);
            }
            if(getX()<15){
                moveRight();
            }else if(getX()>400){
                moveLeft();
            }
        }
    }
}
