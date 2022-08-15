package week3.game;


//飞机类


public class Plane {
    private int x;
    private int y;
    private boolean isAlive;

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
        setIsAlive(true);
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

    public void moveUp(){ this.setY(this.getY()-2); }

    public void moveDown(){
        this.setY(this.getY()+2);
    }

    public void moveLeft(){
        this.setX(this.getX()-2);
    }

    public void moveRight(){
        this.setX(this.getX()+2);
    }
}
