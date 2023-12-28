package basic.search.binarysearch;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description 查找最右侧 <= num的位置
 * @Author 王俊然
 * @Date 2023/12/26 20:32
 */
public class BinaryFindRight {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateIntArray(20, 100);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int result = findRight(arr, 50);
        System.out.println("result = " + result);
    }

    private static int findRight(int[] arr, int num) {
        int left = 0, right = arr.length;
        int l = left, r = right;

        int result = -1, mid = 0;

        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] <= num) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
