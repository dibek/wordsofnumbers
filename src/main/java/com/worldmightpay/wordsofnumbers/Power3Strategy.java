package com.worldmightpay.wordsofnumbers;

import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class Power3Strategy implements NumberTextStrategy{


    private static final int EXP_VALUE = 3;

    public String extractWordNum(String wordNum, Long number) {
        String dlm = " ";
        String sep = " and ";

        int calcModule = MathConversionUtil.extractBaseExp(10, EXP_VALUE - 1);
        int firstDigit = Long.valueOf(number / calcModule).intValue();
        BaseNumbers baseNumbers = BaseNumbers.findFromNum(firstDigit);
        String strFirstDigit = baseNumbers.toString().toLowerCase();
        if (!wordNum.equals("")) {
            wordNum += sep;
        }
        wordNum += strFirstDigit + dlm + "thousand";
        return wordNum;
    }
}
