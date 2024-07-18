package cn.xuanzhi33.carprojectserver.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Hmac {
    // Converts byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Converts hex string to byte array
    private static byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }

    // Calculates HMAC SHA256 and returns it as a hex string
    public static String calculateHMAC(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        return bytesToHex(mac.doFinal(data.getBytes()));
    }

    // Verifies the HMAC SHA256 signature (in hex string format)
    public static boolean verifyHMAC(String data, String key, String signatureHex) throws NoSuchAlgorithmException, InvalidKeyException {
        String calculatedHmacHex = calculateHMAC(data, key);

        return calculatedHmacHex.equalsIgnoreCase(signatureHex);
    }
}
