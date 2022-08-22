package com.example.iisl_project.util;

import com.example.iisl_project.eums.ReturnCodeConst;
import org.apache.commons.lang3.StringUtils;

public class ExceptionUtil {

    private static final int MAX_BODY_LENGTH = 5000;
    private static final int BUFFER_CAPACITY = 10000;
    public static String getFormattedMessage(ReturnCodeConst returnCodeConst){
        StringBuilder stringBuilder = new StringBuilder(returnCodeConst.getReturnMsg());
        stringBuilder.append("(");
        if (StringUtils.length(returnCodeConst.getReturnCode()) <= MAX_BODY_LENGTH) {
            stringBuilder.append(returnCodeConst.getReturnCode());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
    public static String getFormattedMessage(String returnCode, String returnMsg){
        StringBuilder stringBuilder = new StringBuilder(returnMsg);
        stringBuilder.append("(");
        if (StringUtils.length(returnCode) <= MAX_BODY_LENGTH) {
            stringBuilder.append(returnCode);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
