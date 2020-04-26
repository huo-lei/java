package com.company;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.

 */

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(8);

    ListNode l2 = new ListNode(0);

    print(l1);
    print(l2);
    ListNode res = (new AddTwoNumbers()).addTwoNumbers(l1, l2);
    print(res);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummy.next;
  }

  public static void print(ListNode l1) {
    System.out.print("[");

    while (l1 != null) {
      System.out.print(l1.val);
      if (l1.next != null) {
        System.out.print(",");
      }
      l1 = l1.next;
    }
    System.out.println("]");
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
