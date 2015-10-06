package com.worldmightpay.wordsofnumbers.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by gdibella on 06/10/15.
 */
public class MathConversionUtil {
    public static int extractBaseExp(int num, int expValue) {
        int baseExp = num;
        for (int i = 0; i < expValue; i++) {
            baseExp *= num;
        }
        return baseExp;
    }

    /**
     * Extract the power in base 10 of the number
     *
     * @param number
     * @return
     */
    public static Integer getExpValue(Long number) {
        NumberFormat formatter = new DecimalFormat("0E0");
        String expNumber = formatter.format(number);
        int indexE = expNumber.indexOf("E");
        String expFound = expNumber.substring(indexE + 1);
        return Integer.valueOf(expFound);
    }
}
