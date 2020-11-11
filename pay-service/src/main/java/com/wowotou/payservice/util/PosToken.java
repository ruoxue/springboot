package com.wowotou.payservice.util;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class PosToken {
    public static String a(String str, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, rSAPublicKey);
        String[] a = a(new String(str.getBytes("GBK"), "ISO-8859-1"), (rSAPublicKey.getModulus().bitLength() / 8) - 11);
        StringBuilder stringBuilder = new StringBuilder();
        for (String bytes : a) {
            stringBuilder.append(a(instance.doFinal(bytes.getBytes("ISO-8859-1"))));
        }
        return stringBuilder.toString();
    }

    public static String a(String str, RSAPrivateKey rSAPrivateKey) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, rSAPrivateKey);
        int bitLength = rSAPrivateKey.getModulus().bitLength() / 8;
        byte[] bytes = str.getBytes("ISO-8859-1");
        bytes = a(bytes, bytes.length);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte[] doFinal : b(bytes, bitLength)) {
            stringBuilder.append(new String(instance.doFinal(doFinal), "ISO-8859-1"));
        }
        return new String(stringBuilder.toString().getBytes("ISO-8859-1"));
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(i / 2)];
        int i2 = 0;
        for (int i3 = 0; i3 < (i + 1) / 2; i3++) {
            int i4 = i2 + 1;
            bArr2[i3] = a(bArr[i2]);
            if (i4 >= i) {
                i2 = i4;
                i4 = 0;
            } else {
                int i5 = i4 + 1;
                byte a = a(bArr[i4]);
                i2 = i5;
            }
            bArr2[i3] = (byte) (i4 + (bArr2[i3] << 4));
        }
        return bArr2;
    }

    public static byte a(byte b) {
        if (b >= (byte) 48 && b <= (byte) 57) {
            return (byte) (b - 48);
        }
        if (b >= (byte) 65 && b <= (byte) 70) {
            return (byte) ((b - 65) + 10);
        }
        if (b < (byte) 97 || b > (byte) 102) {
            return (byte) (b - 48);
        }
        return (byte) ((b - 97) + 10);
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2;
            char c = (char) (((bArr[i] & 240) >> 4) & 15);
            cArr[i * 2] = (char) (c > '\t' ? (c + 65) - 10 : c + 48);
            c = (char) (bArr[i] & 15);
            int i3 = (i * 2) + 1;
            if (c > '\t') {
                i2 = (c + 65) - 10;
            } else {
                i2 = c + 48;
            }
            cArr[i3] = (char) i2;
        }
        return new String(cArr);
    }

    public static String[] a(String str, int i) {
        int i2;
        int length = str.length() / i;
        int length2 = str.length() % i;
        if (length2 != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        String[] strArr = new String[(length + i2)];
        for (int i3 = 0; i3 < length + i2; i3++) {
            String substring;
            if (i3 != (length + i2) - 1 || length2 == 0) {
                substring = str.substring(i3 * i, (i3 * i) + i);
            } else {
                substring = str.substring(i3 * i, (i3 * i) + length2);
            }
            strArr[i3] = substring;
        }
        return strArr;
    }

    public static byte[][] b(byte[] bArr, int i) {
        int i2;
        int length = bArr.length / i;
        int length2 = bArr.length % i;
        if (length2 != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        byte[][] bArr2 = new byte[(length + i2)][];
        for (int i3 = 0; i3 < length + i2; i3++) {
            Object obj = new byte[i];
            if (i3 != (length + i2) - 1 || length2 == 0) {
                System.arraycopy(bArr, i3 * i, obj, 0, i);
            } else {
                System.arraycopy(bArr, i3 * i, obj, 0, length2);
            }
            bArr2[i3] = (byte[]) obj;
        }
        return bArr2;
    }

    public static RSAPrivateKey a(String str) throws Exception {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(new PosStr2Byte().str2byte(str)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("私钥非法");
        } catch (IOException e3) {
            throw new Exception("私钥数据内容读取错误");
        } catch (NullPointerException e4) {
            throw new Exception("私钥数据为空");
        }
    }

    public static RSAPublicKey b(String str) throws Exception {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new PosStr2Byte().str2byte(str)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("公钥非法");
        } catch (IOException e3) {
            throw new Exception("公钥数据内容读取错误");
        } catch (NullPointerException e4) {
            throw new Exception("公钥数据为空");
        }
    }

    public static String token(String str, String str2)  {
        try {
            return a(str, b(str2));
        }catch (Exception e){

            return  str;
        }

    }

    public static String b(String str, String str2) throws Exception {
        return a(str, a(str2));
    }


}
