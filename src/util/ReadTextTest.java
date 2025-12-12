package util;

import java.io.IOException;
import java.util.Arrays;

public class ReadTextTest {

    public static void main(String[] args) {
        try {
            int[] ints = ReadText.read1DArray("src/data/1dArray.txt");
            System.out.println(Arrays.toString(ints));

            int[][] twoDArr = ReadText.read2DArray("src/data/2dArray.txt");
            for(var arr : twoDArr) {
                System.out.printf(Arrays.toString(arr) + " ");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
