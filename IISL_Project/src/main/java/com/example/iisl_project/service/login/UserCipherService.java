package com.example.iisl_project.service.login;

import com.example.iisl_project.eums.ReturnCodeConst;
import com.example.iisl_project.exception.APIException;
import com.example.iisl_project.properties.cipher.AesProperties;
import com.example.iisl_project.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
public class UserCipherService {

    @Autowired
    private AesProperties aesProperties;


    public String encrypt(String plainText) {
        if(StringUtils.isBlank(plainText)) return plainText;

        final String code = aesProperties.getCode();
        final String iv = aesProperties.getIv();
        try {
            return AESUtil.encryptGCM(plainText, code, iv);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            log.error("encrypting plainText is failed");
            throw APIException.createAPIException(ReturnCodeConst.F0018);
        }
    }

    public String readData(String cipherText) {
        if(StringUtils.isBlank(cipherText)) return cipherText;

        final String code = aesProperties.getCode();
        final String iv = aesProperties.getIv();
        try {
            return AESUtil.decryptGCM(cipherText, code, iv);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            log.error("decrypting plainText is failed");
            throw APIException.createAPIException(ReturnCodeConst.F0018);
        }
    }
}