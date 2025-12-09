package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionAlgorithm {
    public static void main(String[] args) {
        System.out.println("===== Collections.max()/min()/frequency()/swap() =====");
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(1);
        nums.add(6);
        nums.add(3);
        nums.add(8);
        nums.add(3);

        System.out.println(Collections.max(nums));  //8
        System.out.println(Collections.min(nums));  //1
        System.out.println(Collections.frequency(nums, 3)); //2
        Collections.swap(nums, 0, 4);
        System.out.println(nums);
    }
}
