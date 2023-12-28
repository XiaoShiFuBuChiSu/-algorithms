package basic.sorting.selectSort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author 王俊然
 * @Date 2023/12/26 9:04
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.generateIntArray(20,100);
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
