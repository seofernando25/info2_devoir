package Devoir_1;

public class TriTabCouple {

    public static void bubbleSort(Couple[] list) {
        for (int swaps = list.length - 1; swaps != 0; swaps--) {
            for (int i = 0; i < swaps; i++) {
                var l = list[i];
                var r = list[i + 1];
                if (!l.compare(r)) {
                    list[i] = r;
                    list[i + 1] = l;
                }
            }
        }
    }

    public static void insertSort(Couple[] list) {
        for (int i = 0; i < list.length; i++) {
            var cur = list[i];
            var prev = i - 1;
            while (prev >= 0 && cur.compare(list[prev])) {
                // Checks if all previous values are ordered
                list[prev + 1] = list[prev];
                prev -= 1;
            }
            list[prev + 1] = cur;
        }
    }

}
