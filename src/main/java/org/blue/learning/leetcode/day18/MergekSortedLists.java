package org.blue.learning.leetcode.day18;


/**
 * Created by klein on 2016/11/1.
 */
public class MergekSortedLists {

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
        ListNode list3 = null;
        currentNode = null;
        int[] array3 = new int[]{2, 4, 6, 8, 10};
        for (int anArray3 : array3) {
            ListNode temp = new ListNode(anArray3);
            if (list3 == null) {
                list3 = temp;
                currentNode = list3;
            } else {
                currentNode.next = temp;
                currentNode = temp;
            }
        }
        ListNode[] lists = new ListNode[0];
        ListNode newList = mergeKLists(lists);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 分治法
     * @param lists
     * @return
     */
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int left = 0;
        int mid = lists.length / 2;
        int right =lists.length - 1;
        ListNode[] leftArray = new ListNode[mid - left];
        System.arraycopy(lists, 0, leftArray, 0, leftArray.length);
        ListNode[] rightArray = new ListNode[right - mid + 1];
        System.arraycopy(lists, mid, rightArray, 0, rightArray.length);
        return mergeTwoLists(mergeKLists(leftArray), mergeKLists(rightArray));
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
