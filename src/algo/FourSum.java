package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class FourSum {
    public static void main(String[] args) {
        FourSum sut = new FourSum();
        long start = System.currentTimeMillis();
        System.out.println(sut.fourSum(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 8));

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
    }

    private List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;

        if (len < 4) {
            return new ArrayList<>();
        }

        Set<List<Integer>> set = new HashSet<>();

        for (int a = 0; a < len - 3; a++) {
            for (int b = a + 1; b < len - 2; b++) {
                for (int c = b + 1; c < len - 1; c++) {
                    for (int d = c + 1; d < len; d++) {
                        if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                            set.add(IntStream.of(nums[a], nums[b], nums[c], nums[d])
                                             .sorted()
                                             .boxed()
                                             .toList());
                        }
                    }
                }
            }
        }

        return set.stream()
                  .toList();
    }
}
