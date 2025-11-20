package algo;

import java.util.Arrays;

/*
 * Compute an array B where B[i] is the product of all elements in A except A[i], without using division and in O(N) time.
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] input = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

    private static int[] productExceptSelf(int[] input) {
        int prefix = 1;
        int suffix = 1;
        int len = input.length;

        int[] result = new int[len];
        Arrays.fill(result, 1);

        //pass 1
        for (int i = 0; i < len; i++) {
            result[i] = prefix;
            prefix *= input[i];
        }

        //pass 2
        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= input[i];
        }

        return result;
    }
}
