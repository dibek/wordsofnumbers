package com.worldmightpay.wordsofnumbers.strategy;

import com.worldmightpay.wordsofnumbers.StrategyFactoryEn;
import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class FirstDigitPowerStrategy implements NumberTextStrategy {
    private int expValue;
    private String descriptor;

    public FirstDigitPowerStrategy(String descriptor,int expValue) {
        this.expValue = expValue;
        this.descriptor = descriptor;
    }


    public String extractWordNum(String wordNum, Long number) {


        String dlm = " ";
        String sep = " and ";
         if (!wordNum.equals("")) {
            wordNum += sep;
        }
        int calcModule = MathConversionUtil.extractBaseExp(10, expValue - 2);
        int firstDigit = Long.valueOf(number / calcModule).intValue();
        Long newFirstDigitsNum = Long.valueOf(firstDigit);
        NumberTextStrategy numberTextStrategy = StrategyFactoryEn.retrieveNumberStrategy(newFirstDigitsNum);
        String strFirstDigit = numberTextStrategy.extractWordNum("", newFirstDigitsNum);
        wordNum += strFirstDigit + dlm + descriptor;
         return  wordNum;
    }
}
