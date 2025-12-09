package collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        System.out.println("===== TreeSet Example =====");
        Set<String> cars = new TreeSet<>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");

        System.out.println(cars); //[BMW, Ford, Mazda, Volvo] - sorted order
        for (String car : cars) {
            System.out.println("Brand name: " + car);
        }

        System.out.println("===== normal HashSet =====");
        Set<String> carSet = new HashSet<>();
        carSet.add("Volvo");
        carSet.add("BMW");
        carSet.add("Ford");
        carSet.add("BMW");
        carSet.add("Mazda");

        System.out.println(carSet); //[Volvo, Mazda, Ford, BMW] - no sorted order

        System.out.println("===== TreeSet with Numbers =====");
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10);

        System.out.println("Numbers: " + numbers); //Numbers: [10, 20, 30, 40]
    }
}
