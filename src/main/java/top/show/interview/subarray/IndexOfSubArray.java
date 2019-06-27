package top.show.interview.subarray;

import java.util.Arrays;

/**
 * description :ATP面试
 * 题目：给定一个数组a和一个子数组b，找到这个子数组a在b中最后出现的位置，如果没有返回-1
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-26 下午9:43
 */
public class IndexOfSubArray {
    /**
     * 找b在a出现的最后位置
     * @param a 数组a
     * @param b 数组b
     * @return b在a出现的最后位置
     */
    public static int sub(int[] a, int[] b) {
        if (a == null || a.length <= 0) {
            throw new RuntimeException("非法参数");
        }
        if (b == null || b.length <= 0) {
            return -1;
        }
        String str1 = Arrays.toString(a);
        String str2 = Arrays.toString(b);
        String substring = str1.substring(1, str1.length() - 1);
        String replaceAll = substring.replaceAll(" ", "");
        String substring1 = str2.substring(1, str2.length() - 1);
        String replaceAll1 = substring1.replaceAll(" ", "");
        int lastIndexOf = replaceAll.lastIndexOf(replaceAll1);
        return lastIndexOf < 0 ? lastIndexOf : lastIndexOf / 2;
    }


    public static void main(String[] args) {
        System.out.println(sub(new int[]{4, 5, 6, 7, 5, 6, 8}, new int[]{5, 6}));
        System.out.println(sub(new int[]{6, 7, 5, 3, 1, 3, 5}, new int[]{0}));
        System.out.println(sub(new int[]{6, 7, 5, 3, 1, 3, 5}, new int[]{1}));

    }
}
