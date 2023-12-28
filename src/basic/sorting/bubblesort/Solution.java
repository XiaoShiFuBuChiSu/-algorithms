package basic.sorting.bubblesort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 冒泡排序实现
 * @Author 王俊然
 * @Date 2023/12/26 8:52
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.generateIntArray(20,100);
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }

        }
    }
}
