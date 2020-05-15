package com.solution.leetcode;

import java.util.Arrays;

public class 合并n个区间 {
/*
* 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

    public static void main(String[] args) {
        int[][] aa={{1,3},{8,10},{2,6},{15,18}};
        new Solution().merge(aa);
    }
}



class Solution {
    public int[][] merge(int[][] intervals) {
            //两个元素的差值相减对而为数组进行排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res= new int[intervals.length][2];
        int temp=-1;
        for(int[] interval: intervals){
            if (temp==-1||res[temp][1]<interval[0])
            {
                res[++temp]=interval;
            }
            else {
                res[temp][1]=Math.max(res[temp][1],interval[1]);
            }
        }
        //消除合并后剩下的空余桶位
        return Arrays.copyOf(res,temp+1);
    }
}