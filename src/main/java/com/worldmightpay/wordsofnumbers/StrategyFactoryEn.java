package com.worldmightpay.wordsofnumbers;

import com.worldmightpay.wordsofnumbers.strategy.*;
import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class StrategyFactoryEn implements StrategyFactory {

    public static NumberTextStrategy retrieveNumberStrategy(long number){
        NumberTextStrategy numberTextStrategy = null;
       int exp =  MathConversionUtil.getExpValue(number);

       switch (exp) {

           case 1:
               numberTextStrategy= new Power1Strategy();
           break;
           case 2:
               numberTextStrategy= new StandardPowerStrategy("hundred",2);
               break;
           case 3:
               numberTextStrategy= new StandardPowerStrategy("thousand",3);
               break;
           case 4:
               numberTextStrategy= new FirstDigitPowerStrategy("thousand",4);
               break;
           case 5:
               numberTextStrategy= new StandardPowerStrategy("hundred",5);
               break;
           case 6:
               numberTextStrategy= new StandardPowerStrategy("million",6);
               break;
           case 7:
               numberTextStrategy= new FirstDigitPowerStrategy("million",7);
               break;
           case 8:
               numberTextStrategy= new StandardPowerStrategy("hundred",8);
               break;
           default:
               numberTextStrategy= new Power0Strategy();
               break;
       }
        return numberTextStrategy;
    }
}
