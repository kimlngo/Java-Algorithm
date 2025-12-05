package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {
        var cars = getAllMakes();
        System.out.println("===== Sorting =====");
        System.out.println(cars);
        cars.sort((c1, c2) -> -c1.compareTo(c2));
        System.out.println(cars);


        System.out.println("===== ToArray =====");
        var carArr = cars.toArray();
        System.out.println(Arrays.toString(carArr));

        System.out.println("===== RemoveAll =====");
        var toBeRemoved = List.of("Honda", "Toyota");
        cars = getAllMakes();
        System.out.println(cars);
        cars.removeAll(toBeRemoved);
        System.out.println(cars);

        System.out.println("===== RetainAll =====");
        var toBeRetained = List.of("Honda", "Toyota");
        cars = getAllMakes();
        cars.remove("Honda");
        System.out.println(cars);
        cars.retainAll(toBeRetained);
        System.out.println(cars); //should only have "Toyota"

        System.out.println("==== Sort based on brand name length =====");
        cars = getAllMakes();
        cars.sort(Comparator.comparingInt(String::length));
        System.out.println(cars);

        System.out.println("===== SubList =====");
        cars = getAllMakes();
        System.out.println(cars); //"Chevy", "Ford", "Dodge", "Honda", "Toyota", "Volvo"
        System.out.println(cars.subList(2, 4)); //"Dodge", "Honda"

        System.out.println("===== Reverse =====");
        cars = getAllMakes();
        System.out.println(cars);
        System.out.println(cars.reversed());
    }

    private static List<String> getAllMakes() {
        return new ArrayList<>(List.of("Chevy", "Ford", "Dodge", "Honda", "Toyota", "Volvo"));
    }
}
