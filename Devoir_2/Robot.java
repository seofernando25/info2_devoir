package Devoir_2;
import java.awt.Point;


public class Robot {
    String name;
    Point location;
    public Robot(String n, int xpos, int ypos){ //Constructor with inputs
        this.name = n;
        this.location = new Point(xpos,ypos);
    }
    public Robot(){              //empty constructor
        this.name = "robot";
        this.location = new Point();
    }

    public void changeName(String n){
        this.name = n;
    }

    public void display(){                        //function prints out the name and the coordinates of the robot
     System.out.println("Robot : "+this.name);   
     System.out.println("Location : ("+this.location.getX()+", "+this.location.getY() +")");  
    }

    public void moveTo(int x, int y){   //sets the location to be equal to the current location, plus the entered coordinates
     this.location.setLocation((this.location.getX())+ x,this.location.getY() + y);   
    }

    public void distance(Robot r){
        double diffX = (this.location.getX())  - r.location.getX();  //gets the difference in y and x
        double diffY = (this.location.getY()) - r.location.getY();
        double dist = Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY,2));  //applies pythagoreses theorem
        System.out.println("distance between "+this.name+" and "+r.name+" : "+dist);
    }

    public static void main(String[] args){
        Robot r = new Robot("Romador",6,9);
        Robot r2 = new Robot();
        r2.changeName("Rodrigo");
        r2.moveTo(2, 4);
        r.moveTo(2,11);
        r.display();
        r2.display();
        r.distance(r2);
    }
}
