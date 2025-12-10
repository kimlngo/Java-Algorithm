package algo;

import data.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode node = new ListNode();

        ListNode list1 = createLinkedListFromArray(new int[]{1, 4, 5});
        ListNode list2 = createLinkedListFromArray(new int[]{1, 3, 4});
        ListNode list3 = createLinkedListFromArray(new int[]{2, 6});

        var result = mergeKLists(new ListNode[]{list1, list2, list3});

        var tmp = result;
        while (tmp != null) {
            System.out.print(tmp.getVal() + " -> ");
            tmp = tmp.getNext();
        }
    }

    private static ListNode createLinkedListFromArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;

        for (int i = 1; i < arr.length; i++) {
            var node = new ListNode(arr[i]);
            tmp.setNext(node);
        }

        return head;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> sortedListNodes = Arrays.stream(lists)
                                               .map(MergeKSortedLists::convertToListOfNodes)
                                               .flatMap(List::stream)
                                               .sorted(Comparator.comparingInt(ListNode::getVal))
                                               .toList();

        for (int k = 0; k < sortedListNodes.size() - 1; k++) {
            sortedListNodes.get(k)
                           .setNext(sortedListNodes.get(k + 1));
        }

        sortedListNodes.getLast()
                       .setNext(null);

        return sortedListNodes.getFirst();
    }

    private static List<ListNode> convertToListOfNodes(ListNode node) {
        ListNode tmp = node;

        List<ListNode> result = new ArrayList<>();
        while (tmp != null) {
            result.add(tmp);
            tmp = tmp.getNext();
        }

        return result;
    }
}
