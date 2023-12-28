package basic.sorting.shellsort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 希尔排序
 * @Author 王俊然
 * @Date 2023/12/26 9:27
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.generateIntArray(10, 100);
        System.out.println(Arrays.toString(nums));
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i - gap;
                while (j >= 0 && temp < nums[j]) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
        }
    }
}
