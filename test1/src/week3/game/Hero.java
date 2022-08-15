package week3.game;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

//我的飞机


public class Hero extends Plane{

    CopyOnWriteArrayList<Shoot> shoots = new CopyOnWriteArrayList<>();
    public Hero(int x, int y) {
        super(x, y);
    }

    //画出我的飞机
    public void paintHero(Graphics g){
        g.setColor(Color.cyan);
        g.fill3DRect(getX() -5, getY(),10,40,false);
        g.fill3DRect(getX() -20, getY() +20,7,25,false);
        g.fill3DRect(getX()+13,getY()+20,7,25,false);
        g.fill3DRect(getX()-27,getY()+33,8,5,false);
        g.fill3DRect(getX()+19,getY()+33,8,5,false);

        g.drawLine(getX()-18,getY()+33,getX(),getY()+24);
        g.drawLine(getX()-18,getY()+34,getX(),getY()+25);
        g.drawLine(getX()-18,getY()+35,getX(),getY()+26);
        g.drawLine(getX()-18,getY()+36,getX(),getY()+27);
        g.drawLine(getX()+18,getY()+33,getX(),getY()+24);
        g.drawLine(getX()+18,getY()+34,getX(),getY()+25);
        g.drawLine(getX()+18,getY()+35,getX(),getY()+26);
        g.drawLine(getX()+18,getY()+36,getX(),getY()+27);
    }

    public void shootEnemy(){
        Shoot s = new Shoot(getX(),getY(),true);
        shoots.add(s);
        new Thread(s).start();

    }
}
