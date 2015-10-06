package com.worldmightpay.wordsofnumbers;

import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class Power4Strategy implements NumberTextStrategy {

    private static final int EXP_VALUE = 4;
    public String extractWordNum(String wordNum, Long number) {

        String dlm = " ";
        String sep = " and ";
         if (!wordNum.equals("")) {
            wordNum += sep;
        }
        int calcModule = MathConversionUtil.extractBaseExp(10, EXP_VALUE - 2);
        int firstDigit = Long.valueOf(number / calcModule).intValue();
        Long newFirstDigitsNum = Long.valueOf(firstDigit);
        NumberTextStrategy numberTextStrategy = StrategyFactory.retrieveNumberStrategy(newFirstDigitsNum);
        String strFirstDigit = numberTextStrategy.extractWordNum("", newFirstDigitsNum);
        wordNum += strFirstDigit + dlm + "thousand";
         return  wordNum;
    }
}
