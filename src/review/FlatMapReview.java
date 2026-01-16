package review;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapReview {
    public static void main(String[] args) {
        System.out.println("================ FlatMap with List ===================");
        List<List<String>> sentence = List.of(
                List.of("one", "two", "three"),
                List.of("four", "five", "six"));

        String count = sentence.stream()
                               .flatMap(List::stream)
                               .collect(Collectors.joining(", "));

        System.out.println(count);

        System.out.println("================ FlatMap with Array ===================");
        int[][] numsArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        count = Arrays.stream(numsArr)
                      .flatMapToInt(Arrays::stream)
                      .boxed()
                      .sorted(Collections.reverseOrder())
                      .map(String::valueOf)
                      .collect(Collectors.joining(", "));
        System.out.println(count);

        System.out.println("================ FlatMap with Optional ===================");
        Optional<Car> carOpt = Optional.of(new Car(Optional.of("National General")));

        System.out.println(carOpt.flatMap(Car::insurance)
                                 .orElse("Unknown"));

        System.out.println("================ Tree Map Revision ===================");
        Map<String, String> countryCapitals = new TreeMap<>();
        countryCapitals.put("Vietnam", "Hanoi");
        countryCapitals.put("U.S.", "Washington");
        countryCapitals.put("Canada", "Ottawa");
        countryCapitals.put("Australia", "Canberra");

        countryCapitals.forEach((key, value) -> System.out.printf("%s - %s\n", key, value));
    }
}


record Car(Optional<String> insurance) {
};