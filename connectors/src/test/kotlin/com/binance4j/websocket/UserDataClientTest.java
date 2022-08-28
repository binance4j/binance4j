/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.websocket;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.client.UserDataClient;
import com.binance4j.websocket.dto.ListenKey;
import com.binance4j.websocket.param.IsolatedUserDataStreamParams;
import com.binance4j.websocket.param.KeepAliveIsolatedUserDataStreamParams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDataClientTest {
    final UserDataClient client;

    UserDataClientTest() {
        String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
        this.client = new UserDataClient(key, secret);
    }

    @Test
    void testUserDataStream() throws ApiException {
        ListenKey listenKey = client.startUserDataStream().sync();
        assertTrue(listenKey.listenKey().length() > 0);
        assertDoesNotThrow(() -> client.keepAliveUserDataStream(listenKey.listenKey()));
        assertDoesNotThrow(() -> client.closeUserDataStream(listenKey.listenKey()).sync());
    }

    @Test
    void testMarginUserDataStream() throws ApiException {
        ListenKey listenKey = client.startMarginUserDataStream().sync();
        assertTrue(listenKey.listenKey().length() > 0);
        assertDoesNotThrow(() -> client.keepAliveMarginUserDataStream(listenKey.listenKey()));
        assertDoesNotThrow(() -> client.closeMarginUserDataStream(listenKey.listenKey()).sync());
    }

    @Test
    void testIsolatedUserDataStream() throws ApiException {
        String isolatedSymbol = "BTCUSDT";
        IsolatedUserDataStreamParams IsolatedUserDataStreamRequest = new IsolatedUserDataStreamParams(isolatedSymbol);
        ListenKey listenKey = client.startIsolatedUserDataStream(IsolatedUserDataStreamRequest).sync();
        KeepAliveIsolatedUserDataStreamParams keepAliveIsolatedUserDataStreamRequest = new KeepAliveIsolatedUserDataStreamParams(
                isolatedSymbol,
                listenKey.listenKey());
        assertTrue(listenKey.listenKey().length() > 0);
        assertDoesNotThrow(() -> client.keepAliveIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest));
        assertDoesNotThrow(() -> client.closeIsolatedUserDataStream(keepAliveIsolatedUserDataStreamRequest).sync());
    }
}
