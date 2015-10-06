package com.worldmightpay.wordsofnumbers;

import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Hello words of numbers!
 */
public class WordsOfNumbers implements NumberTransformer {


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

        String wordNum = extractWordNum("", number, exp);

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
                    newExpValue = MathConversionUtil.getExpValue(newNum);
                    if (exp - newExpValue > 1) {
                        wordNum = extractWordNum(wordNum, newNum, newExpValue);
                    } else if (newExpValue > 0) {
                        wordNum = extractWordNum(wordNum, newNum, newExpValue);
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

    /**
     * Convert a number to its string representation adding eventually to an existing string
     *
     * @param wordNum  The original string
     * @param number   The number to transform
     * @param expValue The exp value of the number
     * @return The new string representing the number
     */
    private static String extractWordNum(String wordNum, Long number, int expValue) {


        String dlm = " ";
        String sep = " and ";

        int calcModule = MathConversionUtil.extractBaseExp(10, expValue - 1);
        int firstDigit = Long.valueOf(number / calcModule).intValue();
        BaseNumbers baseNumbers = BaseNumbers.findFromNum(firstDigit);
        String strFirstDigit = baseNumbers.toString().toLowerCase();
        switch (expValue) {

            case 1:
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
                break;
            case 2:
                wordNum += dlm + strFirstDigit + dlm + "hundred";
                break;
            case 3:
                if (!wordNum.equals("")) {
                    wordNum += sep;
                }
                wordNum += strFirstDigit + dlm + "thousand";
                break;
            case 4:

                if (!wordNum.equals("")) {
                    wordNum += sep;
                }
                calcModule = MathConversionUtil.extractBaseExp(10, expValue - 2);
                firstDigit = Long.valueOf(number / calcModule).intValue();
                Long newFirstDigitsNum = Long.valueOf(firstDigit);
                strFirstDigit = extractWordNum("", newFirstDigitsNum, MathConversionUtil.getExpValue(newFirstDigitsNum));
                wordNum += strFirstDigit + dlm + "thousand";
                break;
            case 5:
                //wordNum = "hundred";
                wordNum += dlm + strFirstDigit + dlm + "hundred";
                break;
            case 6:
                //wordNum = "million";
                wordNum += dlm + strFirstDigit + dlm + "million";
                break;
            case 7:
                if (!wordNum.equals("")) {
                    wordNum += sep;
                }
                calcModule = MathConversionUtil.extractBaseExp(10, expValue - 2);
                firstDigit = Long.valueOf(number / calcModule).intValue();
                newFirstDigitsNum = Long.valueOf(firstDigit);
                strFirstDigit = extractWordNum("", newFirstDigitsNum, MathConversionUtil.getExpValue(newFirstDigitsNum));
                wordNum += strFirstDigit + dlm + "million";
                break;
            case 8:
                wordNum += dlm + strFirstDigit + dlm + "hundred";
                break;
            case 9:
                wordNum += strFirstDigit + dlm + "billion";
                break;
            default:
                if (!wordNum.equals("")) {
                    wordNum += sep;
                }
                baseNumbers = BaseNumbers.findFromNum(number.intValue());
                wordNum += baseNumbers.name().toLowerCase();
        }

        return wordNum;
    }



}
