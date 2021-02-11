package Devoir_1;

public class Coding {
    public static byte[][] code(byte[] data) {
        var ret = new byte[3][data.length];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(data, 0, ret[i], 0, data.length);
        }
        return ret;
    }

    public static byte[] decode(byte[][] data) {
        var ret = new byte[data[0].length];
        for (int i = 0; i < data[0].length; i++) {
            // The only case where it may not be data[0][i]
            // is when [1] and [2] are equal
            if (data[1][i] == data[2][i]) {
                ret[i] = data[1][i];
            } else {
                ret[i] = data[0][i];
            }
        }
        return ret;
    }
}
