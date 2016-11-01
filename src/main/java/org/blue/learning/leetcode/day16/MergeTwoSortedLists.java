package org.blue.learning.leetcode.day16;



/**
 * @author leiyi
 * @date 2016-11-01 10:43
 * @summary:MergeTwoSortedLists
 */
public class MergeTwoSortedLists {

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
        ListNode list2 = null;
        currentNode = null;
        int[] array2 = new int[]{2, 4, 6, 8, 10};
        for (int anArray2 : array2) {
            ListNode temp = new ListNode(anArray2);
            if (list2 == null) {
                list2 = temp;
                currentNode = list2;
            } else {
                currentNode.next = temp;
                currentNode = temp;
            }
        }
        ListNode newList = mergeTwoLists(list1, list2);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    /**
     * 归并排序
     * 数组换成链表而已
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newListHead = new ListNode(-1);
        ListNode last = newListHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = l1;
                last = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                last = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            last.next = l1;
            last = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            last.next = l2;
            last = l2;
            l2 = l2.next;
        }
        ListNode result = newListHead.next;
        newListHead.next = null;
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {this.val = x ;}
    }

}
