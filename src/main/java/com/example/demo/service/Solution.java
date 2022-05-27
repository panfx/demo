package com.example.demo.service;

/**
 * @author panfuxue
 * @date 2022/03/13 15:43
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode listNode = reverseList(node, 1, 4);
        System.out.println(listNode.toString("[") + "]");
    }

    public static ListNode reverseList(ListNode node, int m, int n) {
        // 记录m节点，以便翻转完m-n阶段的链表后设置m指针为n的下一个元素
        ListNode mNode = null;
        ListNode pre = null;
        ListNode current = node;
        for (int i = 0;; i++) {
            if (current == null || i > n) {
                break;
            }
            if (i < m) {
                pre = current;
                current = current.next;
                continue;
            } else if (i == m) {
                mNode = current;
            }
            if (i <= n) {
                ListNode temp = current.next;
                current.next = pre;
                pre = current;
                current = temp;
                continue;
            }
        }

        // 当前m节点和m前一个节点为互指状态，需要将m的前一个节点指向n节点，即是pre
        if (mNode != null) {
            if (mNode.next != null) {
                mNode.next.next = pre;
            }

            mNode.next = current;
        }

        return m <= 0 ? pre : node;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(String s) {
        String result = (s != "[" ? (s + ",") : s) + val;
        if (next != null) {
            result = next.toString(result);
        }

        return result;
    }
}
