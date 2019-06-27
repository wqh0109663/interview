package top.show.interview.addbigdata;


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 大数据相加，ATP面试
 * 要求：不能使用BigInteger和BigDecimal等工具类
 * example:2.445463423254543435 + 56.563423422362723423235
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-6-27 上午11:37
 * @see BigDecimal
 * @see BigInteger
 */
public class AddBigDataWithoutUtils {
    /**
     * 大数据相加
     *
     * @param a 参数
     * @param b 参数
     * @return 相加后的结果
     */
    public static String add(String a, String b) {
        String pointer = ".";
        if (a.indexOf(pointer) > 0 && b.indexOf(pointer) > 0) {
            String subA = a.substring(a.indexOf(pointer) + 1);
            String subB = b.substring(b.indexOf(pointer) + 1);
            int subLengthA = subA.length();
            int subLengthB = subB.length();
            StringBuilder sbA = new StringBuilder(subA);
            StringBuilder sbB = new StringBuilder(subB);
            if (subLengthA > subLengthB) {
                for (int i = 0; i < subLengthA - subLengthB; i++) {
                    sbB.append("0");
                }
            } else {
                for (int i = 0; i < subLengthB - subLengthA; i++) {
                    sbA.append("0");
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            boolean overTen = false;
            for (int i = sbA.length() - 1; i > 0; i--) {
                if (subA.charAt(i) == '.') {
                    stringBuilder.append(".");
                    continue;
                }
                int temp = Character.getNumericValue(subA.charAt(i)) + Character.getNumericValue(subB.charAt(i));
                if (overTen) {
                    temp += 1;
                }
                if (temp >= 10) {
                    stringBuilder.append(String.valueOf(temp).substring(1));
                    overTen = true;
                } else {
                    stringBuilder.append(temp + "");
                    overTen = false;
                }

            }
            return stringBuilder.toString();

        }


        return null;
    }

    public static void main(String[] args) {
        System.out.println(add("3.4353535324234252352342", "4.646343"));


    }


}
