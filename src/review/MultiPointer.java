package review;

import java.util.Arrays;

public class MultiPointer {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZeros(new int[]{-3, -2, -1, 0, 1, 2, 3})));
        System.out.println(Arrays.toString(sumZeros(new int[]{-2, 0, 1, 3})));
        System.out.println(Arrays.toString(sumZeros(new int[]{ 1, 2, 3})));
    }

    private static int[] sumZeros(int[] sortedArr) {
        int left = 0, right = sortedArr.length - 1;

        while (left < right) {
            int leftVal = sortedArr[left];
            int rightVal = sortedArr[right];

            int sum = leftVal + rightVal;
            if (sum == 0) {
                return new int[]{leftVal, rightVal};
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}
