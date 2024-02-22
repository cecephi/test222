package org.example;

//import javax.crypto.*;
//import javax.crypto.spec.DESKeySpec;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.Charset;
import java.security.*;
import java.util.Base64;
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;

public class Main {

    private static byte[] hex2Byte(byte[] arr_b) {
        if(arr_b.length % 2 != 0) {
            return null;
        }

        byte[] arr_b1 = new byte[arr_b.length / 2];
        for(int v = 0; v < arr_b.length; v += 2) {
            arr_b1[v / 2] = (byte)Integer.parseInt(new String(arr_b, v, 2), 16);
        }

        return arr_b1;
    }
    public static String decrypt(String s) {
        try {

            byte[] key = Base64.getDecoder().decode("S2JNTXhmTSw=");
            byte[] ivb = Base64.getDecoder().decode("S2JNTXhmTSw=");

            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Key secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(ivb);

            Cipher cipher0 = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher0.init(2, secretKey, iv);
            return new String(cipher0.doFinal(hex2Byte(s.getBytes("UTF-8"))), "UTF-8");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static byte[] decryptxxxx(byte[] arr_b, int v, int v1) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        b.n(arr_b, "bytes");
        Security.addProvider(new BouncyCastleFipsProvider());
        byte[] arr_b1 = Base64.getDecoder().decode("zj78ciNVJ5e8ckJAfkYFHixOdg30wLXHxH8TvQPsaM4=");;
        String s = "a167d0f793711d3e";
//        b.n(arr_b1, "key");
//        b.n(s, "initVector");
        SecretKeySpec secretKeySpec0 = new SecretKeySpec(arr_b1, "AES");
        byte[] arr_b2 = s.getBytes(Charset.defaultCharset());
//        b.m(arr_b2, "this as java.lang.String).getBytes(charset)");
        IvParameterSpec ivParameterSpec0 = new IvParameterSpec(arr_b2);
        Cipher cipher0 = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher0.init(2, secretKeySpec0, ivParameterSpec0);
        byte[] arr_b3 = cipher0.doFinal(arr_b, v, v1 - v);
//        b.m(arr_b3, "cipher.doFinal(cipherText, start, end - start)");
        return arr_b3;
    }

    public static byte[] readBinaryFile(String filePath) {
        byte[] data = null;
        try {
            // 创建 FileInputStream 对象
            FileInputStream fis = new FileInputStream(filePath);

            // 创建一个 ByteArrayOutputStream 来缓存读取的数据
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 读取数据并写入 ByteArrayOutputStream
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // 关闭 FileInputStream
            fis.close();

            // 获取读取的二进制数据
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException {

        System.out.println(decrypt("8C8CB738F2CD708D"));
//        if (args.length == 1) {
//            System.out.println(decrypt(args[0]));
//        } else {
//            System.out.println("decrypt_failed");
//        }

//        String filePath = "main.js";
//        byte[] content = readBinaryFile(filePath);
//        byte[] result = decryptxxxx(content, 8, 302088);
//
//        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath + "_out.js"));
//        fileOutputStream.write(result);
//        fileOutputStream.close();

//        final String a = "83699<|>1707204614<|>test";
//
//        String[] parts = a.split("\\<\\|\\>");
//        System.out.println(parts.length);
//
//        System.out.println("Hello world!");


    }
}