package org.blue.learning.leetcode.day73;

import org.blue.learning.leetcode.day4.ListNode;

/**
 * @author leiyi
 * @date 2016-12-28 10:12
 * @summary:SearchInRotatedSortedArrayII
 */
public class  RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 2, 3, 2, 2, 2};
        ListNode list = new ListNode(array[0]);
        ListNode head = list;
        for (int i = 1; i < array.length; i ++) {
            ListNode node = new ListNode(array[i]);
            list.next = node;
            list = node;
        }
        head = deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode result = null;
        ListNode temp;
        ListNode resultCur = null;
        while (cur != null) {
            int duplicateCount = 0;
            temp = cur.next;
            while (temp != null && temp.val == cur.val) {
                duplicateCount ++;
                temp = temp.next;
                cur = cur.next;
            }
            if (duplicateCount == 0) {
                if (result == null) {
                    result = cur;
                    resultCur = result;
                } else {
                    resultCur.next = cur;
                    resultCur = cur;
                }
            } else {
                if (resultCur != null)
                    resultCur.next = null;
            }
            cur = cur.next;
        }
        return result;
    }
}
