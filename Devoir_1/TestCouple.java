package Devoir_1;

public class TestCouple {    
                         //Test code for Couple
    public static void main(String[] args) {
        var c1 = new Couple(2, 3);
        var c2 = new Couple();
        var c3 = new Couple(c1);

        c1.display();
        c2.display();
        c3.display();
        c3.setP(8);
        System.out.println("Après modification, les éléments de c3 sont: " + c3.getP() + " " + c3.getQ());
        System.out.println("c1 est inferieur a c3: " + c1.compare(c3));
    }
}
