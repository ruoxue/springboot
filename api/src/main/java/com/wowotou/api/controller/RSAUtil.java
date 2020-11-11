package com.wowotou.api.controller;

import javax.crypto.Cipher;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtil {

    public static final String ALGORITHM = "RSA";
    public static final int KEYSIZE = 1024;
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;
    private BigInteger modulus;
    private BigInteger publicExponent;
    private BigInteger privateExponent;
    private byte[] publicKeyByte;
    private byte[] privateKeyByte;
    private String publicKeyString;
    private String privateKeyString;


    public void generateKey() throws NoSuchAlgorithmException, IOException {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom secureRandom = new SecureRandom();

        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);

        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        keyPairGenerator.initialize(KEYSIZE, secureRandom);

        /** 生成密匙对 */
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        /** 生成公钥 **/
        publicKey = (RSAPublicKey) keyPair.getPublic();

        /** 生成私钥 **/
        privateKey = (RSAPrivateKey) keyPair.getPrivate();

        /**获得指数和模**/
        modulus = publicKey.getModulus();
        publicExponent = publicKey.getPublicExponent();
        privateExponent = privateKey.getPrivateExponent();

        /**生成比特编码*/
        publicKeyByte = publicKey.getEncoded();
        privateKeyByte = privateKey.getEncoded();

        /** 生成base64编码 **/
        publicKeyString = Base64.getEncoder().encodeToString(publicKeyByte);
        privateKeyString = Base64.getEncoder().encodeToString(privateKeyByte);

        // /**将编码写入文件中**/
        // String pulicKeyFilePath = " ";
        // String privateKeyFilePath = " ";
        //
        // FileWriter pubfw = new FileWriter(pulicKeyFilePath);
        // BufferedWriter pubbw = new BufferedWriter(pubfw);
        // pubbw.write(publicKeyString);
        // pubbw.flush();
        // pubbw.close();
        // pubfw.close();
        // System.out.println("modulus :"+modulus);
        // System.out.println("exponet :"+e);
    }

    /**
     * 通过指数和模来生成公钥
     **/
    public RSAPublicKey generatePublicKeyByModulsAndExponent(BigInteger modulus,BigInteger publicExponent) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus,publicExponent);
            RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(rsaPublicKeySpec);
            return publicKey;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过指数和模来生成私钥
     **/
    public RSAPrivateKey generatePrivateKeyByModulsAndExponent(BigInteger modulus,BigInteger privateExponent) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus,privateExponent);
            RSAPrivateKey privateKey = (RSAPrivateKey)keyFactory.generatePrivate(rsaPrivateKeySpec);
            return privateKey;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 通过byte编码还原公钥
     */
    public RSAPublicKey generatePublicKeyByByteArray(byte[] publicKeyData) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyData);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过byte编码还原私钥
     */
    public RSAPrivateKey generatePrivateKeyByByteArray(byte[] privateKeyData) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyData);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKey privateKey = (RSAPrivateKey)keyFactory.generatePrivate(keySpec);
            return privateKey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /** 加密 **/
    public byte[] encrypt(RSAPublicKey publicKey, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(data);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /** 解密 **/
    public byte[] decrypt(RSAPrivateKey privateKey, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(data);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public  static  BigInteger getii(String s){


        byte[] bytes=new  byte[130];
        String[] split = "64171,40239,51232,33282,12407,8168,15809,17783,61035,61086,26852,53098,36007,7980,21226,1453,13291,25215,3845,56988,8891,19217,1185,35925,36364,4662,50467,50000,17253,38607,51396,30062,55190,51830,21189,55073,43762,18277,38439,46206,28064,3569,46721,59137,10563,23595,1706,27461,2435,53028,3495,30594,54641,28989,24789,39307,49963,19375,3782,38758,34376,25771,33988,33533,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0".split(",");


        for (int i=0;i<130;i++){
            if (split[i].length()>2){
                bytes[i]=Byte.decode(split[i].substring(0,2));

            }else {
                bytes[i]=Byte.decode(split[i]);

            }

        }
        BigInteger bigInteger=new BigInteger(bytes);

        String[] split1 = "17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0".split("");
//        BigInteger result = new BigInteger(new byte[130]{});
//
//
//        BigInteger result2 = new BigInteger(new byte[130]{});

        return  bigInteger;
    }


    public  static  BigInteger getii4(String s){


        byte[] bytes=new  byte[130];
//        String[] split = "64171,40239,51232,33282,12407,8168,15809,17783,61035,61086,26852,53098,36007,7980,21226,1453,13291,25215,3845,56988,8891,19217,1185,35925,36364,4662,50467,50000,17253,38607,51396,30062,55190,51830,21189,55073,43762,18277,38439,46206,28064,3569,46721,59137,10563,23595,1706,27461,2435,53028,3495,30594,54641,28989,24789,39307,49963,19375,3782,38758,34376,25771,33988,33533,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0".split("");
        String[] split = "17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0".split(",");


        for (int i=0;i<130;i++){
            bytes[i]=Byte.decode(split[i]);
        }
        BigInteger bigInteger=new BigInteger(bytes);

//        BigInteger result = new BigInteger(new byte[130]{});
//
//
//        BigInteger result2 = new BigInteger(new byte[130]{});

        return  bigInteger;
    }


    public  static  void  main(String[] a){
        BigInteger getii = getii("09hhhh");
        RSAPublicKey rsaPublicKey = new RSAUtil().generatePublicKeyByModulsAndExponent(getii4(""), getii(""));
        byte[] encrypt = new RSAUtil().encrypt(rsaPublicKey, "123456".getBytes());
        System.out.println(new String(encrypt));

    }
}
