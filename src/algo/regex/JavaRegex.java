package algo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    private static boolean isMatch(String s, String p) {
        if(!p.contains("*") && !p.contains("."))
            return s.equals(p);

        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}
