package Devoir_2;

public class Point {

    private int x;
    private int y;

    Point(double x, double y) {
        this.x = (int)x;
        this.y = (int) y;
    }

    // Accesseurs
    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    // Modificateurs
    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    // Affichage
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}