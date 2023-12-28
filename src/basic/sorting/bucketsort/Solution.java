package basic.sorting.bucketsort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/26 15:41
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.generateIntArray(100,100);
        System.out.println(Arrays.toString(nums));
        bucketSort(nums);
    }

    public static void bucketSort(int[] array) {
        int[][] bucket = new int[10][array.length];
        int maxSize = String.valueOf(findMaxInArr(array)).length();
        // 设置一个长度为10的数组，表示每个桶中存放了多少数据
        int[] bucketElementCount = new int[10];

        for (int i = 0, n = 1; i < maxSize; i++, n *= 10) {
            // 入桶
            for (int j = 0; j < array.length; j++) {
                int unitNum = array[j] / n % 10;
                bucket[unitNum][bucketElementCount[unitNum]++] = array[j];
            }

            // 出桶
            int index = 0;
            for (int j = 0; j < 10; j++) {
                int length = bucketElementCount[j];
                for (int k = 0; k < length; k++) {
                    array[index++] = bucket[j][k];
                    bucket[j][k] = 0;
                    bucketElementCount[j]--;
                }
            }
        }
    }

    private static int findMaxInArr(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int num : array) {
            if (max < num) {
                max = num;
            }
        }

        return max;
    }

}
