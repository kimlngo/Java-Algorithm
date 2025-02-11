package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
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

    @Test
    public void testFindArrayLeaders() {
        int[] arr = {1, 2, 3, 4, 5, 2};
        System.out.println("Array leaders in " + Arrays.toString(arr) + " is: " + Arrays.toString(findArrayLeaders(arr)));
    }

    private int[] findArrayLeaders(int[] input) {
        if (input.length <= 1) return input;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length - 1; i++) {
            if (isGreaterOrEqualToAll(input[i], Arrays.stream(input, i + 1, input.length)
                                                      .toArray())) {
                result.add(input[i]);
            }
        }
        result.add(input[input.length - 1]);
        return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    private boolean isGreaterOrEqualToAll(int k, int[] arr) {
        return Arrays.stream(arr)
                     .allMatch(i -> k >= i);
    }

    @Test
    public void testFindMinNumPlatforms() {
        String[] arrival = {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"};
        String[] departure = {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"};
        Assertions.assertEquals(3, findMinNumPlatforms(arrival, departure));

        String[] arrival2 = {"9:00", "9:40"};
        String[] departure2 = {"9:10", "12:00"};
        Assertions.assertEquals(1, findMinNumPlatforms(arrival2, departure2));
    }

    private int findMinNumPlatforms(String[] arrival, String[] departure) {
        List<TrainTime> arrivalList = Arrays.stream(arrival)
                                            .map(this::convertTrainTime)
                                            .sorted(this::compareTime)
                                            .toList();

        List<TrainTime> departureList = Arrays.stream(departure)
                                              .map(this::convertTrainTime)
                                              .sorted(this::compareTime)
                                              .toList();

        int count = 0, minPlatformCount = 0;

        int i = 0, j = 0;

        while (i < arrivalList.size() && j < departureList.size()) {
            TrainTime t1 = arrivalList.get(i);
            TrainTime t2 = departureList.get(j);
            if (compareTime(t1, t2) < 0) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            if (minPlatformCount < count) {
                minPlatformCount = count;
            }
        }
        return minPlatformCount;
    }

    private TrainTime convertTrainTime(String time) {
        String[] splits = time.split(":");
        return new TrainTime(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
    }

    /**
     * @param t1
     * @param t2
     * @return comparator in ascending order
     * if a < b -> a - b
     */
    private int compareTime(TrainTime t1, TrainTime t2) {
        if (t1.hour() != t2.hour()) return t1.hour() - t2.hour();
        else return t1.min() - t2.min();
    }

    @Test
    public void testRightRotateArray() {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        Assertions.assertEquals("7 9 1 3 5", rightRotateArray(arr, 2));

        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        Assertions.assertEquals("2 3 4 5 1", rightRotateArray(arr2, 4));
    }

    //assume 0 <= k <= length
    private String rightRotateArray(int[] arr, int k) {
        int length = arr.length;

        int startIndex = length - k;
        //loop-1

        String arr1 = Arrays.stream(arr, startIndex, length)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "));

        //loop-2
        String arr2 = Arrays.stream(arr, 0, startIndex)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "));

        return arr1 + " " + arr2;
    }

    @Test
    public void testFindNthSmallestNumber() {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        Assertions.assertEquals(7, findNthSmallestNumber(arr, 3));
        Assertions.assertEquals(10, findNthSmallestNumber(arr, 4));
    }

    private int findNthSmallestNumber(int[] input, int k) {
        return Arrays.stream(input)
                     .sorted()
                     .toArray()[k - 1];
    }

    @Test
    public void testFindMaxLengthBitonic() {
        int[] input1 = {20, 4, 1, 2, 3, 4, 2, 10};
        int[] input2 = {12, 4, 78, 90, 45, 23};
        int[] input3 = {40, 30, 20, 10};
        int[] input4 = {10, 20, 30, 40};
        int[] input5 = {10, 20};
        int[] input6 = {30, 20};
        System.out.println("Max Bitonic Length 1 = " + findMaxLengthBitonic(input1));
        System.out.println("Max Bitonic Length 2 = " + findMaxLengthBitonic(input2));
        System.out.println("Max Bitonic Length 3 = " + findMaxLengthBitonic(input3));
        System.out.println("Max Bitonic Length 4 = " + findMaxLengthBitonic(input4));
        System.out.println("Max Bitonic Length 5 = " + findMaxLengthBitonic(input5));
        System.out.println("Max Bitonic Length 6 = " + findMaxLengthBitonic(input6));
    }

    private int findMaxLengthBitonic(int[] arr) {
        if (arr.length <= 2) return arr.length;

        int startIndex = -1;
        int peak = -1;
        int endIndex = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (startIndex == -1) {
                if (arr[i] > arr[i + 1]) continue;
                else startIndex = i;
            } else {
                if(i != arr.length - 2) {
                    if (arr[i] <= arr[i + 1]) continue;
                    else {
                        peak = i;
                        break;
                    }
                } else {
                    if (arr[i] <= arr[i + 1]) return arr.length - startIndex;
                    else return arr.length - startIndex - 1;
                }
            }
        }
        if(peak == -1 && startIndex == -1) {
            peak = 0;
            startIndex = 0;
        }
        for (int j = peak; j < arr.length - 1; j++) {
            if (j != arr.length - 2) {
                if (arr[j] >= arr[j + 1]) continue;
                else {
                    endIndex = j;
                    break;
                }
            } else {
                if (arr[j] >= arr[j + 1]) endIndex = j + 1;
                else endIndex = j;

                break;
            }
        }

        return endIndex - startIndex + 1;
    }
}

record TrainTime(int hour, int min) {
}
