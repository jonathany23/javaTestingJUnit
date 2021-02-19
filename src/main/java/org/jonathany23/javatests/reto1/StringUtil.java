package org.jonathany23.javatests.reto1;

public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() > 0 ){
            return false;
        } else {
            return true;
        }
    }
}
