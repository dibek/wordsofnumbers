package com.worldmightpay.wordsofnumbers; /**
 * Created by gdibella on 06/10/15.
 */

    /**
     * Enum to retrieve basic numbers
     */
    public enum BaseNumbers {

        ZERO(0),
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
        SEVENTY(70),
        EIGHTY(80),
        NINETY(90),
        NOTFOUND(0);

        public int getNum() {
            return num;
        }

        int num;


        BaseNumbers(int num) {
            this.num = num;

        }

        /**
         * Find the enum from the value
         *
         * @param num
         * @return
         */
        public static BaseNumbers findFromNum(int num) {
            BaseNumbers tensNumbers = NOTFOUND;
            for (BaseNumbers tensNumbersItem : BaseNumbers.values()) {
                if (tensNumbersItem.getNum() == num) {
                    tensNumbers = tensNumbersItem;
                    break;
                }
            }
            return tensNumbers;
        }
    }

