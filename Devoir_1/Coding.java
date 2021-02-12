package Devoir_1;

public class Coding {
    public static byte[][] code(byte[] data) {
        var ret = new byte[3][data.length];
        for (int i = 0; i < 3; i++) {      //creates 2 aditional copies of the array
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
            } else {                     //Checks the arrays to see if the duplicated lists are corrupted
                ret[i] = data[0][i];    //If they are, it will return an anomaly that indicates it's corrupted
            }                          //
        }                             //
        return ret;                  //returns the array with any abnormalities
    }
}
