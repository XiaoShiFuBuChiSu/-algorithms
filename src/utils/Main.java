package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/27 13:56
 */
public class Main {
    public static void main(String[] args) {
        Consumer<List> consumer = list -> list.forEach(o-> System.out.println(o));
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = ArrayUtils.generateIntArray(10, 20);
        for (int num : nums) {
            list.add(num);
        }

        consumer.accept(list);
    }
}
