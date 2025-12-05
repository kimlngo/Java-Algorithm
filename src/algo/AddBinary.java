package algo;

import java.util.HashMap;
import java.util.Map;

public class AddBinary {
    private static final Map<String, Result> adderMap = new HashMap<>();

    static {
        //format: carryOver + a + b => Result(sum, carryOver)
        adderMap.put("000", new Result("0", "0"));
        adderMap.put("001", new Result("1", "0"));
        adderMap.put("010", new Result("1", "0"));
        adderMap.put("011", new Result("0", "1"));

        adderMap.put("100", new Result("1", "0"));
        adderMap.put("101", new Result("0", "1"));
        adderMap.put("110", new Result("0", "1"));
        adderMap.put("111", new Result("1", "1"));
    }

    public static void main(String[] args) {
//        System.out.println(addBinary("1011", "1100"));
        System.out.println(addBinary("101010", "1011"));
        System.out.println(addBinary("1011", "101010"));
    }

    private static String addBinary(String a, String b) {
        int len = Math.min(a.length(), b.length());
        String aDigit, bDigit, carryOver = "0";
        int i = 0;
        StringBuilder sb = new StringBuilder();
        String aReverse = reverseString(a);
        String bReverse = reverseString(b);

        while (i < len) {
            aDigit = String.valueOf(aReverse.charAt(i));
            bDigit = String.valueOf(bReverse.charAt(i));

            String key = carryOver + aDigit + bDigit;
            Result r = adderMap.get(key);
            sb.append(r.sum());

            carryOver = r.carryOver();
            i++;
        }

        if (a.length() == b.length()) {
            if (carryOver.equals("1")) {
                sb.append(carryOver);
            }

            return sb.reverse()
                     .toString();
        } else {
            String longerStr = aReverse.length() > bReverse.length() ? aReverse : bReverse;
            String remainingStr = longerStr.substring(i);
            if (carryOver.equals("0")) {
                sb.append(remainingStr);
            } else {
                sb.append(reverseString(addBinary(carryOver, reverseString(remainingStr))));
            }
            return sb.reverse()
                     .toString();
        }
    }

    private static String reverseString(String input) {
        return new StringBuilder(input).reverse()
                                       .toString();
    }
}

record Result(String sum, String carryOver) {
}
