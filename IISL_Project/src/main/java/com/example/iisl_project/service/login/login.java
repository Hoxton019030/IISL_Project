package com.example.iisl_project.service.login;

import com.example.iisl_project.controller.model.request.LoginReq;
import com.example.iisl_project.service.RsaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class login {

    @Autowired
    private RsaService rsaService;

    @Autowired
    private UserCipherService userCipherService;


    public String login(LoginReq req) {
        String decryptedPCode = rsaService.readData(req.getPCode());
        return null;


    }


}
