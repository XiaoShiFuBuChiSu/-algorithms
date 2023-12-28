package utils;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/26 9:04
 */
public class ArrayUtils {

    public static int[] generateIntArray(int size,int range) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = (int) (Math.random() * range);
        }
        return nums;
    }
}
