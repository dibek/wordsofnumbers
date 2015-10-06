package com.worldmightpay.wordsofnumbers.strategy;

import com.worldmightpay.wordsofnumbers.BaseNumbers;

/**
 * Created by gdibella on 06/10/15.
 */
public class Power0Strategy implements NumberTextStrategy {


    public static int expValue = 1;


    public String extractWordNum(String wordNum, Long number) {

        String dlm = " ";
        String sep = " and ";

        if (!wordNum.equals("")) {
            wordNum += sep;
        }
        BaseNumbers baseNumbers = BaseNumbers.findFromNum(number.intValue());
        wordNum += baseNumbers.name().toLowerCase();
        return wordNum;
    }
}
