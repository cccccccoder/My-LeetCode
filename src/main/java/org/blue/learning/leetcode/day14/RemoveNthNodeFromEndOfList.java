package org.blue.learning.leetcode.day14;

/**
 * Created by klein on 2016/10/31.
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = null;
        ListNode currentNode = null;
        for (int i = 0; i < 5; i ++) {
            ListNode temp = new ListNode(i + 1);
            if (head == null) {
                head = temp;
                currentNode = head;
            } else {
                currentNode.next = temp;
                currentNode = temp;
            }
        }
        head = removeNthFromEnd(head, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 双指针，快慢指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode result = head;
        ListNode nthNode = head;
        for (int i = 0; i < n - 1; i ++) {
            if (nthNode.next != null) {
                nthNode = nthNode.next;
            } else {
                // 已结到了末尾，循环已结结束
                return head;
            }
        }
        ListNode last = head;
        while (nthNode.next != null) {
            last = head;
            head = head.next;
            nthNode = nthNode.next;
        }
        if (last == head) {
            if (last == nthNode) {
                return null;
            } else {
                result = last.next;
                last.next = null;
                return result;
            }
        } else {
            last.next = head.next;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
