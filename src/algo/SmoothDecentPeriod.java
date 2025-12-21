package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmoothDecentPeriod {
    public static void main(String[] args) {
        System.out.println(getDecentPeriods(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7}));
    }

    private static long getDecentPeriods(int[] prices) {
        if (prices.length < 2)
            return prices.length;

        //1) spread each int in prices as a List<Integer> - this gives the first n decent periods
        int decentCount = 0;
        List<List<Integer>> priceInts = Arrays.stream(prices)
                                              .boxed()
                                              .map(List::of)
                                              .toList();

        //2) check if each pair can be merged, if so, merge it into a new List<Integer>

        while (!priceInts.isEmpty()) {
            int idx = 0;
            List<List<Integer>> mergePeriods = new ArrayList<>();
            decentCount += priceInts.size();
            while (idx < priceInts.size() - 1) {
                List<Integer> merge = mergePeriods(priceInts.get(idx), priceInts.get(idx + 1));

                if (!merge.isEmpty()) {
                    mergePeriods.add(merge);
                }
                idx++;
            }

            priceInts = mergePeriods;
        }

        return decentCount;
    }

    private static List<Integer> mergePeriods(List<Integer> l1, List<Integer> l2) {
        if (l1.isEmpty() || l2.isEmpty())
            return new ArrayList<>();

        //both lists are not empty
        var l1Last = l1.getLast();
        var l2First = l2.getFirst();

        if (l1Last - l2First == 1) {
            //two lists can be merged
            List<Integer> merge = new ArrayList<>();
            merge.addAll(l1);
            merge.addAll(l2);
            return merge;
        } else if (l1Last.equals(l2First) && l1.size() > 1 && l2.size() > 1) {
            List<Integer> merge = new ArrayList<>();
            l1.removeLast();
            merge.addAll(l1);
            merge.addAll(l2);
            return merge;
        }
        return new ArrayList<>();
    }
}
