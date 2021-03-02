package Devoir_2;


public class Robot {
    private String name;
    private Point location;

    public Robot(String n, int xpos, int ypos) { // Constructor with inputs
        this.name = n;

        this.location = new Point(xpos, ypos);
    }

    public void display() { // function prints out the name and the coordinates of the robot
        System.out.println("Robot : " + this.name);
        System.out.println("Location : " + this.location.toString());
    }

    public void moveTo(int x, int y) { // sets the location to be equal to the current location, plus the entered
                                       // coordinates
        location.setX(location.getX() + Double.valueOf(x));
        location.setY(location.getY() + Double.valueOf(y));
        System.out.println("moved to : " + this.location.toString());
    }

    public double distance(Robot r) {
        double diffX = (this.location.getX()) - r.location.getX(); // gets the difference in y and x
        double diffY = (this.location.getY()) - r.location.getY();
        double dist = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2)); // applies pythagoreses theorem
        return dist;
    }

    public static void main(String[] args) {
        Robot r = new Robot("Romador", 6, 9);
        Robot r2 = new Robot("Rodrigo", 2, 5);

        r2.moveTo(2, 4);
        r.moveTo(2, 11);
        r.display();
        r2.display();
        
        System.out.println("Distance entre les deux robots: " + r.distance(r2));
    }
}
