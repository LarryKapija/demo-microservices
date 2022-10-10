package com.demo.op.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {
    public String cleanPhoneNumber(String phoneNumber) {
        if(phoneNumber==null || phoneNumber.isEmpty())
            return null;

        return phoneNumber.replace("-","")
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "");
    }
}
