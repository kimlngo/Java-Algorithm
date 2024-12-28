package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GeekForGeekTest {

    /**
     * https://www.geeksforgeeks.org/find-the-missing-number/
     */
    @Test
    public void testFindingMissingNumber() {
        Assertions.assertEquals(5, findMissingNumber(new int[]{1, 2, 4, 6, 3, 7, 8}, 8));
        Assertions.assertEquals(4, findMissingNumber(new int[]{1, 2, 3, 5}, 5));
    }

    @Test
    public void testFindingAllMissingNumbers() {
        int[] results = findingAllMissingNumbers(new int[]{1, 2, 6, 3, 7}, 8);
        System.out.println(Arrays.toString(results));
        Assertions.assertEquals(3, results.length);
    }

    private int findMissingNumber(int[] inputArr, int n) {
        int totalSum = ((n + 1) * n) / 2;

        int subSum = 0;
        for (int k : inputArr) {
            subSum += k;
        }

        return totalSum - subSum;
    }

    private int[] findingAllMissingNumbers(int[] input, int n) {
        Set<Integer> intSet = new HashSet<>();

        IntStream.range(1, n + 1)
                 .forEach(intSet::add);

        for (int i : input) {
            intSet.remove(i);
        }

        return intSet.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    /**
     * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
     */
    @Test
    public void testFindEquilibriumIndex() {
        int[] arr = {1, 2, 3, 3};

        System.out.println(findEquilibriumIndex(arr));
    }

    private int findEquilibriumIndex(int[] input) {
        if (input.length <= 2) return -1;

        //length >= 3
        int mid = input.length / 2;
        boolean shiftLeft = false, shiftRight = false;

        while (mid > 0 && mid < input.length - 1) {
            long leftSum = Arrays.stream(input, 0, mid)
                                 .sum();

            long rightSum = Arrays.stream(input, mid + 1, input.length)
                                  .sum();

            if (leftSum == rightSum) return mid + 1;
            else if (leftSum > rightSum && !shiftRight) {
                mid--;
                shiftLeft = true;
            } else if (leftSum < rightSum && !shiftLeft) {
                mid++;
                shiftRight = true;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
