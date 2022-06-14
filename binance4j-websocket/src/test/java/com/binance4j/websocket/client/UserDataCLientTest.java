package com.binance4j.websocket.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.misc.ListenKey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserDataCLientTest {

    UserDataClient client;

    /**
     * @param client
     */
    public UserDataCLientTest() {
        String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
        this.client = new UserDataClient(key, secret);
    }

    @Test
    @DisplayName("The listen key should be a non empty string. keeping alive and closing the stream should not trigger an error")
    public void testUserDataStream() throws ApiException {
        ListenKey listenKey = client.startUserDataStream().execute();
        assertTrue(listenKey.getListenKey().length() > 0);
        System.out.println(listenKey.getListenKey());
        client.keepAliveUserDataStream(listenKey.getListenKey());
        client.closeUserDataStream(listenKey.getListenKey()).execute();
    }
}
