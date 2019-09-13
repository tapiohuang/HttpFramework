package org.hystudio.httpframework.utils;

import java.security.MessageDigest;

@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class MD5Utils {
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (byte byteToHexString : b) {
            resultSb.append(byteToHexString(byteToHexString));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < (byte) 0) {
            n += 256;
        }
        return hexDigits[n / 16] + hexDigits[n % 16];
    }

    public static String MD5Encode(String origin, String charsetname) {
        try {
            String resultString = origin;
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                if (charsetname == null || "".equals(charsetname)) {
                    return byteArrayToHexString(md.digest(resultString.getBytes()));
                }
                return byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            } catch (Exception e) {
                return resultString;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static String MD5Encode(String origin) {
        return MD5Encode(origin, "utf-8");
    }
}
