package algo;

import java.util.Arrays;

/**
 * You are given an array apple of size n and an array capacity of size m.
 * <p>
 * There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
 * <p>
 * Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
 * <p>
 * Note that, apples from the same pack can be distributed into different boxes.
 * <p>
 * Example 1:
 * <p>
 * Input: apple = [1,3,2], capacity = [4,3,1,5,2]
 * Output: 2
 * Explanation: We will use boxes with capacities 4 and 5.
 * It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
 * Example 2:
 * <p>
 * Input: apple = [5,5,5], capacity = [2,4,2,7]
 * Output: 4
 * Explanation: We will need to use all the boxes.
 */
public class AppleRedistribution {
    public static void main(String[] args) {
        int[] apples = new int[]{5, 5, 5};
        int[] capacity = new int[]{2, 4, 2, 7};

        System.out.println(minimumBoxes(apples, capacity));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        //1) calculate total # of apples
        int totalApple = Arrays.stream(apple)
                               .sum();

        //2) sort the capacity as descending order
        int[] sortedCapacity = Arrays.stream(capacity)
                                     .boxed()
                                     .sorted((a, b) -> b - a)
                                     .mapToInt(Integer::valueOf)
                                     .toArray();

        //3) iterate through sorted box until no more apples or no more boxes
        int boxCount = 0;

        while (totalApple > 0 && boxCount < sortedCapacity.length) {
            int cap = sortedCapacity[boxCount];
            totalApple -= cap;
            boxCount++;
        }

        return boxCount;
    }
}
