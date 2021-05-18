package ua.com.finaly;

public class ShipClass {
    private int[][] ship;
    private int[][] aura;
    private boolean life;
    private int health;

    public ShipClass (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        this.ship = new int[][]{{x1, y1}, {x2, y2}, {x3, y3}, {x4, y4}};
        this.life = true;
        this.health = 4;
    }
}
