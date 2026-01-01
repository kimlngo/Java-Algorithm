package algo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 * <p>
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 * <p>
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * <p>
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^7 <= nums[i] <= 10^7
 * 0 <= k <= 10^7
 */

public class KDiffPairs {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    public static int findPairs(int[] nums, int k) {
        if (nums.length == 1)
            return 0;

        int count = 0;

        if (k == 0) {
            //problem falls back to count how many duplicates number in the nums
            //1) construct Map<Integer, Long> of frequency counter of number
            Map<Integer, Long> freqMap =
                    Arrays.stream(nums)
                          .boxed()
                          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            //2) those with frequency >= 2 -> count it as 1
            //3) return the count
            return (int) freqMap.entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() >= 2)
                                .count();

        } else {
            //with k != 0
            //1) remove duplicates and put all unique number in a Set<Integer>
            Set<Integer> intSet = Arrays.stream(nums)
                                        .distinct()
                                        .boxed()
                                        .collect(Collectors.toSet());

            //2) iterate through each number of the set
            //for each number n check if the (n + 2) and (n - 2) exist in the set
            //if so, increase the count and remove n
            for (var n : intSet) {
                int large = n + k;
                int small = n - k;

                if (intSet.contains(large))
                    count++;
                if (intSet.contains(small))
                    count++;
            }

            //3) return n / 2 because we are counting them twice: (a,b) and (b,a)
            return count / 2;
        }
    }
}
