package util;

import data.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtils {

    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;

        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) return;

        ListNode tmp = head;
        List<String> stringList = new ArrayList<>();
        while (tmp != null) {
            stringList.add(String.valueOf(tmp.val));
            tmp = tmp.next;
        }

        System.out.println(String.join(" -> ", stringList));
    }
}
