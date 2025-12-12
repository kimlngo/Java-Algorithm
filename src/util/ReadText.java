package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadText {

    public static String readLine(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        reader.close();

        return line;
    }

    /**
     * Convert [1, 2] into an array of {1, 2}
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static int[] read1DArray(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        reader.close();

        String[] numStr = line.substring(1, line.length() - 1)
                              .split(",");

        return Arrays.stream(numStr)
                     .mapToInt(Integer::parseInt)
                     .toArray();

    }

    /**
     * Convert [[1,2],[3,4]] to int[][]{{1, 2}, {3, 4}}
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static int[][] read2DArray(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        reader.close();

        var splits = line.substring(2, line.length() - 2)
                         .split("],\\[");
        int[][] result = new int[splits.length][];

        for (int i = 0; i < splits.length; i++) {
            String[] strArr = splits[i].split(",");
            result[i] = new int[]{Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])};
        }

        return result;
    }
}
