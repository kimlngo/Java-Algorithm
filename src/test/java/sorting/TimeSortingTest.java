package sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of string containing the time (mm:hh)
 * write two function to sort the time in ascending order and descending order
 * ["09:30", "08:20", "10:34", "13:45", "23:59", "23:30"]
 */

public class TimeSortingTest {

    @Test
    public void testSortTimeStamps() {
        String[] input = new String[]{"09:30", "08:20", "10:34", "13:45", "23:59", "23:30"};
        System.out.println("Sort in Ascending Order");
        System.out.println(sortTimeStampsAscendingOrder(input));

        System.out.println("Sort in Descending Order");
        System.out.println(sortTimeStampsDescendingOrder(input));
    }

    private List<String> sortTimeStampsAscendingOrder(String[] input) {
        return this.sortTimeStamps(input, this::sortAscendingOrder);
    }

    private List<String> sortTimeStampsDescendingOrder(String[] input) {
        return this.sortTimeStamps(input, this::sortDescendingOrder);
    }

    private List<String> sortTimeStamps(String[] input, Comparator<TimeStamp> comparator) {
        return Arrays.stream(input)
                     .map(this::convertStrToTimeStamp)
                     .sorted(comparator)
                     .map(this::formatTimeStampToString)
                     .toList();
    }

    private String formatTimeStampToString(TimeStamp t) {
        return String.format("%02d:%2d", t.hour(), t.minute());
    }

    private int sortAscendingOrder(TimeStamp t1, TimeStamp t2) {
        if (t1.hour() != t2.hour()) return t1.hour() - t2.hour();
        else return t1.minute() - t2.minute();
    }

    private int sortDescendingOrder(TimeStamp t1, TimeStamp t2) {
        return -this.sortAscendingOrder(t1, t2);
    }

    private TimeStamp convertStrToTimeStamp(String timeStr) {
        String[] split = timeStr.split(":");
        return new TimeStamp(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}

record TimeStamp(int hour, int minute) {
}
