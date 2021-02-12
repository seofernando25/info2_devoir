package Devoir_1;

public class TriTabCouple {

    public static void bubbleSort(Couple[] list) {
        for (int swaps = list.length - 1; swaps != 0; swaps--) {  //for loop that passes once for every couple
            for (int i = 0; i < swaps; i++) {
                var l = list[i];
                var r = list[i + 1];
                if (!l.compare(r)) {   //checks if the couple is bigger than the next
                    list[i] = r;      //if so, swap them
                    list[i + 1] = l;
                }
            }
        }
    }

    public static void insertSort(Couple[] list) {
        for (int i = 0; i < list.length; i++) { //for loop that passes once for every couple
            var cur = list[i];
            var prev = i - 1;
            while (prev >= 0 && cur.compare(list[prev])) {
                // Checks if all previous values are ordered
                list[prev + 1] = list[prev];//if not, moves them to the right
                prev -= 1;
            }
            list[prev + 1] = cur;  //places the value in it's ordered position
        }
    }

}
