package basic.sorting.insertsort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 插入排序
 * @Author 王俊然
 * @Date 2023/12/26 9:03
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.generateIntArray(10,100);
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
