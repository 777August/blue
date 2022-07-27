package week3.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero myPlane = null;
    CopyOnWriteArrayList<Enemy> enemies = new CopyOnWriteArrayList<>();
    int count = 0;
    Random r = new Random();


    public MyPanel() {
        myPlane = new Hero(200, 500);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 400, 600);

        //游戏结束
        if(!myPlane.getIsAlive()){
            g.setColor(Color.yellow);
            g.setFont(new Font("楷书",Font.BOLD,50));
            g.drawString("游戏结束",70,300);
        }
        //画自己的飞机
        if(myPlane.getIsAlive()) {
            myPlane.paintHero(g);
        }

        //画自己的子弹
        if (!myPlane.shoots.isEmpty() && myPlane.getIsAlive()) {
            for (int i = 0; i < myPlane.shoots.size(); i++) {
                if (myPlane.shoots.get(i).getIsAlive()) {
                    myPlane.shoots.get(i).paintShoot(g);
                } else {
                    myPlane.shoots.remove(i);
                }
            }
        }

        //画敌人的飞机
        if (!enemies.isEmpty()) {
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.getIsAlive()) {
                    enemy.paintEnemy(g);
                } else {
                    enemies.remove(enemy);
                }
            }
        }

        //画敌人的子弹
        if (!enemies.isEmpty()) {
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (!enemy.shoots.isEmpty() ) {
                    for (int j = 0; j < enemy.shoots.size(); j++) {
                        Shoot shoot = enemy.shoots.get(j);
                        if (shoot.getIsAlive()) {
                            shoot.paintShoot(g);
                        } else {
                            enemy.shoots.remove(j);
                        }
                    }
                }
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //移动和射击，移动有边界
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            if (myPlane.getY() > 0) {
                myPlane.moveUp();
                myPlane.moveUp();
                myPlane.moveUp();
            }
        } else if (e.getKeyChar() == 's') {
            if (myPlane.getY() < 570) {
                myPlane.moveDown();
                myPlane.moveDown();
                myPlane.moveDown();
            }

        } else if (e.getKeyChar() == 'a') {
            if(myPlane.getX()>0) {
                myPlane.moveLeft();
                myPlane.moveLeft();
                myPlane.moveLeft();
            }
        } else if (e.getKeyChar() == 'd') {
            if(myPlane.getX()<380) {
                myPlane.moveRight();
                myPlane.moveRight();
                myPlane.moveRight();
            }
        }

        if (e.getKeyChar() == 'j') {
            myPlane.shootEnemy();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {


        while (myPlane.getIsAlive()) {
            count++;
            if (count == Integer.MAX_VALUE) {
                count = 0;
            }
            this.repaint();

            //自动生成敌人
            if ((count % 40000000 == 0 || count == 1)&&myPlane.getIsAlive()) {
                Enemy e = new Enemy(r.nextInt(400) - 50, 30);
                new Thread(e).start();
                enemies.add(e);
            }

            //自动射击
            if (!enemies.isEmpty()) {
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    if (count % 6000000 == 0 && enemy.getIsAlive()) {
                        enemy.shootHero();
                    }
                }

            }

            //敌人子弹打中我
            if(!enemies.isEmpty()){
                for(int i = 0;i < enemies.size();i++){
                    Enemy enemy = enemies.get(i);
                    if(!enemy.shoots.isEmpty()){
                        for(int j = 0;j < enemy.shoots.size()-1;j++) {
                            Shoot shoot = enemy.shoots.get(j);
                            if(shoot.getX()>myPlane.getX()-20 &&shoot.getX()<myPlane.getX()+20&&
                                shoot.getY()>myPlane.getY()+10&&shoot.getY()<myPlane.getY()+30){
                                shoot.setIsAlive(false);
                                myPlane.setIsAlive(false);
                                enemies.clear();
                            }
                        }
                    }
                }
            }

            //我的子弹打中敌人
            if(!myPlane.shoots.isEmpty() && !enemies.isEmpty()){
                for(int i = 0;i < myPlane.shoots.size()-1;i++){
                    Shoot shoot = myPlane.shoots.get(i);
                    for(int j = 0;j < enemies.size();j++){
                        Enemy enemy = enemies.get(j);
                        if(shoot.getX()> enemy.getX()-20&& shoot.getX()<enemy.getX()+20&&
                            shoot.getY()>enemy.getY()-10&& shoot.getY()<enemy.getY()+10){
                            shoot.setIsAlive(false);
                            enemies.remove(enemy);

                        }
                    }
                }
            }

            //两机相撞
            if(!enemies.isEmpty()){
                for(Enemy e : enemies){
                    if(e.getX()+30<myPlane.getX()&&e.getX()+30>myPlane.getX()&&
                        e.getY()-35>myPlane.getY()&&e.getY()<myPlane.getY()+30){
                        myPlane.setIsAlive(false);
                        enemies.clear();
                        break;
                    }
                }
            }
        }
    }
}
