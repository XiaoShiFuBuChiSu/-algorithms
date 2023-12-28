package leetcode.findPeekElement;

import java.util.Arrays;

/**
 * @Description 寻找峰值
 * @Author 王俊然
 * @Date 2023/12/27 14:20
 * @Link https://leetcode.cn/problems/find-peak-element/
 */
public class Solution {
    public static void main(String[] args) {
        // int[] arr = ArrayUtils.generateIntArray(10, 5);
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        // 左边
        if (nums[0] > nums[1]) {
            return 0;
        }
        // 右边
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        // 如果上面两个不行，那么说明1 ~ n-2 中间必有值少一个峰值
        int l = 1, r = len - 2, m = 0, res = -1;
        while (l <= r) {
            // 取中间值
            m = l + ((r - l) >> 1);
            // 如果左边的比res大则向左二分
            if (nums[m - 1] > nums[m]) {
                r = m - 1;
            }
            // 如果右边的比res大则向右二分
            else if (nums[m + 1] > nums[m]) {
                l = m + 1;
            }
            // 左边右边都比res小则他就是结果
            else {
                res = m;
                break;
            }
        }
        return res;
    }
}
