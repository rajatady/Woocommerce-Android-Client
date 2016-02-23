package com.aadira.library.Enums;

/**
 * Created by kumardivyarajat on 22/02/16.
 */
public enum RequestMethod {
    GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE"), HEAD("HEAD");

    String val;

    RequestMethod(String s) {
        val = s;
    }

    public String getVal() {
        return val;
    }
}
