package com.solution.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树的右视图 {
    /*
    * 199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
    * */


}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution6 {
    Map<Integer,Integer> map=new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) return null;
        digui(root,1);
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <=map.size() ; i++) {
            list.add(map.get(i));
        }
        return list;

    }
    public void digui(TreeNode node,int floor){
        if(node==null)return;
        if(!map.containsKey(floor)){
            map.put(floor,node.val);
        }
        digui(node.right,floor+1);
        digui(node.left,floor+1);
    }
}