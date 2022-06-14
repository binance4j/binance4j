package com.binance4j.core.security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * Utility class to sign messages using HMAC-SHA256.
 */
public class HmacSHA256Signer {

    private HmacSHA256Signer() {
    }

    /**
     * Sign the given message using the given secret.
     *
     * @param message message to sign
     * @param secret  secret key
     * @return a signed message
     */
    public static String sign(String message, String secret) throws UnableToSignException {
        try {
            Mac sha256HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256HMAC.init(secretKeySpec);
            return new String(Hex.encodeHex(sha256HMAC.doFinal(message.getBytes())));
        } catch (Exception e) {
            throw new UnableToSignException(e);
        }
    }
}
