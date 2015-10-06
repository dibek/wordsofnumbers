package com.worldmightpay.wordsofnumbers.strategy;

import com.worldmightpay.wordsofnumbers.BaseNumbers;
import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class Power1Strategy implements NumberTextStrategy {


    public static int expValue = 1;


    public String extractWordNum(String wordNum, Long number) {

        String dlm = " ";
        String sep = " and ";

        int calcModule = MathConversionUtil.extractBaseExp(10, expValue - 1);
        int firstDigit = Long.valueOf(number / calcModule).intValue();
        BaseNumbers baseNumbers = BaseNumbers.findFromNum(firstDigit);
        String strFirstDigit = baseNumbers.toString().toLowerCase();
        baseNumbers = BaseNumbers.findFromNum(number.intValue());
        if (baseNumbers.equals(BaseNumbers.NOTFOUND)) {
            baseNumbers = BaseNumbers.findFromNum(Integer.valueOf(firstDigit + "0"));
        }
        if (!wordNum.equals("")) {
            wordNum += sep;
        }
        wordNum += baseNumbers.name().toLowerCase();
        if (number.intValue() - baseNumbers.getNum() > 0) {
            String strSecondDigit = BaseNumbers.findFromNum(number.intValue() - baseNumbers.getNum()).toString().toLowerCase();
            wordNum += dlm + strSecondDigit;
        }
        return wordNum;
    }
}
