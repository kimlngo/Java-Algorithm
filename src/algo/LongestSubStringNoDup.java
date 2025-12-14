package algo;

import java.util.ArrayList;
import java.util.List;

public class LongestSubStringNoDup {
    public static void main(String[] args) {
        System.out.println(longestSubStringNoDup("abcadef"));
    }

    private static int lengthOfLongestSubString(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        //1) declare required vars
        List<Character> seen = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;

        List<Character> chars = new ArrayList<>();
        for (var c : s.toCharArray())
            chars.add(c);

        //2) iterate through each char
        //if char has not been seen -> add them into the buffer and seenChars
        //if char has been seen before (duplication found), get the length of the buffer and compare with
        //current maxLen.
        //clear out the seenChars and buffer.

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                Character c = chars.get(j);
                if (!seen.contains(c)) {
                    seen.add(c);
                } else {
                    maxLen = Math.max(seen.size(), maxLen);
                    seen = new ArrayList<>();
                    break;
                }
            }
        }

        return maxLen;
    }

    private static int longestSubStringNoDup(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        List<Character> seen = new ArrayList<>();

        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (seen.contains(c)) {
                int indexOfDup = seen.lastIndexOf(c);
                left = Math.max(left, indexOfDup + 1);
                seen.set(indexOfDup, '_');
            }

            seen.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

}
