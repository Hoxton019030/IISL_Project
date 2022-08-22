package com.example.iisl_project.exception;

import com.example.iisl_project.util.ExceptionUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException  extends RuntimeException {

    private String errorCode;

    private String errorMsg;

    public BaseException() {
    }

    protected BaseException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return ExceptionUtil.getFormattedMessage(errorCode, errorMsg);
    }
}
