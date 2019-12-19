package textadventureapp;

public class Room {

    private int x;
    private int y;
    private boolean hasMonsters = false;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean hasMonsters() {

        return hasMonsters;
    }

    public void spawnMonster() {
        hasMonsters = true;

    }

    public void killMonsters() {
        hasMonsters = false;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
