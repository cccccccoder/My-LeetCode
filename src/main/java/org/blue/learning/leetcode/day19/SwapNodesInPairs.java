package org.blue.learning.leetcode.day19;

/**
 * Created by klein on 2016/11/1.
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode list1 = null;
        ListNode currentNode = null;
        int[] array1 = new int[]{1, 3, 5, 7, 9};
        for (int anArray1 : array1) {
            ListNode temp = new ListNode(anArray1);
            if (list1 == null) {
                list1 = temp;
                currentNode = list1;
            } else {
                currentNode.next = temp;
                currentNode = temp;
            }
        }
        ListNode result = swapPairs(list1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l1 = new ListNode(-1);
        l1.next = head;
        ListNode l2 = head.next;
        if (l2 == null) {
            return head;
        }
        ListNode result = l2;
        while (l1 != null && l2 != null) {
            l1.next.next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            for (int i = 0; i < 2; i ++) {
                if (l2 == null) {
                    break;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return result;
    }
}
