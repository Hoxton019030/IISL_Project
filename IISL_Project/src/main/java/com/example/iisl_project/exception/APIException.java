package com.example.iisl_project.exception;

import com.example.iisl_project.eums.ReturnCodeConst;
import com.example.iisl_project.util.ExceptionUtil;
import lombok.Data;

import java.text.MessageFormat;

@Data
public class APIException extends BaseException {

    private APIException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    private APIException(ReturnCodeConst returnCodeConst) {
        this(returnCodeConst.getReturnCode(), returnCodeConst.getReturnMsg());
    }

    private APIException(ReturnCodeConst returnCodeConst, Object[] msgArgs) {
        this(returnCodeConst.getReturnCode(), MessageFormat.format(returnCodeConst.getReturnMsg(), msgArgs));
    }

    public static APIException createAPIException(ReturnCodeConst returnCodeConst) {
        return new APIException(returnCodeConst);
    }

    public static APIException createAPIException(String errorCode, String errorMsg) {
        return new APIException(errorCode, errorMsg);
    }

    public static APIException createAPIException(ReturnCodeConst returnCodeConst, Object[] msgArgs) {
        return new APIException(returnCodeConst, msgArgs);
    }

    public static APIException createAPIException(
            ReturnCodeConst returnCodeConst, String... dynamicValue) {
        return new APIException(returnCodeConst, dynamicValue);
    }

    @Override
    public String getMessage() {
        return ExceptionUtil.getFormattedMessage(getErrorCode(), getErrorMsg());
    }
}
