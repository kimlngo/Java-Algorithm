package algo;

import data.ListNode;
import util.LinkedListUtils;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createLinkedList(new int[]{1, 1, 1, 1, 1, 1, 1, 1});

        System.out.println("Before removing duplicates: ");
        LinkedListUtils.printLinkedList(head);

        System.out.println("After removing duplicates: ");
        LinkedListUtils.printLinkedList(deleteDuplicates(head));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode tmp = head;

        while (tmp != null) {
            ListNode next = tmp.next;

            while (next != null && tmp.val == next.val)
                next = next.next;

            tmp.next = next;
            tmp = tmp.next;
        }

        return head;
    }
}
