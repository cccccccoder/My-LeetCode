package org.blue.learning.leetcode.day4;


/**
 * @author leiyi
 * @date 2016-03-16 14:35
 * @summary:Solution
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        printListNode(result);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lastNode = null;
        ListNode head = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int total = a + b + temp;
            if (total >= 10) {
                temp = 1;
            } else {
                temp = 0;
            }
            if (lastNode == null) {
                lastNode = new ListNode(total % 10);
                head = lastNode;
            } else {
                lastNode.next = new ListNode(total % 10);
                lastNode = lastNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (temp == 1) {
            lastNode.next = new ListNode(1);
        }
        return head;
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "");
            node = node.next;
        }
    }
}
