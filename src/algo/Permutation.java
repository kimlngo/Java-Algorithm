package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        var result = permute(new int[]{1, 2, 3});
        System.out.println(result);
        System.out.println("Length: " + result.size());
    }

    private static List<List<Integer>> permute(int[] nums) {
        var intList = Arrays.stream(nums)
                            .boxed()
                            .toList();
        List<List<Integer>> finalResult = new ArrayList<>();
        return generatePermutation(intList, finalResult, nums.length);
    }

    private static List<List<Integer>> generatePermutation(List<Integer> nums, List<List<Integer>> finalResult, int finalLength) {
        if (nums.size() == 1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums.getFirst());
            List<List<Integer>> tmp2 = new ArrayList<>();
            tmp2.add(tmp);
            return tmp2;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (var n : nums) {
            List<Integer> copyNums = new ArrayList<>(nums);
            copyNums.removeAll(List.of(n));

            var tmp = generatePermutation(copyNums, finalResult, finalLength);
            tmp.forEach(list -> list.add(n));

            result.addAll(tmp);

            if (tmp.getFirst()
                   .size() == finalLength)
                finalResult.addAll(tmp);
        }

        return result;
    }

}
