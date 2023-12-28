package leetcode.slidingWindow.lengthOfLongestSubstring;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0,r = 0;
        HashSet<Character> set = new HashSet<>();
        char []chars = s.toCharArray();
        int length = 0;
        while(r < s.length()){
            // 不存在重复字符
            if(!set.contains(chars[r])){
                // 字符加入set集合
                set.add(chars[r]);
                // 窗口扩大
                r++;
            }else { // 发现重复元素
                // 比较最大长度
                length = Math.max(length,set.size());
                
                // 窗口缩小，set集合中元素移出
                while(chars[l] != chars[r]){
                    set.remove(chars[l]);
                    l++;
                }
                // 当前元素是重复元素，向下移动一位
                l++;
                r++;
            }
        }
        return length;
    }
}

class Main{
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = new Solution().lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}