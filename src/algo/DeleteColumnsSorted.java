package algo;

/**
 * You are given an array of n strings strs, all of the same length.
 * <p>
 * The strings can be arranged such that there is one on each line, making a grid.
 * <p>
 * For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
 * abc
 * bce
 * cae
 * You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
 * <p>
 * Return the number of columns that you will delete.
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["cba","daf","ghi"]
 * Output: 1
 * Explanation: The grid looks as follows:
 * cba
 * daf
 * ghi
 * Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
 * Example 2:
 * <p>
 * Input: strs = ["a","b"]
 * Output: 0
 * Explanation: The grid looks as follows:
 * a
 * b
 * Column 0 is the only column and is sorted, so you will not delete any columns.
 * Example 3:
 * <p>
 * Input: strs = ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation: The grid looks as follows:
 * zyx
 * wvu
 * tsr
 * All 3 columns are not sorted, so you will delete all 3.
 * <p>
 * Constraints:
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] consists of lowercase English letters.
 */
public class DeleteColumnsSorted {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(minDeletionSize(new String[]{"a", "b"}));
        System.out.println(minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    public static int minDeletionSize(String[] strs) {
        //1)extract each column into an array of character
        int columns = strs[0].length();
        int length = strs.length;
        int count = 0;

        for (int col = 0; col < columns; col++) {
            char[] charArr = new char[length];
            for (int row = 0; row < length; row++) {
                charArr[row] = strs[row].charAt(col);
            }

            //2)check each array of character to see if they are sorted and update the count of the un-sorted
            if (!isSorted(charArr)) {
                count++;
            }
        }

        //3)return the count
        return count;
    }

    private static boolean isSorted(char[] charArr) {
        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] - '0' > charArr[i + 1] - '0')
                return false;
        }
        return true;
    }

}
