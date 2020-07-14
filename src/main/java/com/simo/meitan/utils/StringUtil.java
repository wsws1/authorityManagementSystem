package com.simo.meitan.utils;

public class StringUtil {
    public static boolean notNULLString(String string){
        if (string==null||string.equals("")){
            return false;
        }
        return true;
    }
}
