package algo;

public class CountPrefixSuffix {
    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[]{"abab","ab"}));
    }

    private static int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j]))
                    count++;
            }
        }

        return count;
    }

    /*
    Return true if s1 is both pre- and suffix of s2
     */
    private static boolean isPrefixAndSuffix(String s1, String s2) {
        return s2.startsWith(s1) && s2.endsWith(s1);
    }
}
