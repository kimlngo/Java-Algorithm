package algo;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
 */
public class FirstLastElSortedArr {
    private static final int[] NOT_FOUND = new int[]{-1, -1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 9, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)));
        System.out.println(Arrays.toString(searchRange(new int[]{},0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,1,2}, 1)));
    }

    private static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return NOT_FOUND;
        else if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : NOT_FOUND;
        }

        //nums has 2 or more items
        int findFirst = binarySearchNumber(nums, target);
        if (findFirst == -1)
            return NOT_FOUND;

        int i = findFirst;
        int leftIdx = -1;
        while (i >= 0) {
            if (nums[i] == target) {
                leftIdx = i;
                i--;
            } else
                break;
        }

        i = findFirst;
        int rightIdx = -1;
        while (i < nums.length) {
            if (nums[i] == target) {
                rightIdx = i;
                i++;
            } else
                break;
        }

        return new int[]{leftIdx, rightIdx};
    }

    private static int binarySearchNumber(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
