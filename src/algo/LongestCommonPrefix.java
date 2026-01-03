package algo;

import util.ReadText;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonPrefix {

    public static void main(String[] args) throws IOException {
        int[] arr1 = ReadText.read1DArray("src/data/Prefix1.txt");
        int[] arr2 = ReadText.read1DArray("src/data/Prefix2.txt");

        long start = System.currentTimeMillis();
        System.out.println(longestPrefixSolution(arr1, arr2));

        System.out.println("Execution time: " + (System.currentTimeMillis() - start));
    }

    private static int longestCommonPrefix(int[] arr1, int[] arr2) {
        //1) remove duplicates numbers in both arr1 and arr2
        //2) convert arr1 and arr2 to string
        List<String> list1 = convertIntArrToList(arr1);
        List<String> list2 = convertIntArrToList(arr2);

        //3) for each number m in arr1 and n in arr2, form a pair (m, n)
        //find the prefix
        //keep track of the longest prefix
        int longestPrefixLength = 0;

        for (String a : list1) {
            if (a.length() < longestPrefixLength)
                continue;
            for (String b : list2) {
                if (b.length() < longestPrefixLength)
                    continue;

                int prefixLen = findPrefixLength(a, b);
                if (prefixLen > longestPrefixLength) {
                    longestPrefixLength = prefixLen;
                    System.out.printf("a = %s, b = %s, len = %d\n", a, b, prefixLen);
                }
            }
        }

        //4) return the longest prefix length
        return longestPrefixLength;
    }

    private static List<String> convertIntArrToList(int[] arr) {
        return Arrays.stream(arr)
                     .distinct()
                     .boxed()
                     .map(String::valueOf)
                     .toList();
    }

    private static int findPrefixLength(String a, String b) {
        int length = 0;
        int minLength = Math.min(a.length(), b.length());

        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                length++;
            } else
                break;
        }

        return length;
    }

    private static int longestPrefixSolution(int[] arr1, int[] arr2) {
        Set<Integer> prefixSet = new HashSet<>();

        for(int a : arr1) {
            while(!prefixSet.contains(a) && a > 0) {
                prefixSet.add(a);
                a /= 10;
            }
        }

        int longestPrefix = 0;

        for(int b : arr2) {
            while(!prefixSet.contains(b) && b > 0) {
                b /= 10;
            }
            if(b > 0) {
                longestPrefix = Math.max(longestPrefix,
                        (int) Math.log10(b) + 1);
            }
        }
        return longestPrefix;
    }
}
