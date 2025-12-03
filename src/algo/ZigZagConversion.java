package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        var sut = new ZigZagConversion();
        System.out.println(sut.convert("PAYPALISHIRING", 1));
        System.out.println(sut.convert("PAYPALISHIRING", 3));
        System.out.println(sut.convert("PAYPALISHIRING", 4));
    }

    private String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length())
            return s;
        List<List<Character>> result = new ArrayList<>();

        IntStream.range(0, numRows)
                 .forEach(i -> result.add(new ArrayList<>()));

        int len = s.length();
        int[] indexArr = new int[len];
        boolean isGoingUp = true;
        int i = 0, zIdx = 0;

        while (i < len) {
            int value = zIdx % len;
            indexArr[i] = value;

            if (isGoingUp) zIdx++;
            else zIdx--;

            if (zIdx == numRows) {
                zIdx -= 2;
                isGoingUp = false;
            }

            if (zIdx == -1) {
                zIdx += 2;
                isGoingUp = true;
            }
            //populate character too
            result.get(indexArr[i])
                  .add(s.charAt(i));

            i++;
        }

        return result.stream()
                     .flatMap(List::stream)
                     .map(Object::toString)
                     .collect(Collectors.joining());
    }
}
