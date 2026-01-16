package review;

public class SlidingWindow {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArr(new int[]{1, 2, 5, 2, 8, 1, 5}, 2));
        System.out.println(findMaxSumSubArr(new int[]{1, 2, 5, 2, 8, 1, 5}, 4));
        System.out.println(findMaxSumSubArr(new int[]{4, 2, 1, 6}, 1));
        System.out.println(findMaxSumSubArr(new int[]{4, 2, 1, 6, 2}, 4));
        System.out.println(findMaxSumSubArr(new int[]{}, 4));
    }

    private static Integer findMaxSumSubArr(int[] arr, int n) {
        int len = arr.length;
        if (len == 0)
            return null;
        int sum = 0;
        //1)find initial sum of window n first
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int maxSum = sum;
        //2)slide the window and calculate the sum by subtracting the previous val and plus the next val
        //compare with current max sum and update if needed
        for (int i = 1; i <= len - n; i++) {
            sum = sum - arr[i - 1] + arr[i + n - 1];
            maxSum = Math.max(sum, maxSum);
        }

        //3) return the max sum
        return maxSum;
    }
}
