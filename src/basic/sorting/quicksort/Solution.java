package basic.sorting.quicksort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/10 19:53
 */
public class Solution {
    public static void main(String[] args) {
        // int[] nums = {43, 3, 0, 36, 5, 64, 6, 83, 95, 59};
        int[] nums = ArrayUtils.generateIntArray(5,100);
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums, int start, int end) {
        int l = start;
        int r = end;

        int pivot = nums[(start + end) / 2];

        while (l < r) {
            while (nums[l] < pivot) {
                l++;
            }

            while (nums[r] > pivot) {
                r--;
            }

            if (l >= r) {
                break;
            }

            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;

            if (nums[r] == pivot) {
                l++;
            }

            if (nums[l] == pivot) {
                r--;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (r > start) {
            quickSort(nums, start, r);
        }

        if (l < end) {
            quickSort(nums, l, end);
        }
    }
}
