package leetcode.arrayOrString.majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/11/29 20:55
 */
public class Solution {
    /* 解法1 借助HashMap */
    public int majorityElement01(int[] nums) {
        int n = nums.length;
        // 如果只有一个元素，返回就可以了
        if(n == 1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int maxNum = 0;
        for(int num: nums){

            if(map.isEmpty()){  // 初始化maxNum
                maxNum = num;
            }
            if(map.containsKey(num)){   // 检查出现次数
                int repeatNum = map.get(num) + 1;
                if(repeatNum > n / 2){  // 满足条件，返回
                    return num;
                }
                map.put(num,repeatNum);
            }else {
                map.put(num,1);
            }

            if(map.get(num) >= map.get(maxNum)) {   // 比较
                maxNum = num;
            }
        }
        return maxNum;
    }
}
