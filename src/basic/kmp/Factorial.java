package basic.kmp;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/23 15:39
 */
public class Factorial {
    public static void main(String[] args) {
        int total = myFactorial(10);
        System.out.println("total = " + total);
    }

    public static int myFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * myFactorial(num - 1);
    }
}

interface aaa {
    void asdfasdf();
}
