package com.example.iisl_project.controller.model.request;


import com.example.iisl_project.controller.model.request.base.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LoginReq  extends Request {

    /**
     * 帳號
     */
    @NotBlank(message ="Id Can't be blank" ) //不得為空
    @Length(max = 20,message = "over size") //限制長度
    @Pattern(regexp ="^[A-Za-z0-9]*$",message = "...") //符合此格式才可以
    private String idNo;


    /**
     *需額外用JsonProperty設置別名，不然用lombok會是pcode，會導致Spring bean賦值失敗
     */
    @NotBlank(message = "password shouldn't be empty")
    @Length(max=500)
    @JsonProperty(value = "pCode")
    private String pCode;
}
