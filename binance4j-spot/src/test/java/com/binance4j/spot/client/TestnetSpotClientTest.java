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
import com.binance4j.spot.param.NewOCOOrderParams;
import com.binance4j.spot.param.NewOrderParams;
import com.binance4j.spot.param.OCOInfoParams;
import com.binance4j.spot.param.OrderStatusParams;
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

	public TestnetSpotClientTest() {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(0)
	void testNewOrderTest() throws ApiException {
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buy(symbol, "1")).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sell(symbol, "1")).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buy(symbol, "1", price)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sell(symbol, "1", price)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buy(symbol, "1", price, TimeInForce.FOK)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sell(symbol, "1", price, TimeInForce.FOK)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buy(symbol, "1", price, TimeInForce.GTC)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sell(symbol, "1", price, TimeInForce.GTC)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buy(symbol, "1", price, TimeInForce.IOC)).sync());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sell(symbol, "1", price, TimeInForce.IOC)).sync());
	}

	@Test
	@Order(1)
	void testNewOrderMarket() throws ApiException {
		// buy market
		testNotThrow(client.newOrder(NewOrderParams.buy(symbol, quantity)));
		// Sell market
		testNotThrow(client.newOrder(NewOrderParams.sell(symbol, quantity)));
	}

	@Test
	@Order(2)
	void testNewOrderBuyLimit() throws ApiException {
		// buy limit
		testNotThrow(client.newOrder(NewOrderParams.buy(symbol, quantity, "0.011160")));
	}

	@Test
	@Order(3)
	void testCancelOpenOrders() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		// cancel orders
		testNotThrow(client.cancelOpenOrders(new CancelOpenOrdersParams(symbol)));
		var orders = client.getOpenOrders().sync();
		assertEquals(orders.size(), 0);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(4)
	void testGetOpenOrders() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getOpenOrders());
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(5)
	void testGetOrderStatus() throws ApiException {
		// buy
		var buyOrder = client.newOrder(NewOrderParams.buy(symbol, quantity)).sync();
		// get order status
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getOrderStatus(new OrderStatusParams(symbol, buyOrder.orderId())));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
		// Sell
		client.newOrder(NewOrderParams.sell(symbol, buyOrder.executedQty())).sync();
	}

	@Test
	@Order(6)
	void testCancelOrder() throws ApiException {
		// buy limit
		var buyOrder = client.newOrder(NewOrderParams.buy(symbol, quantity, "0.011160")).sync();
		assertTrue(buyOrder.side().equals("BUY"));
		testNoNulls(client.newOrder(NewOrderParams.buy(symbol, quantity, "0.011160")));
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
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getAllOrders(new AllOrdersParams(symbol)), List.of("accountId"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(10)
	void testGetAllOrders2() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testHasNulls(client.getAllOrders(new AllOrdersParams(symbol, orderId)), List.of("accountId"), true);
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	@Test
	@Order(11)
	void testGetTrades() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		testNotThrow(client.getTrades(new TradesParams(orderId, symbol)));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	// @Test OK works!
	// @Order(12)
	void testNewOCOAndGetOCO() throws ApiException {
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
		var oco = new NewOCOOrderParams(ocoSymbol, OrderSide.BUY, ocoQuantity, ocoPrice, ocoStopPrice, ocoStopPrice, TimeInForce.GTC);

		var res = client.newOCO(oco).sync();
		orderListId = res.orderListId();
		testHasNulls(res, List.of("orderReports[1].stopPrice"), false);
		testNotThrow(client.getOCO(new OCOInfoParams(res.orderListId())));
		client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
	}

	// @Test OK works!
	// @Order(14)
	void testCancelOpenOCO() throws ApiException {
		client.getOpenOCO().sync().forEach(oo -> {
			testNoNulls(oo);
			try {
				var resp = client.cancelOCO(new CancelOCOParams(oo.symbol(), oo.orderListId())).sync();
				client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
				testHasNulls(resp, List.of("orderReports[1].stopPrice"), false);
				client.getMapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
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
