package com.worldmightpay.wordsofnumbers;

import com.worldmightpay.wordsofnumbers.strategy.NumberTextStrategy;
import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class NumberTransformerImpl implements NumberTransformer {
    /**
     * A method to transform a number to its string value
     *
     * @param number
     * @return The string representation of the number
     */
    public String transform(Long number) {

        String dlm = " and ";
        if (number < 21) {
            return BaseNumbers.findFromNum(number.intValue()).name().toLowerCase();
        }
        Integer exp = MathConversionUtil.getExpValue(number);

        NumberTextStrategy numberTextStrategy = StrategyFactoryEn.retrieveNumberStrategy(number);
        String wordNum = numberTextStrategy.extractWordNum("", number);

        String plainNumber = String.valueOf(number);
        int i = 1;
        if (exp == 7 || exp == 4) {
            i = 2;
        }
        plainNumber = plainNumber.substring(i);
        zeroVal:
        while (plainNumber.length() > 0) {

            Long newNum = Long.valueOf(plainNumber);
            Integer newExpValue = MathConversionUtil.getExpValue(newNum);

            if (plainNumber.startsWith("0")) {
                plainNumber = plainNumber.substring(i);
                continue zeroVal;
            } else {

                if (plainNumber.length() > 0) {

                    newNum = Long.valueOf(plainNumber);
                    numberTextStrategy = StrategyFactoryEn.retrieveNumberStrategy(newNum);
                    newExpValue = MathConversionUtil.getExpValue(newNum);
                    if (exp - newExpValue > 1) {
                        wordNum = numberTextStrategy.extractWordNum(wordNum, newNum);
                    } else if (newExpValue > 0) {
                        wordNum = numberTextStrategy.extractWordNum(wordNum, newNum);
                    }

                    exp = MathConversionUtil.getExpValue(newNum);
                }
            }
            i = 1;
            if (exp == 7 || exp == 4) {
                i = 2;
            }
            plainNumber = plainNumber.substring(i);
        }

        System.out.println("number:" + number + " becomes  = " + wordNum);

        return wordNum;
    }
}
