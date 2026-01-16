package review;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCounter {
    public static void main(String[] args) {
        System.out.println(createFreqCounter("ABCDEFabcdefABC"));
        System.out.println(createFreqCounterManual("ABCDEFabcdefABC"));
    }

    private static Map<Character, Long> createFreqCounter(String text) {
        return text.chars()
                   .mapToObj(a -> (char) a)
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Map<Character, Long> createFreqCounterManual(String text) {
        Map<Character, Long> result = new HashMap<>();

        for (char c : text.toCharArray()) {
            result.putIfAbsent(c, 0L);
            result.put(c, result.get(c) + 1);
        }

        return result;
    }
}
