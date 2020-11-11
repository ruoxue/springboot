package com.wowotou.payservice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

    public static String sha256(String str) {
        return sha256(str, "SHA-256");
    }

    private static String sha256(String str, String str2) {
        String str3 = null;
        if (str != null && str.length() > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes());
                byte[] digest = instance.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : digest) {
                    String toHexString = Integer.toHexString(b & 255);
                    if (toHexString.length() == 1) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(toHexString);
                }
                str3 = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return str3;
    }




    public static String b(String token,String publiKey) {
        try {
            return PosToken.token(token,publiKey == null ?
                    "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXZTAiomNmF3HNJm0/iSx/9MkfdwhU3eyExClGGPOSFrvEbco/HwRT3fLRjri1VEFRi8+S5HKkC1SB8QZd8pOFE5tH9RFWQRbTu5j9dA43hENv+xN6jA0w3sEM+Cg2rWswL/bGOJtjnW072q4WoF13lIlw6CgMDoMmb+BqcV/H8wIDAQAB" : publiKey);
        } catch (Exception e) {
            return publiKey;
        }
    }









}
