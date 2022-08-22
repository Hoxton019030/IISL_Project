package com.example.iisl_project.service;

import com.example.iisl_project.eums.ReturnCodeConst;
import com.example.iisl_project.exception.APIException;
import com.example.iisl_project.properties.cipher.RsaProperties;
import com.example.iisl_project.util.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Slf4j
@Service
public class RsaService {

    @Autowired
    private RsaProperties rsaProperties;

    public String encrypt(String plainText){
        if(StringUtils.isBlank(plainText)) return plainText;

        try {
            return RSAUtil.encryptByPublicKey(plainText,rsaProperties.getPublicKey());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | NoSuchPaddingException |
                 InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }
    public String readData(String cipherText) {
        if(StringUtils.isBlank(cipherText)) return cipherText;

        try {
            return RSAUtil.decryptByPrivateKey(cipherText, rsaProperties.getPrivateKey());
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
                 | IllegalBlockSizeException | BadPaddingException e) {
            log.error("decrypting plainText is failed");
            throw APIException.createAPIException(ReturnCodeConst.F0005);
        }
    }
}
