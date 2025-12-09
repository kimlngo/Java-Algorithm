package collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        System.out.println("===== LinkedHashMap =====");
        Map<String, String> cityMap = new LinkedHashMap<>();

        cityMap.put("England", "London");
        cityMap.put("Austria", "Wien");
        cityMap.put("Norway", "Oslo");
        cityMap.put("USA", "Washington DC");
        cityMap.put("Norway", "Oslo");

        System.out.println(cityMap); //{England=London, Austria=Wien, Norway=Oslo, USA=Washington DC}

        for (var entry : cityMap.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue());
        }
        /*England - London
          Austria - Wien
          Norway - Oslo
          USA - Washington DC*/
    }
}
