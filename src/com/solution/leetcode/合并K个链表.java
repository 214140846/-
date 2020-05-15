package com.solution.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 合并K个链表 {
    /*
    * 23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
    * */
}
 class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue=new PriorityQueue<ListNode>((v1,v2) -> v1.val-v2.val);
        Arrays.stream(lists).forEach(k -> {
            ListNode tem=k;
            while(tem!=null)
            {
                queue.offer(tem);
                tem=tem.next;
            }
        });
        //logN
        ListNode head=null;
        ListNode tem=queue.poll();
        while(queue.size()!=0){
            tem.next=queue.poll();
            tem=tem.next;
            if (head==null)head=tem;
        }
        return  head;
    }
}

