package com.example.iisl_project.util;

import com.example.iisl_project.constant.CipherConst;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    /**
     * GCM加密
     * @param data 本文
     * @param key 不可為空，長度 16|32
     * @param iv 不可為空
     * @return HEX字串
     */
    public static String encryptGCM( String plainText, String key, String iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(CipherConst.AES_GCM_No_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key.getBytes()), getGCMParameterSpec(128, iv.getBytes()));
        byte[] result = cipher.doFinal(plainText.getBytes());
        return bytesToHexStr(result);
    }

    /**
     * GCM解密
     * @param hexContext HEX字串
     * @param key 不可為空，長度 16|32
     * @param iv 不可為空
     * @return 本文
     */
    public static String decryptGCM(String cipherText, String key, String iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        Cipher cipher = Cipher.getInstance(CipherConst.AES_GCM_No_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key.getBytes()), getGCMParameterSpec(128, iv.getBytes()));
        byte[] result = cipher.doFinal(hexStrToBytes(cipherText));
        return new String(result, StandardCharsets.UTF_8);
    }

    public static Key getSecretKey(byte[] key) {
        return new SecretKeySpec(key,  CipherConst.ALGORITHM_AES);
    }

    public static GCMParameterSpec getGCMParameterSpec(int authenticationTagLength, byte[] iv) {
        return new GCMParameterSpec(authenticationTagLength, iv);
    }

    public static String bytesToHexStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte oneByte : bytes) {
            String hex = Integer.toHexString(oneByte & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] hexStrToBytes(String hexStr) {
        if (StringUtils.isBlank(hexStr)) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
