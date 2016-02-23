package com.aadira.library.Enums;

/**
 * Created by kumardivyarajat on 22/02/16.
 */
public enum SigningMethod {
    HMACSHA1("HMAC-SHA1"), HMACSHA256("HMAC-SHA256");

    String val;

    SigningMethod(String s) {
        val = s;
    }

    public String getVal() {
        return val;
    }
}
