package leetcode.arrayOrString.removeDuplicates;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/11/29 20:23
 */
public class Solution {

    /* 方法一，双指针，遇到重复元素删除（自己想的笨方法） */
    public int removeDuplicates01(int[] nums) {
        // i第一次出现的位置，j最后一次出现的位置
        int i = 0, j = 0;
        int newLength = nums.length;
        while (i < newLength && j < newLength) {
            if ((nums[i] == nums[j]) && (j - i >= 2)) {    // i和j位置的数字相同，且该数字的个数大于2个
                remove(nums, j, newLength);   // 删除重复元素
                newLength--;        // 实际长度减一
            } else if (nums[i] != nums[j]) { // i和j位置的数字不同
                i = j;
                j++;
            } else {
                j++;
            }
        }

        return newLength;

    }

    public void remove(int[] nums, int index, int newLength) {
        for (int i = index; i < newLength - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /* 方法二快慢指针 */
    public int removeDuplicates02(int[] nums) {
        int l = nums.length;
        if (l <= 2) {
            return l;
        }
        // 慢指针，记录已遍历的位置。快指针，检查是否重复
        int slow = 2, fast = 2;
        while (fast < l) {
            // 发现重复，交换位置
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
