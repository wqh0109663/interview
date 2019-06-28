package top.show.interview.addbigdata;


import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 大数据相加，ATP面试
 * 要求：不能使用BigInteger和BigDecimal等工具类
 * example:2.445463423254543435 + 56.563423422362723423235
 * 思路：将位数搞成一致，逐位相加
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
        StringBuilder sb = new StringBuilder(a);
        StringBuilder sb1 = new StringBuilder(b);
        boolean havePointer = false;
        /*
         * 判断是否有小数点
         */
        String pointer = ".";
        if (sb.indexOf(pointer) > 0) {
            if (sb1.indexOf(pointer) < 0) {
                sb1.append(pointer);
            }
            //如果有小数点
            havePointer = true;
        } else if (sb1.indexOf(pointer) > 0) {
            if (sb.indexOf(pointer) < 0) {
                sb.append(pointer);
            }
            //如果有小数点
            havePointer = true;
        }
        if (havePointer) {
            //尾部添加0
            int len = sb.substring(sb.indexOf(pointer)).length()
                    - sb1.substring(sb1.indexOf(pointer)).length();
            if (len > 0) {
                for (int i = 0; i < len; i++) {
                    sb1.append("0");
                }
            } else {
                for (int i = 0; i < Math.abs(len); i++) {
                    sb.append("0");
                }
            }
            // 小数点前面加0
            int length = sb.substring(0, sb.indexOf(pointer)).length()
                    - sb1.substring(0, sb1.indexOf(pointer)).length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    sb1.insert(0, "0");
                }
            } else {
                for (int i = 0; i < Math.abs(length); i++) {
                    sb.insert(0, "0");
                }
            }
        } else {
            // 如果没有小数点
            if (sb.length() > sb1.length()) {
                for (int i = 0; i < sb.length() - sb1.length(); i++) {
                    sb1.insert(0, "0");
                }
            } else if (sb.length() < sb1.length()) {
                for (int i = 0; i < sb1.length() - sb.length(); i++) {
                    sb.insert(0, "0");
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean overTen = false;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '.') {
                stringBuilder.append(".");
                continue;
            }
            int temp = Character.getNumericValue(sb.charAt(i)) + Character.getNumericValue(sb1.charAt(i));
            if (overTen) {
                temp += 1;
            }
            if (temp >= 10) {
                stringBuilder.append(String.valueOf(temp).substring(1));
                overTen = true;
            } else {
                stringBuilder.append(temp);
                overTen = false;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("3.4353535324234252352342", "4.646343"));
        System.out.println(add("3435353532523","1111111111119"));
        System.out.println(add("23423.62324234","1111111111111"));

    }


}
