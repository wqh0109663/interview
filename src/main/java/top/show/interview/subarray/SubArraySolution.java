package top.show.interview.subarray;

/**
 * 优解,逐个匹配
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-29 下午3:06
 * @see IndexOfSubArray
 */
public class SubArraySolution {

    public static int lastIndexOfSubArray(int[] full, int[] sub) {
        /*
         * 处理特殊情况
         */
        if (full == null || sub == null) {
            return -1;
        }
        if (full.length < sub.length) {
            return -1;
        }
        int lastIndexOf = -1;
        for (int i = 0; i < full.length; i++) {
            boolean b = in(full, sub, i);
            if (b) {
                lastIndexOf = i;
            }
        }
        return lastIndexOf;
    }

    private static boolean in(int[] full, int[] sub, int index) {
        for (int i = 0; i < sub.length; i++) {
            if (full[index + i] != sub[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(lastIndexOfSubArray(new int[]{4, 5, 6, 7, 5, 6, 8}, new int[]{5, 6}));
        System.out.println(lastIndexOfSubArray(new int[]{6, 7, 5, 3, 1, 3, 5}, new int[]{0}));
        System.out.println(lastIndexOfSubArray(new int[]{6, 7, 5, 3, 1, 3, 5}, new int[]{1}));

    }
}
