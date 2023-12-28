package basic.search.binarysearch;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/23 19:59
 */
public class BinarySearch {
    public static void main(String[] args) {
        // int[] arr = new int[20];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = (int) (Math.random() * 100);
        // }
        int[] arr = {1, 4, 8, 4, 6, 8, 11, 15, 97, 20};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = bSearch(arr, 97);
        System.out.println(i);
    }

    // 1. 检查某个数字是否存在
    public static int bSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        // 中间位置
        int mid = (left + right) / 2;

        while (left < right) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return -1;
    }
}
