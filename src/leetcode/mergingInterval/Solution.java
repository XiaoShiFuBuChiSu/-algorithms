package leetcode.mergingInterval;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/26 21:11
 */
public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int[] arr : merge) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public static int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (stack.peek()[1] >= intervals[i][0]) {
                int[] temp = stack.pop();
                stack.push(new int[]{temp[0], intervals[i][1]});
            } else {
                stack.push(intervals[i]);
            }

        }
        int[][] result = new int[stack.size()][];
        int i = 0;
        for (int[] arr : stack) {
            result[i++] = arr;
        }

        return result;
    }
}
