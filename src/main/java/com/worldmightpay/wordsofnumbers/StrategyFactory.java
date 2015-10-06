package com.worldmightpay.wordsofnumbers;

import com.worldmightpay.wordsofnumbers.util.MathConversionUtil;

/**
 * Created by gdibella on 06/10/15.
 */
public class StrategyFactory {

    public static NumberTextStrategy  retrieveNumberStrategy(long number){
        NumberTextStrategy numberTextStrategy = null;
       int exp =  MathConversionUtil.getExpValue(number);

       switch (exp) {

           case 1:
               numberTextStrategy= new Power1Strategy();
           break;
           case 2:
               numberTextStrategy= new Power2Strategy();
               break;
           case 3:
               numberTextStrategy= new Power3Strategy();
               break;
           case 4:
               numberTextStrategy= new Power4Strategy();
               break;
           case 5:
               numberTextStrategy= new Power5Strategy();
               break;
           case 6:
               numberTextStrategy= new Power6Strategy();
               break;
           case 7:
               numberTextStrategy= new Power7Strategy();
               break;
           case 8:
               numberTextStrategy= new Power8Strategy();
               break;
       }
        return numberTextStrategy;
    }
}
