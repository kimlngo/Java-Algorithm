package algo;

import util.ReadText;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) throws IOException {
        String line = ReadText.readLine("src/data/duplicates.txt");
        System.out.println(removeAdjDuplicates_Stack(line));

        System.out.println("Done");

        System.out.println(removeAdjDuplicates_Stack("abbaca"));
        System.out.println(removeAdjDuplicates_Stack("azxxzy"));
        System.out.println(removeAdjDuplicates_Stack("aaaaaaaaa"));
    }

    private static String removeDuplicates(String s) {
        if (s.length() == 1) return s;

        StringBuilder sb = new StringBuilder(s);

        while (containsAdjDuplicates(sb.toString())) {
            StringBuilder result = new StringBuilder();

            int i = 0;
            while (i < sb.length() - 1) {
                if (sb.charAt(i) != sb.charAt(i + 1)) {
                    result.append(sb.charAt(i));
                } else {
                    i++;
                }

                i++;
            }
            //add the last char
            if (i < sb.length())
                result.append(sb.charAt(i));

            sb = result;
        }

        return sb.toString();
    }

    private static boolean containsAdjDuplicates(String s) {
        int len = s.length();

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                return true;
        }

        return false;
    }

    private static String removeAdjDuplicates_Stack(String s) {
        if (s.length() == 1) return s;

        List<Character> charList = s.chars()
                                    .mapToObj(a -> (char) a)
                                    .toList();

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < charList.size(); i++) {
            Character c = charList.get(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek().equals(c))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
