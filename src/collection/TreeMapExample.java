package collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, String> countryCityMap = new TreeMap<>();
        countryCityMap.put("England", "London");
        countryCityMap.put("Austria", "Wien");
        countryCityMap.put("Norway", "Oslo");
        countryCityMap.put("USA", "Washington DC");
        countryCityMap.put("Norway", "Oslo");

        System.out.println(countryCityMap);
        //{Austria=Wien, England=London, Norway=Oslo, USA=Washington DC}

        for (var entry : countryCityMap.entrySet()) {
            System.out.printf("The capital of %s is %s%n", entry.getKey(), entry.getValue());
        }
        /*The capital of Austria is Wien
        The capital of England is London
        The capital of Norway is Oslo
        The capital of USA is Washington DC*/
    }
}
