package week3.game;

import java.awt.*;

//射击类，敌人，英雄都可以射击

public class Shoot implements Runnable{
    private int x;
    private int y;
    private boolean dir;//方向，true向上，false向下
    private boolean isAlive;

    public Shoot(int x, int y, boolean dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        isAlive = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public void paintShoot(Graphics g){
        if(isAlive) {
            g.setColor(Color.white);
            g.fill3DRect(x, y, 2, 2, false);
        }
    }

    //线程启动子弹会自己跑，我的子弹跑的比敌人快
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(dir){
                y -= 6;
            }else {
                y += 3;
            }
            if(y < 0 || y > 600){
                isAlive = false;
                break;
            }
        }
    }
}
