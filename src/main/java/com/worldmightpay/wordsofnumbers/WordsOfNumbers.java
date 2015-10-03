package com.worldmightpay.wordsofnumbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello words of numbers!
 */
public class WordsOfNumbers {

    public enum BaseNumbers {

        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        ELEVEN(11),
        TWELVE(12),
        THIRTEEN(13),
        FOURTEEN(14),
        FIFTEEN(15),
        SIXTEEN(16),
        SEVENTEEN(17),
        EIGHTEEN(18),
        NINETEEN(19),
        TWENTY(20),
        THIRTY(30),
        FORTY(40),
        FIFTY(50),
        SIXTY(60),
        SEVENTY(70) ,
        EIGHTY(80),
        NINETY(90),
        NOTFOUND(0)
        ;

        public int getNum() {
            return num;
        }

        int num;


        BaseNumbers(int num) {
            this.num = num;

        }
        public static BaseNumbers findFromNum(int num) {
            BaseNumbers tensNumbers = NOTFOUND;
            for (BaseNumbers tensNumbersItem: BaseNumbers.values()){
                if (tensNumbersItem.getNum() == num) {
                    tensNumbers = tensNumbersItem;
                    break;
                }
            }
            return tensNumbers;
        }
    }

    public static String transform(Long number) {
        if (number < 21){
            return BaseNumbers.findFromNum(number.intValue()).name().toLowerCase();
        }
        Integer exp = getExpValue(number);

        String wordNum = extractWordNum(number, exp);
        String plainNumber = String.valueOf(number);
        int i = 1;

        zeroVal:
        while (plainNumber.length() > 0) {
            plainNumber = plainNumber.substring(i);
            if (plainNumber.startsWith("0")) {
                continue zeroVal;
            } else {
                if (plainNumber.length() > 0) {
                    Long newNum = Long.valueOf(plainNumber);
                    Integer newExpValue = getExpValue(newNum);
                    if (exp - newExpValue > 1) {
                        wordNum += " and " + extractWordNum(newNum,newExpValue);
                    } else {
                        wordNum += " " + extractWordNum(newNum,newExpValue);
                    }
                    exp = getExpValue(newNum);
                }
            }

        }

        System.out.println("number:" + number + " becomes  = " + wordNum);
        return null;
    }

    private static String extractWordNum(Long number, int expValue) {

        String wordNum = "";
        String dlm = " ";
        int calcModule = extractBaseExp(10,expValue-1);
        int firstDigit = Long.valueOf(number/ calcModule).intValue();
        BaseNumbers baseNumbers = BaseNumbers.findFromNum(firstDigit);
        String strFirstDigit = baseNumbers.toString().toLowerCase();
        switch (expValue) {

            case 1:
                baseNumbers = BaseNumbers.findFromNum(number.intValue());
                if (baseNumbers.equals(BaseNumbers.NOTFOUND)) {
                    baseNumbers = BaseNumbers.findFromNum(Integer.valueOf(firstDigit + "0"));
                }
                wordNum = baseNumbers.name().toLowerCase();
                if (number.intValue()-baseNumbers.getNum() > 0) {
                    String strSecondDigit = BaseNumbers.findFromNum(number.intValue() - baseNumbers.getNum() ).toString().toLowerCase();
                    wordNum+= dlm + strSecondDigit;
                }
                break;
            case 2:
                wordNum =  "hundred";
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 3:
                wordNum = "thousand";
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 4:

                wordNum =  "thousand";
                calcModule = extractBaseExp(10,expValue-2);
                firstDigit = Long.valueOf(number/ calcModule).intValue();
                strFirstDigit = BaseNumbers.findFromNum(firstDigit).toString().toLowerCase();
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 5:
                wordNum = "hundred thousand";
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 6:
                wordNum = "million";
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 7:
                wordNum = "million";
                calcModule = extractBaseExp(10,expValue-2);
                firstDigit = Long.valueOf(number/ calcModule).intValue();
                strFirstDigit = BaseNumbers.findFromNum(firstDigit).toString().toLowerCase();
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 8:
                wordNum = "hundred million";
                wordNum = strFirstDigit + dlm + wordNum;
                break;
            case 9:
                wordNum = "thousand million";
                wordNum = strFirstDigit + dlm + wordNum;
                break;

        }

        return wordNum;
    }

    private static int extractBaseExp(int num, int expValue) {
        int baseExp = num;
        for (int i = 0 ;i< expValue;i++){
            baseExp*=  num;
        }
        return  baseExp;
    }


    private static Integer getExpValue(Long number) {
        NumberFormat formatter = new DecimalFormat("0E0");

        String expNumber = formatter.format(number);
        int indexE = expNumber.indexOf("E");

        String expFound = expNumber.substring(indexE + 1);
        return Integer.valueOf(expFound);
    }

    public static void main(String[] args) {
        System.out.println("Hello words of numbers!");
        WordsOfNumbers wordsOfNumbers = new WordsOfNumbers();
        wordsOfNumbers.transform(10l);
        wordsOfNumbers.transform(100l);
        wordsOfNumbers.transform(1010l);
        wordsOfNumbers.transform(10000l);
        wordsOfNumbers.transform(200000l);
        wordsOfNumbers.transform(1000000l);
        WordsOfNumbers.transform(40000000l);
        WordsOfNumbers.transform(100000000l);
        WordsOfNumbers.transform(1000000000l);
    }
}