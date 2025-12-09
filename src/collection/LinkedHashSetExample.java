package collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        System.out.println("===== LinkedHashSet =====");
        Set<String> cars = new LinkedHashSet<>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");

        System.out.println(cars); //[Volvo, BMW, Ford, Mazda]
    }
}
