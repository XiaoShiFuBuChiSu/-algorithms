package basic.sorting.headsort;

import java.util.Arrays;

/**
 * @Description 堆排序代码
 * @Author 王俊然
 * @Date 2023/11/30 14:33
 */
public class Solution {
    public static void main(String[] args) {
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr 要排序的数组
     */
    public static void heapSort(int arr[]) {
        // 1.构建大顶堆
        // a.找到第一个有子节点的节点，循环构建大顶堆
        int l = arr.length;
        int startNode = (l) / 2 - 1;
        for (int i = startNode; i >= 0; i--) {
            // 构建大顶堆的方法
            adjustHeap(arr, i, l);
        }

        // 2.将根节点的元素与数组末尾元素交换
        int temp = 0;
        for (int j = l - 1; j >= 0; j--) {
            // a.将根节点和新数组的最后一位元素交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            // b.重新构建大顶堆
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 构建大顶堆的方法
     *
     * @param arr 要排序的数组
     * @param i   从数组的那个位置开始(非叶子节点)
     * @param l   从数组的那个位置结束(递减的，构建大顶堆之后会交换位置，一般放在数组后面，后面已经交换过的将不再考虑了)
     */
    private static void adjustHeap(int[] arr, int i, int l) {
        // 1. 从根节点开始逐步构建大顶堆
        // a. 获取根节点的左子结点
        int leftNode = (2 * i) + 1;
        // b. 获取根节点的值作为临时变量，后续构建大顶堆时备用
        int temp = arr[i];
        for (int k = leftNode; k < l; k++) {
            // 判断是否越界、左子节点是否比右子节点小
            if (k + 1 < l && arr[k] < arr[k + 1]) {
                // 满足条件，置换右子节点
                k++;
            }
            // 构建大顶堆
            if (arr[k] > temp) {
                arr[i] = arr[k];
                // 节点值置换之后，其子节点所在的子树可能不是大顶堆了，需要重新置换
                i = k;
            }

        }
        // 循环结束后，当前i所代表的节点应该是一个叶子节点，将他的值设为temp
        arr[i] = temp;
    }
}
