package Devoir_1;

import java.util.Arrays;

public class TestCoding {
    public static void main(String[] args) {
        byte[] array = { 1, 2 , 3, 4 };
        byte[][] buffer = Coding.code(array);
        buffer[0][0] = 70;
        buffer[2][0] = 70;
        buffer[1][2] = 35;
        buffer[2][2] = 35;
        buffer[1][3] = 69;
        buffer[0][3] = 69;
        var decoded = Coding.decode(buffer);
        System.out.println((Arrays.deepToString(buffer)));
        System.out.println(Arrays.toString(decoded));
    }
}