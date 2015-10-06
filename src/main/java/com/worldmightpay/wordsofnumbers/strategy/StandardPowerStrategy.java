package com.worldmightpay.wordsofnumbers.strategy;

import com.worldmightpay.wordsofnumbers.BaseNumbers;
import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class StandardPowerStrategy implements NumberTextStrategy {

    private int expValue;
    private String descriptor;

    public StandardPowerStrategy(String descriptor, int expValue) {
        this.expValue = expValue;
        this.descriptor = descriptor;
    }


    public String extractWordNum(String wordNum, Long number) {
        String dlm = " ";
        String sep = " and ";

        int calcModule = MathConversionUtil.extractBaseExp(10, expValue - 1);
        int firstDigit = Long.valueOf(number / calcModule).intValue();
        BaseNumbers baseNumbers = BaseNumbers.findFromNum(firstDigit);
        String strFirstDigit = baseNumbers.toString().toLowerCase();
        wordNum += dlm + strFirstDigit + dlm + descriptor;
        return wordNum;
    }
}
