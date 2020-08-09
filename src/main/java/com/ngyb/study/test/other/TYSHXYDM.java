package com.ngyb.study.test.other;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:11
 */
public class TYSHXYDM {
    public static void main(String[] args) {
        String tyshxydm = "[0-9A-HJ-NPQRTUWXY]{2}\\d{6}[0-9A-HJ-NPQRTUWXY]{10}";
        String code = "91350100M000100Y43";
        System.out.println(code.matches(tyshxydm));
    }


    public static String precision(String number, int places) {
        int a = radix(number);//判断位数
        if (a <= places) {//当前小数点不满要修约的位数
            return setPrecision(Double.parseDouble(number), places);
        } else {
            String ber = setPlaces(number, places + 1);
            int last = Integer.parseInt(ber.substring(ber.length() - 1));
            if (last > 5) {//四舍大五入
                return setStr(number, places);
            } else if (last < 5) {//全舍
                return setPlaces(number, places);
            } else {//等于5
                //如果小数点位数与要截取的小，先补位，再截取。
                String fnumber = setPrecision(Double.parseDouble(number), places + 2);
                String mber = setPlaces(fnumber, places + 2);
                int last2 = Integer.parseInt(mber.substring(mber.length() - 1));
                if (last2 != 0) {//不等于0，全进
                    return setStr(number, places);
                } else {//等于0，奇进偶不进
                    String mber2 = setPlaces(fnumber, places);//截取小数位
                    int last3 = Integer.parseInt(mber2.substring(mber2.length() - 1));
                    if (last3 % 2 == 1) {//奇数
                        return setStr(number, places);
                    } else {
                        return setPlaces(number, places);
                    }
                }
            }
        }
    }

    /**
     * 判断有几位小数点
     * TODO小数点个数
     *
     * @param number
     * @return
     */
    public static int radix(String number) {
        int bitPos = number.indexOf(".");
        int numOfBits = number.length() - bitPos - 1;
        return numOfBits;
    }

    /**
     * 数值右补位 (当要显示的小数点不满足要截取的位数时，先补位，再截取)
     *
     * @param number 要补位的数字
     * @param places 小数点总位数
     * @return
     */
    private static String setPrecision(Double number, int places) {
        //待测试数据
        // Double i = 0.1;
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        // nf.setMaximumIntegerDigits(4);
        //设置最小整数位数
        // nf.setMinimumIntegerDigits(4);
        nf.setMaximumFractionDigits(places);
        nf.setMinimumFractionDigits(places);
        return nf.format(number);
    }

    /**
     * 保留小数点 不进位
     *
     * @param number
     * @param places 位数
     * @return
     */
    private static String setPlaces(String number, int places) {
        BigDecimal bd = new BigDecimal(number);
        String v = bd.setScale(places, BigDecimal.ROUND_DOWN).toString();
        return v;
    }

    /**
     * 保留小数点，进位，四舍五入
     *
     * @param number
     * @param places
     * @return
     */
    private static String setStr(String number, int places) {
        BigDecimal bd = new BigDecimal(number);
        String v = bd.setScale(places, BigDecimal.ROUND_HALF_UP).toString();
        return v;
    }
}
