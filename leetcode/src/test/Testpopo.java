package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: qdh
 * Date: 2019/8/5
 * Time: 10:29
 * Created with IntelliJ IDEA
 * Description:
 */

public class Testpopo {
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String generateSignature(String secret,long timestamp) throws NoSuchAlgorithmException {
        String value=secret+timestamp;

        MessageDigest messageDigest   = MessageDigest.getInstance("md5");
        messageDigest.update(value.getBytes());
        byte[] bb=messageDigest.digest();

        String s= getFormattedText(bb);
        return s;
    }



    public static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        String secret ="c42f890c-063b-4819-ad70-0780d8c0247b";
        long time =System.currentTimeMillis();
        System.out.println(time);
        System.out.println(generateSignature(secret, time));
    }



}
