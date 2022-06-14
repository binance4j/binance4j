package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.account.AssetBalance;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOpenOrdersRequest;
import com.binance4j.core.order.CancelOrderRequest;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.Trade;
import com.binance4j.spot.account.Account;
import com.binance4j.spot.order.AllOrdersRequest;
import com.binance4j.spot.order.MyTradesRequest;
import com.binance4j.spot.order.NewOrder;
import com.binance4j.spot.order.NewOrderResponse;
import com.binance4j.spot.order.OCOInfo;
import com.binance4j.spot.order.OpenOrdersStatusRequest;
import com.binance4j.spot.order.OrderCount;
import com.binance4j.spot.order.OrderStatusRequest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpotClientTest {
    SpotClient client;

    public SpotClientTest() {
        String key = System.getenv("BINANCE_API_KEY"), secret = System.getenv("BINANCE_API_SECRET");
        client = new SpotClient(key, secret, false);
    }

    // @Test
    @DisplayName("Test must not throw an exception")
    public void testNewOrder() throws ApiException {
        // /!\ Change the values /!\
        NewOrder order = NewOrder.sellQuote("BTCBUSD", new BigDecimal(10));
        NewOrderResponse res = client.newOrder(order).execute();
        System.out.println(res);
        assertNotNull(res);
        assertNotNull(res.getClientOrderId());
        assertNotNull(res.getCummulativeQuoteQty());
        assertNotNull(res.getExecutedQty());
        assertNotNull(res.getOrderId());
        assertNotNull(res.getOrderListId());
        assertNotNull(res.getOrigQty());
        assertNotNull(res.getPrice());
        assertNotNull(res.getSide());
        assertNotNull(res.getStatus());
        assertNotNull(res.getSymbol());
        assertNotNull(res.getTimeInForce());
        assertNotNull(res.getTransactTime());
        assertNotNull(res.getType());
        res.getFills().forEach(f -> {
            assertNotNull(f.getCommission());
            assertNotNull(f.getCommissionAsset());
            assertNotNull(f.getPrice());
            assertNotNull(f.getQty());
            assertNotNull(f.getTradeId());
        });
    }

    // @Test
    @DisplayName("Test must not throw an exception")
    public void testNewOrderTest() throws ApiException {
        NewOrder order = NewOrder.buyMarket("SHIBBUSD", new BigDecimal(1000000));
        client.newOrderTest(order).execute();
    }

    // @Test
    @DisplayName("Test must not throw an exception")
    public void testCancelOrderTest() throws ApiException {
        // change the symbol and id for your tests
        CancelOrderResponse order = client.cancelOrder(new CancelOrderRequest("APEBUSD",
                56935218L))
                .execute();
        assertNull(order.getIsIsolated());
        assertNotNull(order.getClientOrderId());
        assertNotNull(order.getCummulativeQuoteQty());
        assertNotNull(order.getExecutedQty());
        assertNotNull(order.getOrderId());
        assertNotNull(order.getOrderListId());
        assertNotNull(order.getOrigClientOrderId());
        assertNotNull(order.getOrigQty());
        assertNotNull(order.getPrice());
        assertNotNull(order.getSide());
        assertNotNull(order.getStatus());
        assertNotNull(order.getSymbol());
        assertNotNull(order.getTimeInForce());
        assertNotNull(order.getType());
    }

    // @Test
    @DisplayName("Test must not throw an exception")
    public void testCancelOpenOrdersTest() throws ApiException {
        // change the symbol for your tests
        List<CancelOrderResponse> orders = client.cancelOpenOrders(new CancelOpenOrdersRequest("GMTBUSD"))
                .execute();
        if (!orders.isEmpty()) {
            CancelOrderResponse order = orders.get(0);
            assertNull(order.getIsIsolated());
            assertNotNull(order.getClientOrderId());
            assertNotNull(order.getCummulativeQuoteQty());
            assertNotNull(order.getExecutedQty());
            assertNotNull(order.getOrderId());
            assertNotNull(order.getOrderListId());
            assertNotNull(order.getOrigClientOrderId());
            assertNotNull(order.getOrigQty());
            assertNotNull(order.getPrice());
            assertNotNull(order.getSide());
            assertNotNull(order.getStatus());
            assertNotNull(order.getSymbol());
            assertNotNull(order.getTimeInForce());
            assertNotNull(order.getType());
        }
    }

    // Test seems to not work with github actions
    // @Test
    @DisplayName("Test must throw a MIN_NOTIONAL exception")
    public void testNewFailedOrderTest() throws ApiException {
        try {
            NewOrder order = NewOrder.buyMarket("SHIBBUSD", new BigDecimal(1000));
            client.newOrderTest(order).execute();
        } catch (ApiException e) {
            System.out.println(e);
            assertEquals("Filter failure: MIN_NOTIONAL", e.getMessage());
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetAccount() throws ApiException {
        Account account = client.getAccount().execute();

        assertNotNull(account.getAccountType());
        assertNotNull(account.getBuyerCommission());
        assertNotNull(account.getMakerCommission());
        assertNotNull(account.getPermissions());
        assertNotNull(account.getSellerCommission());
        assertNotNull(account.getTakerCommission());
        assertNotNull(account.getUpdateTime());
        assertNotNull(account.getCanDeposit());
        assertNotNull(account.getCanTrade());
        assertNotNull(account.getCanWithdraw());
        assertNotNull(account.getBalances());

        AssetBalance balance = account.getBalances().get(0);
        assertNotNull(balance.getAsset());
        assertNotNull(balance.getFree());
        assertNotNull(balance.getLocked());
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetAllOrders() throws ApiException {
        List<OrderInfo> orders = client.getAllOrders(new AllOrdersRequest("APEBUSD")).execute();

        if (!orders.isEmpty()) {
            OrderInfo order = orders.get(0);

            assertNull(order.getIsIsolated());
            assertNotNull(order.getClientOrderId());
            assertNotNull(order.getCummulativeQuoteQty());
            assertNotNull(order.getExecutedQty());
            assertNotNull(order.getIcebergQty());
            assertNotNull(order.getIsWorking());
            assertNotNull(order.getOrderId());
            assertNotNull(order.getOrigQty());
            assertNotNull(order.getOrigQuoteOrderQty());
            assertNotNull(order.getPrice());
            assertNotNull(order.getSide());
            assertNotNull(order.getStatus());
            assertNotNull(order.getStopPrice());
            assertNotNull(order.getSymbol());
            assertNotNull(order.getTime());
            assertNotNull(order.getTimeInForce());
            assertNotNull(order.getType());
            assertNotNull(order.getUpdateTime());
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetMyTrades() throws ApiException {
        List<Trade> trades = client.getMyTrades(new MyTradesRequest("APEBUSD")).execute();

        if (!trades.isEmpty()) {
            Trade trade = trades.get(0);
            assertNotNull(trade.getCommission());
            assertNotNull(trade.getCommissionAsset());
            assertNotNull(trade.getId());
            assertNotNull(trade.getIsBestMatch());
            assertNotNull(trade.getIsBuyer());
            assertNotNull(trade.getIsMaker());
            assertNotNull(trade.getOrderId());
            assertNotNull(trade.getPrice());
            assertNotNull(trade.getQty());
            assertNotNull(trade.getQuoteQty());
            assertNotNull(trade.getSymbol());
            assertNotNull(trade.getTime());
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetOpenOrders() throws ApiException {
        List<OrderInfo> orders = client.getOpenOrders().execute();
        if (!orders.isEmpty()) {
            OrderInfo order = orders.get(0);
            assertNull(order.getIsIsolated());
            assertNotNull(order.getClientOrderId());
            assertNotNull(order.getCummulativeQuoteQty());
            assertNotNull(order.getExecutedQty());
            assertNotNull(order.getIcebergQty());
            assertNotNull(order.getIsWorking());
            assertNotNull(order.getOrderId());
            assertNotNull(order.getOrigQty());
            assertNotNull(order.getOrigQuoteOrderQty());
            assertNotNull(order.getPrice());
            assertNotNull(order.getSide());
            assertNotNull(order.getStatus());
            assertNotNull(order.getStopPrice());
            assertNotNull(order.getSymbol());
            assertNotNull(order.getTime());
            assertNotNull(order.getTimeInForce());
            assertNotNull(order.getType());
            assertNotNull(order.getUpdateTime());
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetOpenOrders2() throws ApiException {
        String symbol = "APEBUSD";

        List<OrderInfo> orders = client.getOpenOrders(new OpenOrdersStatusRequest(symbol)).execute();

        if (!orders.isEmpty()) {
            OrderInfo order = orders.get(0);
            assertNull(order.getIsIsolated());
            assertNotNull(order.getClientOrderId());
            assertNotNull(order.getCummulativeQuoteQty());
            assertNotNull(order.getExecutedQty());
            assertNotNull(order.getIcebergQty());
            assertNotNull(order.getIsWorking());
            assertNotNull(order.getOrderId());
            assertNotNull(order.getOrigQty());
            assertNotNull(order.getOrigQuoteOrderQty());
            assertNotNull(order.getPrice());
            assertNotNull(order.getSide());
            assertNotNull(order.getStatus());
            assertNotNull(order.getStopPrice());
            assertNotNull(order.getTime());
            assertNotNull(order.getTimeInForce());
            assertNotNull(order.getType());
            assertNotNull(order.getUpdateTime());
            assertNotNull(order.getSymbol());
            assertEquals(order.getSymbol(), symbol);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetOrderCount() throws ApiException {
        List<OrderCount> orders = client.getOrderCount().execute();
        orders.forEach(o -> {
            assertNotNull(o.getCount());
            assertNotNull(o.getInterval());
            assertNotNull(o.getIntervalNum());
            assertNotNull(o.getLimit());
            assertNotNull(o.getRateLimitType());
        });
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetOrderStatus() throws ApiException {
        // params should be changed to match your own order
        String symbol = "GMTBUSD";
        Long id = 65293729L;

        OrderInfo order = client.getOrderStatus(new OrderStatusRequest(symbol, id)).execute();
        assertNotNull(order);

        if (order != null) {
            assertNull(order.getIsIsolated());
            assertNotNull(order.getClientOrderId());
            assertNotNull(order.getCummulativeQuoteQty());
            assertNotNull(order.getExecutedQty());
            assertNotNull(order.getIcebergQty());
            assertNotNull(order.getIsWorking());
            assertNotNull(order.getOrderId());
            assertNotNull(order.getOrigQty());
            assertNotNull(order.getOrigQuoteOrderQty());
            assertNotNull(order.getPrice());
            assertNotNull(order.getSide());
            assertNotNull(order.getStatus());
            assertNotNull(order.getStopPrice());
            assertNotNull(order.getTime());
            assertNotNull(order.getTimeInForce());
            assertNotNull(order.getType());
            assertNotNull(order.getUpdateTime());
            assertNotNull(order.getSymbol());
            assertEquals(order.getSymbol(), symbol);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetOpenOCO() throws ApiException {
        List<OCOInfo> ocos = client.getOpenOCO().execute();
        if (!ocos.isEmpty()) {
            OCOInfo oco = ocos.get(0);
            assertNotNull(oco.getContingencyType());
            assertNotNull(oco.getListClientOrderId());
            assertNotNull(oco.getListOrderStatus());
            assertNotNull(oco.getListStatusType());
            assertNotNull(oco.getOrderListId());
            assertNotNull(oco.getOrders());
            assertNotNull(oco.getSymbol());
            assertNotNull(oco.getTransactionTime());
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testGetAllOCO() throws ApiException {
        List<OCOInfo> ocos = client.getAllOCO().execute();
        if (!ocos.isEmpty()) {
            OCOInfo oco = ocos.get(0);
            assertNotNull(oco.getContingencyType());
            assertNotNull(oco.getListClientOrderId());
            assertNotNull(oco.getListOrderStatus());
            assertNotNull(oco.getListStatusType());
            assertNotNull(oco.getOrderListId());
            assertNotNull(oco.getOrders());
            assertNotNull(oco.getSymbol());
            assertNotNull(oco.getTransactionTime());
        }
    }

    // @Test
    @DisplayName("Properties shouldn't be null or ApiException should not be null")
    public void testNewOCO() throws ApiException {
        // TODO find a symbol authorizing STOP_LOSS
        try {
            OCOOrder req = new OCOOrder("BTCBUSD", OrderSide.BUY,
                    new BigDecimal(1), new BigDecimal(50000), new BigDecimal(55000));
            OCOResponse resp = client.newOCO(req).execute();
            resp.getOrders().forEach(o -> {
                assertNotNull(o.getClientOrderId());
                assertNotNull(o.getOrderId());
                assertNotNull(o.getSymbol());
            });

            assertNotNull(resp.getContingencyType());
            assertNull(resp.getIsIsolated());
            assertNotNull(resp.getListClientOrderId());
            assertNotNull(resp.getListOrderStatus());
            assertNotNull(resp.getListStatusType());
            assertNotNull(resp.getOrderListId());
            assertNotNull(resp.getOrderReports());
            assertNotNull(resp.getSymbol());
            assertNotNull(resp.getTransactionTime());
        } catch (ApiException e) {
            System.out.println(e);
            assertTrue(false);
        }
    }

    // @Test
    public void testQueryOCO() throws ApiException {
        // #TODO make an OCO order first
        // can't test, never did OCO
    }

    // @Test
    public void testCancelOCO() throws ApiException {
        // #TODO make an OCO order first
        // can't test, never did OCO
    }
}
