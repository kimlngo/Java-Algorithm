package algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAtoi {
    private static Map<Character, Integer> digitMap = new HashMap<>();

    static {
        for(int i = 0; i < 10; i++) {
            digitMap.put((char) ('0' + i), i);
        }

    }
    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("-042"));
//        System.out.println(myAtoi("1337c0d3"));
//
//        System.out.println(myAtoi("0-1"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-2147483649"));
//        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("+1"));
    }

    private static int myAtoi(String s) {
        if(s.isBlank())
            return 0;
        //1) remove front, back white spaces
        String trimmedStr = s.trim();

        //2) read the sign
        boolean containSign = List.of('+', '-')
                                  .contains(trimmedStr.charAt(0));
        boolean isNegative = trimmedStr.charAt(0) == '-';

        //3) create start index
        int index = containSign ? 1 : 0;
        int result = 0, pre = 0;

        while(index < trimmedStr.length()) {
            Integer d = digitMap.get(trimmedStr.charAt(index));

            //encounter a non-digit character -> break
            if(d == null)
                break;
            pre = result;
            result = result * 10 + d;

            //4) check for overflow
            if(!String.valueOf(pre).equals(String.valueOf((int) (result / 10)))) {
                //overflow happened
                if(isNegative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            index++;
        }

        return isNegative ? -result : result;
    }
}
