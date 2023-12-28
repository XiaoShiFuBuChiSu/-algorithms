package basic.search.binarysearch;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 查找最左侧 >= num的位置
 * @Author 王俊然
 * @Date 2023/12/26 20:15
 */
public class BinaryFindLeft {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateIntArray(20, 100);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int result = findLeft(arr, 20);
        System.out.println("result = " + result);
    }

    public static int findLeft(int[] arr, int num) {
        int left = 0, right = arr.length;
        int l = left, r = right;

        int result = -1;
        // 求中点，防溢出
        // int mid = ((r - l) >> 1);
        // 1. num >= arr[mid] 记录向左继续二分
        // 2. num < arr[mid] 不记录 向右继续二分
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] >= num) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;

    }
}
