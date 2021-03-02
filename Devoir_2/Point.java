package Devoir_2;

public class Point {

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Accesseurs
    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    // Modificateurs
    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    // Affichage
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}