package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 * <p>
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 * <p>
 * Example 1:
 * Input: n = 4
 * Output: "1211"
 * <p>
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: "1"
 * Explanation:
 * This is the base case.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 */
public class CountAndSay {

    public static void main(String[] args) {
        var sut = new CountAndSay();

        IntStream.range(1, 6)
                 .forEach(i -> System.out.println(sut.countAndSay_Iterative(i)));
    }

    private String countAndSay_Iterative(int n) {
        if(n == 1)
            return "1";

        String result = "1";
        for(int i = 2; i <= n; i++) {
            result = runLengthEncoding(result);
        }

        return result;
    }

    private String countAndSay_Recursive(int n) {
        if (n == 1)
            return "1";

        return runLengthEncoding(countAndSay_Recursive(n - 1));
    }

    private String runLengthEncoding(String num) {
        //split the string of numbers into List<List<Integer>>
        List<List<Integer>> frequencyCount = new ArrayList<>();
        List<Integer> groupList = new ArrayList<>();
        char cur = num.charAt(0);
        groupList.add(cur - '0');

        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);

            if (c != cur) {
                frequencyCount.add(groupList);
                groupList = new ArrayList<>();
                cur = c;
            }

            groupList.add(c - '0');
        }
        //add final group
        frequencyCount.add(groupList);
        //process each inner list with its count to produce the RLE
        StringBuilder sb = new StringBuilder();

        for (var list : frequencyCount) {
            sb.append(list.size());
            sb.append(list.getFirst());
        }

        return sb.toString();
    }
}
