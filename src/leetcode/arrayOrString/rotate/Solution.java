package leetcode.arrayOrString.rotate;

/**
 * @Description 轮转数组解析
 * @Author 王俊然
 * @Date 2023/12/4 19:43
 */
public class Solution {

    /**
     * 额外数组实现，时间复杂度O(n) 空间复杂度O(n)
     * @param nums
     * @param k
     */
    public void rotate01(int[] nums, int k) {
        if(k == 0){
            return;
        }

        int n = nums.length;

        int tempArr[] = new int[n];


        for(int i = 0,j = k; i < n;i++,j++){
            tempArr[j % n] = nums[i];
        }

        System.arraycopy(tempArr, 0, nums, 0, n);
    }
}
