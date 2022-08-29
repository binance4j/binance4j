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

package com.binance4j.spot.client;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.spot.param.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestnetSpotClientTest extends CustomTest {
    int page = 1;
    SpotClient client = new TestnetSpotClient(testnetKey, testnetSecret);
    long orderId;
    String quantity = "1";
    String price = "0.011160";
    String ocoQuantity = "0.01";
    String ocoPrice = "22000";
    String ocoStopPrice = "23500";
    String ocoLimitPrice = "23500";
    String ocoSymbol = "BTCUSDT";
    long orderListId;

    public TestnetSpotClientTest() {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    @Order(0)
    void testNewOrderTest() throws ApiException {
        assertDoesNotThrow(() -> client.newOrderTest(MarketOrder.buy(symbol, "1")).sync());
        assertDoesNotThrow(() -> client.newOrderTest(MarketOrder.sell(symbol, "1")).sync());

        assertDoesNotThrow(() -> client.newOrderTest(MarketQuoteOrder.buy(symbol, "25000")).sync());
        assertDoesNotThrow(() -> client.newOrderTest(MarketQuoteOrder.sell(symbol, "25000")).sync());

        assertDoesNotThrow(() -> client.newOrderTest(LimitOrder.buy(symbol, "1", price)).sync());
        assertDoesNotThrow(() -> client.newOrderTest(LimitOrder.sell(symbol, "1", price)).sync());

        assertDoesNotThrow(() -> client.newOrderTest(LimitOrder.buy(symbol, "1", price, TimeInForce.FOK)).sync());
        assertDoesNotThrow(() -> client.newOrderTest(LimitOrder.sell(symbol, "1", price, TimeInForce.FOK)).sync());

        assertDoesNotThrow(() -> client.newOrderTest(LimitMakerOrder.buy(symbol, "1", price)).sync());
        assertDoesNotThrow(() -> client.newOrderTest(LimitMakerOrder.sell(symbol, "1", price)).sync());

        // NOT SUPPORTED assertDoesNotThrow(() ->
        // client.newOrderTest(StopLossOrder.buy(symbol, "1", price)).sync());
        // NOT SUPPORTED assertDoesNotThrow(() ->
        // client.newOrderTest(StopLossOrder.sell(symbol, "1", price)).sync());

        // NOT SUPPORTED assertDoesNotThrow(() ->
        // client.newOrderTest(TakeProfitOrder.buy(symbol, "1", price)).sync());
        // NOT SUPPORTED assertDoesNotThrow(() ->
        // client.newOrderTest(TakeProfitOrder.sell(symbol, "1", price)).sync());

        assertDoesNotThrow(() -> client.newOrderTest(TakeProfitLimitOrder.buy(symbol, "1", price, price)).sync());
        assertDoesNotThrow(() -> client.newOrderTest(TakeProfitLimitOrder.sell(symbol, "1", price, price)).sync());
    }

    @Test
    @Order(1)
    void testNewOrderMarket() throws ApiException {
        // buy market
        testNotThrow(client.newOrder(MarketOrder.buy(symbol, quantity)));
        // Sell market
        testNotThrow(client.newOrder(MarketOrder.sell(symbol, quantity)));
    }

    @Test
    @Order(2)
    void testNewOrderBuyLimit() throws ApiException {
        // buy limit
        testNotThrow(client.newOrder(LimitOrder.buy(symbol, quantity, "0.011160")));
    }

    @Test
    @Order(3)
    void testCancelOpenOrders() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        // cancel orders
        testNotThrow(client.cancelOpenOrders(new CancelOpenOrdersParams(symbol)));
        var orders = client.getOpenOrders().sync();
        assertEquals(orders.size(), 0);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    @Order(4)
    void testGetOpenOrders() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testNotThrow(client.getOpenOrders());
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    @Order(5)
    void testGetOrderStatus() throws ApiException {
        // buy
        var buyOrder = client.newOrder(MarketOrder.buy(symbol, quantity)).sync();
        // get order status
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testNotThrow(client.getOrderStatus(new OrderStatusParams(symbol, buyOrder.orderId())));
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        // Sell
        client.newOrder(MarketOrder.sell(symbol, buyOrder.executedQty())).sync();
    }

    @Test
    @Order(6)
    void testCancelOrder() throws ApiException {
        // buy limit
        var buyOrder = client.newOrder(LimitOrder.buy(symbol, quantity, "0.011160")).sync();
        assertTrue(buyOrder.side().equals("BUY"));
        testNoNulls(client.newOrder(LimitOrder.buy(symbol, quantity, "0.011160")));
        var cancellation = client.cancelOrder(new CancelOrderParams(symbol, buyOrder.orderId()));
        testNotThrow(cancellation);
        orderId = buyOrder.orderId();
    }

    @Test
    @Order(7)
    void testGetOrderCount() throws ApiException {
        testNotThrow(client.getOrderCount());
    }

    @Test
    @Order(8)
    void testGetAccount() throws ApiException {
        testNotThrow(client.getAccount());
    }

    @Test
    @Order(9)
    void testGetAllOrders() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testHasNulls(client.getAllOrders(new AllOrdersParams(symbol)), List.of("accountId"), true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    @Order(10)
    void testGetAllOrders2() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testHasNulls(client.getAllOrders(new AllOrdersParams(symbol, orderId)), List.of("accountId"), true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    @Order(11)
    void testGetTrades() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testNotThrow(client.getTrades(new TradesParams(orderId, symbol)));
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    // @Test OK works!
    // @Order(12)
    void testNewOCOAndGetOCO() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        var oco = new NewOCOOrderParams(ocoSymbol, OrderSide.BUY, ocoQuantity, ocoPrice, ocoStopPrice, ocoStopPrice,
                TimeInForce.GTC);

        var res = client.newOCO(oco).sync();
        orderListId = res.orderListId();
        testHasNulls(res, List.of("orderReports[1].stopPrice"), false);
        testNotThrow(client.getOCO(new OCOInfoParams(res.orderListId())));
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    // @Test OK works!
    // @Order(14)
    void testCancelOpenOCO() throws ApiException {
        client.getOpenOCO().sync().forEach(oo -> {
            testNoNulls(oo);
            try {
                var resp = client.cancelOCO(new CancelOCOParams(oo.symbol(), oo.orderListId())).sync();
                Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
                testHasNulls(resp, List.of("orderReports[1].stopPrice"), false);
                Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    @Order(15)
    void testGetAllOCO() throws ApiException {
        testNotThrow(client.getAllOCO());
    }

    @Test
    @Order(16)
    void testGetAllOCO2() throws ApiException {
        testNotThrow(client.getAllOCO(new AllOCOInfoParams(orderId)));
    }

    @Test
    @Order(17)
    void testGetAllOCO3() throws ApiException {
        testNotThrow(client.getAllOCO(new AllOCOInfoParams(orderId), new TimeFrame(limit)));
    }

    @Test
    @Order(18)
    void testGetAllOCO4() throws ApiException {
        testNotThrow(client.getAllOCO(new TimeFrame(limit)));
    }
}
