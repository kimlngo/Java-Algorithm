package algo;

import java.util.ArrayList;
import java.util.List;

public class SubArrayMaxSum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] arr = {5, 4, -1, 7, 8};
        System.out.println(maxSumArray_Solution(arr));
    }

    private static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        List<List<Integer>> allSums = new ArrayList<>();
        for (int i = nums.length; i >= 1; i--) {
            allSums.add(subArraysSum(nums, i));
        }

        return
                allSums.stream()
                       .flatMap(List::stream)
                       .mapToInt(Integer::intValue)
                       .max()
                       .orElse(Integer.MAX_VALUE);
    }

    private static List<Integer> subArraysSum(int[] nums, int windowSize) {
        //assumption windowSize <= nums.length
        List<Integer> sums = new ArrayList<>();

        //initial sum
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }

        sums.add(sum);

        //sliding the windows
        for (int i = 1; i <= nums.length - windowSize; i++) {
            sum = sum - nums[i - 1] + nums[i + windowSize - 1];
            sums.add(sum);
        }

        return sums;
    }

    private static int maxSumArray_Solution(int[] nums) {
        int total = 0;
        int res = nums[0];

        for (int n : nums) {
            if(total < 0)
                total = 0;

            total += n;

            if(total > res)
                res = total;
        }

        return res;
    }
}
