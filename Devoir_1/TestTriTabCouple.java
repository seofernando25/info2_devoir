package Devoir_1;

import java.util.Arrays;
                         //Test code for TriTabCouple
public class TestTriTabCouple {
    public static void main(String[] args) {
        // Not needed but usefull just to make sure
        Couple[] tableau = new Couple[] { new Couple(8, 4), new Couple(3, 3), new Couple(3, 2), new Couple(8, 5),
                new Couple() };
        System.out.println("Original");
        System.out.println(Arrays.toString(tableau));

        var tab = tableau.clone();
        TriTabCouple.insertSort(tab);
        System.out.println("Insert sort");
        System.out.println(Arrays.toString(tab));

        tab = tableau.clone();
        TriTabCouple.bubbleSort(tab);
        System.out.println("Bubble sort");
        System.out.println(Arrays.toString(tab));
    }
}
