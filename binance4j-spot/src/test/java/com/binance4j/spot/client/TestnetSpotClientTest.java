package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.spot.param.AllOCOInfoParams;
import com.binance4j.spot.param.AllOrdersParams;
import com.binance4j.spot.param.CancelOCOParams;
import com.binance4j.spot.param.CancelOpenOrdersParams;
import com.binance4j.spot.param.CancelOrderParams;
import com.binance4j.spot.param.LimitMakerOrder;
import com.binance4j.spot.param.LimitOrder;
import com.binance4j.spot.param.MarketOrder;
import com.binance4j.spot.param.MarketQuoteOrder;
import com.binance4j.spot.param.NewOCOOrderParams;
import com.binance4j.spot.param.OCOInfoParams;
import com.binance4j.spot.param.OrderStatusParams;
import com.binance4j.spot.param.TakeProfitLimitOrder;
import com.binance4j.spot.param.TradesParams;
import com.fasterxml.jackson.databind.DeserializationFeature;

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

	@Override
	protected SpotClient getClient() {
		return client;
	}

	@Test
	@Order(0)
	void testNewOrderTest() throws ApiException {
		assertDoesNotThrow(() -> getClient().newOrderTest(MarketOrder.buy(symbol, "1")).sync());
		assertDoesNotThrow(() -> getClient().newOrderTest(MarketOrder.sell(symbol, "1")).sync());

		assertDoesNotThrow(() -> getClient().newOrderTest(MarketQuoteOrder.buy(symbol, "25000")).sync());
		assertDoesNotThrow(() -> getClient().newOrderTest(MarketQuoteOrder.sell(symbol, "25000")).sync());

		assertDoesNotThrow(() -> getClient().newOrderTest(LimitOrder.buy(symbol, "1", price)).sync());
		assertDoesNotThrow(() -> getClient().newOrderTest(LimitOrder.sell(symbol, "1", price)).sync());

		assertDoesNotThrow(() -> getClient().newOrderTest(LimitOrder.buy(symbol, "1", price, TimeInForce.FOK)).sync());
		assertDoesNotThrow(() -> getClient().newOrderTest(LimitOrder.sell(symbol, "1", price, TimeInForce.FOK)).sync());

		assertDoesNotThrow(() -> getClient().newOrderTest(LimitMakerOrder.buy(symbol, "1", price)).sync());
		assertDoesNotThrow(() -> getClient().newOrderTest(LimitMakerOrder.sell(symbol, "1", price)).sync());

		// NOT SUPPORTED assertDoesNotThrow(() ->
		// getClient().newOrderTest(StopLossOrder.buy(symbol, "1", price)).sync());
		// NOT SUPPORTED assertDoesNotThrow(() ->
		// getClient().newOrderTest(StopLossOrder.sell(symbol, "1", price)).sync());

		// NOT SUPPORTED assertDoesNotThrow(() ->
		// getClient().newOrderTest(TakeProfitOrder.buy(symbol, "1", price)).sync());
		// NOT SUPPORTED assertDoesNotThrow(() ->
		// getClient().newOrderTest(TakeProfitOrder.sell(symbol, "1", price)).sync());

		assertDoesNotThrow(() -> getClient().newOrderTest(TakeProfitLimitOrder.buy(symbol, "1", price, price)).sync());
		assertDoesNotThrow(() -> getClient().newOrderTest(TakeProfitLimitOrder.sell(symbol, "1", price, price)).sync());
	}

	@Test
	@Order(1)
	void testNewOrderMarket() throws ApiException {
		// buy market
		testNotThrow(getClient().newOrder(MarketOrder.buy(symbol, quantity)));
		// Sell market
		testNotThrow(getClient().newOrder(MarketOrder.sell(symbol, quantity)));
	}

	@Test
	@Order(2)
	void testNewOrderBuyLimit() throws ApiException {
		// buy limit
		testNotThrow(getClient().newOrder(LimitOrder.buy(symbol, quantity, "0.011160")));
	}

	@Test
	@Order(3)
	void testCancelOpenOrders() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		// cancel orders
		testNotThrow(getClient().cancelOpenOrders(new CancelOpenOrdersParams(symbol)));
		var orders = getClient().getOpenOrders().sync();
		assertEquals(orders.size(), 0);
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(4)
	void testGetOpenOrders() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getOpenOrders());
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(5)
	void testGetOrderStatus() throws ApiException {
		// buy
		var buyOrder = getClient().newOrder(MarketOrder.buy(symbol, quantity)).sync();
		// get order status
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getOrderStatus(new OrderStatusParams(symbol, buyOrder.orderId())));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
		// Sell
		getClient().newOrder(MarketOrder.sell(symbol, buyOrder.executedQty())).sync();
	}

	@Test
	@Order(6)
	void testCancelOrder() throws ApiException {
		// buy limit
		var buyOrder = getClient().newOrder(LimitOrder.buy(symbol, quantity, "0.011160")).sync();
		assertTrue(buyOrder.side().equals("BUY"));
		testNoNulls(getClient().newOrder(LimitOrder.buy(symbol, quantity, "0.011160")));
		var cancellation = getClient().cancelOrder(new CancelOrderParams(symbol, buyOrder.orderId()));
		testNotThrow(cancellation);
		orderId = buyOrder.orderId();
	}

	@Test
	@Order(7)
	void testGetOrderCount() throws ApiException {
		testNotThrow(getClient().getOrderCount());
	}

	@Test
	@Order(8)
	void testGetAccount() throws ApiException {
		testNotThrow(getClient().getAccount());
	}

	@Test
	@Order(9)
	void testGetAllOrders() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(getClient().getAllOrders(new AllOrdersParams(symbol)), List.of("accountId"), true);
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(10)
	void testGetAllOrders2() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(getClient().getAllOrders(new AllOrdersParams(symbol, orderId)), List.of("accountId"), true);
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(11)
	void testGetTrades() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(getClient().getTrades(new TradesParams(orderId, symbol)));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	// @Test OK works!
	// @Order(12)
	void testNewOCOAndGetOCO() throws ApiException {
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		var oco = new NewOCOOrderParams(ocoSymbol, OrderSide.BUY, ocoQuantity, ocoPrice, ocoStopPrice, ocoStopPrice,
				TimeInForce.GTC);

		var res = getClient().newOCO(oco).sync();
		orderListId = res.orderListId();
		testHasNulls(res, List.of("orderReports[1].stopPrice"), false);
		testNotThrow(getClient().getOCO(new OCOInfoParams(res.orderListId())));
		getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	// @Test OK works!
	// @Order(14)
	void testCancelOpenOCO() throws ApiException {
		getClient().getOpenOCO().sync().forEach(oo -> {
			testNoNulls(oo);
			try {
				var resp = getClient().cancelOCO(new CancelOCOParams(oo.symbol(), oo.orderListId())).sync();
				getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
				testHasNulls(resp, List.of("orderReports[1].stopPrice"), false);
				getClient().getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	@Order(15)
	void testGetAllOCO() throws ApiException {
		testNotThrow(getClient().getAllOCO());
	}

	@Test
	@Order(16)
	void testGetAllOCO2() throws ApiException {
		testNotThrow(getClient().getAllOCO(new AllOCOInfoParams(orderId)));
	}

	@Test
	@Order(17)
	void testGetAllOCO3() throws ApiException {
		testNotThrow(getClient().getAllOCO(new AllOCOInfoParams(orderId), new TimeFrame(limit)));
	}

	@Test
	@Order(18)
	void testGetAllOCO4() throws ApiException {
		testNotThrow(getClient().getAllOCO(new TimeFrame(limit)));
	}
}
