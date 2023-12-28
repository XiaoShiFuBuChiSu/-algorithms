package basic.sorting.mergesort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 归并排序
 * @Author 王俊然
 * @Date 2023/12/26 14:44
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.generateIntArray(20,100);
        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] arr, int start, int end, int[] tempArr) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid, tempArr);
            mergeSort(arr, mid + 1, end, tempArr);
            int s1 = start, s2 = mid + 1;
            int i = 0;
            while (s1 <= mid && s2 <= end) {
                if (arr[s1] < arr[s2]) {
                    tempArr[i++] = arr[s1++];
                } else {
                    tempArr[i++] = arr[s2++];
                }
            }

            while (s1 <= mid) {
                tempArr[i++] = arr[s1++];
            }

            while (s2 <= end) {
                tempArr[i++] = arr[s2++];
            }

            for (int j = start, k = 0; k < end - start + 1; j++, k++) {
                arr[j] = tempArr[k];
            }
        }
    }
}
