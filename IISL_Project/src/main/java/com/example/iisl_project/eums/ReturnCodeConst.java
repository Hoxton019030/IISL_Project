package com.example.iisl_project.eums;

import com.example.iisl_project.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ReturnCodeConst {

    S0001("S0001")

    ,F0001("F0001")
    ,F0002("F0002")
    ,F0003("F0003")
    ,F0004("F0004")
    ,F0005("F0005")
    ,F0006("F0006")
    ,F0007("F0007")
    ,F0008("F0008")
    ,F0009("F0009")
    ,F0010("F0010")
    ,F0011("F0011")
    ,F0012("F0012")
    ,F0013("F0013")
    ,F0014("F0014")
    ,F0015("F0015")
    ,F0016("F0016")
    ,F0017("F0017")
    ,F0018("F0018")
    ,F0019("F0019")
    ,F0020("F0020")
    ,F0021("F0021")
    ,F0022("F0022")

    ,F0101("F0101")
    ,F0102("F0102")
    ,F0103("F0103")
    ,F0104("F0104")
    ,F0105("F0105")

    ;

    private final String returnCode;

    public static ReturnCodeConst getReturnCode(String rtnCode) {
        return Arrays.stream(ReturnCodeConst.values()).filter(r -> StringUtils.equals(r.getReturnCode(), rtnCode)).findAny().orElse(null);
    }

    public String getReturnMsg() {
        return MessageUtil.getMessageStatic("return.code." + this.name());
    }
}
