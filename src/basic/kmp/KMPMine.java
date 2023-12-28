package basic.kmp;

/**
 * @Description TODO
 * @Author 王俊然
 * @Date 2023/12/21 16:02
 */
public class KMPMine {

    public static void main(String[] args) {
        String source = "1324687123";
        String target = "687";
        System.out.println(kmp(source, target));
    }

    public static int kmp(String source, String target) {
        int[] next = kmpNext(target);

        for (int i = 0, j = 0; i < target.length(); i++) {

            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }

            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }

            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }

    public static int[] kmpNext(String target) {
        int[] next = new int[target.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < target.length(); i++) {
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
