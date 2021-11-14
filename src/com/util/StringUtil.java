package com.util;

public class StringUtil {
    public static String fillString(String filling, String input, int length){
        if(length > input.length()){
            return String.valueOf(filling).repeat(Math.max(0, (length - input.length()))) + input;
        }else{
            return input;
        }
    }
    public static int diffString(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int c = 0;
        int max = Math.max(str1.length(), str2.length());
        if(max != length){
            c = max - length;
        }
        for(int i = 0; i < length; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                c++;
            }
        }
        return c;
    }
    public static int countChar(String str, char cmp){
        int c = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == cmp){
                c++;
            }
        }
        return c;
    }
}
