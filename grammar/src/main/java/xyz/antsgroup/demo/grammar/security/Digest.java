package xyz.antsgroup.demo.grammar.security;

/**
 * @author ants_ypc
 * @version 1.0 3/27/16
 */

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Scanner;

public class Digest
{

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        String[] algname = {"MD5", "SHA-1", "SHA-256"};
        System.out.print("Input encrypt, such as:");
        for (String s : algname)
            System.out.print(s + " ");
        Scanner stdin = new Scanner(System.in);
        MessageDigest digest = MessageDigest.getInstance(stdin.nextLine());    // 获取对应签名方法的类
//        byte[] input = Files.readAllBytes(Paths.get("/file"));              // 传入需要进行 HASH 的值
        byte[] input = "string need to be digested".getBytes();
        byte[] hash = digest.digest(input);                                    // 获取签名后的值.或者使用update(byte[])不断的添加,最后再使用digest()方法
        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;
            if (v < 16) d += "0";   // 由于 byte(1字节) 转 int(4字节),肯定都是整数,如果小于16说明高4位都是0
            d += Integer.toString(v, 16).toUpperCase();
        }
        System.out.println(d);
    }
}