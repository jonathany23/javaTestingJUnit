package org.jonathany23.javatests.reto2;

public class RomanNumerals {

    public static String arabicToRoman(int n) {
        String strNumber = String.valueOf(n);
        String romanNumber = "";
        int lengthNumber = strNumber.length();
        int repeat = 0;

        for (int i = 0; i < strNumber.length(); i++) {
            if(lengthNumber == 1){
                if (n >= 1 && n <=3){
                    romanNumber += getRoman(n, "I");
                    return romanNumber;
                } else if (n >= 5 && n <= 8){
                    romanNumber += "V";
                    repeat = n % 5;
                    if (repeat > 0) {
                        romanNumber += getRoman(repeat, "I");
                    }
                    return romanNumber;
                }
            } else if (lengthNumber == 2){
                if (n >= 10 && n <= 38){
                    repeat = n / 10;
                    romanNumber += getRoman(repeat, "X");
                } else if (n >= 50){
                    romanNumber += "L";

                    if (n >= 60 && n <= 88){
                        repeat = (n - 50) / 10;
                        romanNumber += getRoman(repeat, "X");
                    }
                }

                lengthNumber--;
                n = Integer.parseInt(strNumber.substring(strNumber.length()-1));
            } else if (lengthNumber == 3){
                if (n >= 100){
                    romanNumber += "C";
                }
                n = Integer.parseInt(strNumber.substring(1,strNumber.length()));
                lengthNumber = String.valueOf(n).length();
            }
        }
        return romanNumber;
    }

    private static String getRoman(int n, String roman) {
        String romanNumber = "";
        for (int i = 0; i < n; i++) {
            romanNumber += roman;
        }
        return romanNumber;
    }
}
