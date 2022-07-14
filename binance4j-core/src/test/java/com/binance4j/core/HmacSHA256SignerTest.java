package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.security.HmacSHA256Signer;

class HmacSHA256SignerTest {

    @Test
    void testSignature() {
        assertDoesNotThrow(() -> {
            String signature = HmacSHA256Signer.sign("Hello World!", "keyboard cat");

            assertNotNull(signature);
        });
    }
}
