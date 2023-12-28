package leetcode.linkedlist.addtwonumbers;

import leetcode.linkedlist.ListNode;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/28 8:57
 */
public class Solution {
    public static void main(String[] args) {
        ListNode n11 = new ListNode(9);
        ListNode n12 = new ListNode(9);
        ListNode n13 = new ListNode(9);
        ListNode n14 = new ListNode(9);
        ListNode n15 = new ListNode(9);
        ListNode n16 = new ListNode(9);
        ListNode n17 = new ListNode(9);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;
        n16.next = n17;

        ListNode n21 = new ListNode(9);
        ListNode n22 = new ListNode(9);
        ListNode n23 = new ListNode(9);
        ListNode n24 = new ListNode(9);
        n21.next = n22;
        n22.next = n23;
        n23.next = n24;


        ListNode listNode = addTwoNumbers(n11, n21);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        ListNode head = new ListNode();
        ListNode tempHead = head;
        ListNode n1 = num1;
        ListNode n2 = num2;

        // 进位
        int carry = 0;

        while (n1 != null || n2 != null) {
            // 取值
            int num1Val = n1 == null ? 0 : n1.val;
            int num2Val = n2 == null ? 0 : n2.val;
            // 求和
            int sum = num1Val + num2Val + carry;
            // 进位
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            // 存值
            ListNode temp = new ListNode(sum % 10);
            tempHead.next = temp;
            tempHead = tempHead.next;

            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }

        }

        if (carry == 1) {
            tempHead.next = new ListNode(1);
        }
        return head.next;
    }
}
