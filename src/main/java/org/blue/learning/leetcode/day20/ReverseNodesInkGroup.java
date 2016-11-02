package org.blue.learning.leetcode.day20;

import java.util.Arrays;

/**
 * @author leiyi
 * @date 2016-11-02 16:22
 * @summary:ReverseNodesInkGroup
 */
public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        ListNode list1 = null;
        ListNode currentNode = null;
        int[] array1 = new int[]{1, 2, 3, 4, 5};
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
        ListNode result = reverseKGroup(list1, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode result = first;
        ListNode[] nodeArray = new ListNode[k + 1];
        for (int i = 0; i < k + 1; i ++) {
            if (first == null) {
                return result.next;
            }
            nodeArray[i] = first;
            first = first.next;
        }
        first = nodeArray[0];
        while (first.next != null) {
            ListNode temp = first;
            if (nodeArray[1] != null && nodeArray[k] != null) {
                nodeArray[1].next = nodeArray[k].next;
            }
            for (int i = k; i >= 1; i --) {
                if (nodeArray[i] != null) {
                    temp.next = nodeArray[i];
                    temp = nodeArray[i];
                }
            }
            if (nodeArray[1] != null) {
                first = nodeArray[1];
                temp = first;
            }
            // 指针向后偏移
            // 清空数组
            Arrays.fill(nodeArray, null);
            for (int i = 0; i < k + 1; i ++) {
                if (temp == null) {
                    return result.next;
                }
                nodeArray[i] = temp;
                temp = temp.next;
            }
        }
        return result.next;
    }
}
