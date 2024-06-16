package com.example.summerpublicapi.utils;

public class StringUtils {
    /**
     * 判断传入的值是否为空，包括null，空字符串
     * null "","     "
     * @param value
     * @return
     */
    public static boolean isEmpty(String value){
        if(value == null || value == ""){
            return true;
        }else{
            if(value.trim().length() == 0){
                return true;
            }else {
                return false;
            }
        }

    }

}
