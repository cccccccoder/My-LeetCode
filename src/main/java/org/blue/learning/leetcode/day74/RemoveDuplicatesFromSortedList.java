package org.blue.learning.leetcode.day74;

import org.blue.learning.leetcode.day4.ListNode;

/**
 * @author leiyi
 * @date 2016-12-28 18:56
 * @summary:RemoveDuplicatesFromSortedList
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
