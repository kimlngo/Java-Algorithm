package algo;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
//        var nums = new int[]{-1, 2, 1, -4};
        var nums = new int[]{-49, -30, -20, -4, 0, 7, 10, 21, 50};
        System.out.println(threeSumClosest_2(nums, 1));

    }

    private static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3)
            return nums[0] + nums[1] + nums[2];

        int minDiff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int a = 0; a < len - 2; a++) {
            for (int b = a + 1; b < len - 1; b++) {
                for (int c = b + 1; c < len; c++) {
                    int sum = nums[a] + nums[b] + nums[c];
                    int absDiff = Math.abs(sum - target);
                    if (absDiff < minDiff) {
                        minDiff = absDiff;
                        result = sum;
                    }
                }
            }
        }

        return result;
    }

    private static int threeSumClosest_2(int[] nums, int target) {
        int len = nums.length;

        if (len == 3)
            return nums[0] + nums[1] + nums[2];

        //sort first
        Arrays.sort(nums); //O(N log(N))

        int minDiff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < len - 2; i++) {
            int low = i + 1;
            int high = len - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
                if (sum < target)
                    low++;
                else
                    high--;
            }
        }
        return result;
    }
}
