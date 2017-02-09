package com.example.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by liubo16 on 2017/2/9.
 */
public class CommonUtils {
    /**
     * 手机号码校验
     * @param phone
     * @return
     */
    public static boolean validatePhone(String phone) {
        return isMainlandPhone(phone) || isMainlandPhone(phone);
    }

    private static boolean isMainlandPhone(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private static boolean isHKPhone(String str) throws PatternSyntaxException {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
