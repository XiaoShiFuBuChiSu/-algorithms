package leetcode.linkedlist.partition;

import leetcode.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5, n1);
        ListNode n3 = new ListNode(2, n2);
        ListNode n4 = new ListNode(3, n3);
        ListNode n5 = new ListNode(4, n4);
        ListNode n6 = new ListNode(1, n5);
        ListNode partition = partition(n6, 3);
        while (partition != null) {
            System.out.print(partition.val + " ");
            partition = partition.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode lessHead = new ListNode();
        ListNode lessTemp = lessHead;
        ListNode greaterHead = new ListNode();
        ListNode greaterTemp = greaterHead;
        while (temp != null) {
            if (temp.val < x) {
                lessTemp.next = new ListNode(temp.val);
                lessTemp = lessTemp.next;
            } else {
                greaterTemp.next = new ListNode(temp.val);
                greaterTemp = greaterTemp.next;
            }
            temp = temp.next;
        }

        lessTemp.next = greaterHead.next;
        return lessHead.next;
    }

}
