package com.binance4j.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.security.HmacSHA256Signer;
import com.binance4j.core.test.ConcurrentTest;

class HmacSHA256SignerTest extends ConcurrentTest {

    @Test
    @DisplayName("It should generate a signed String and not throw an Exception")
    void testSignature() {
        assertDoesNotThrow(() -> {
            String signature = HmacSHA256Signer.sign("Hello World!", "keyboard cat");

            assertNotNull(signature);
        });
    }
}
