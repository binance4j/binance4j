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

	@Test
	@Order(0)
	void testNewOrderTest() throws ApiException {
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buyMarket(symbol, "1")).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sellMarket(symbol, "1")).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buyLimit(symbol, "1", price)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sellLimit(symbol, "1", price)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buyLimit(symbol, "1", price, TimeInForce.FOK)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sellLimit(symbol, "1", price, TimeInForce.FOK)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buyLimit(symbol, "1", price, TimeInForce.GTC)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sellLimit(symbol, "1", price, TimeInForce.GTC)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.buyLimit(symbol, "1", price, TimeInForce.IOC)).fetch());
		assertDoesNotThrow(() -> client.newOrderTest(NewOrderParams.sellLimit(symbol, "1", price, TimeInForce.IOC)).fetch());
	}

	@Test
	@Order(1)
	void testNewOrderMarket() throws ApiException {
		// buy market
		var buyOrder = client.newOrder(NewOrderParams.buyMarket(symbol, quantity)).fetch();
		assertTrue(buyOrder.side().equals("BUY"));
		testNoNulls(buyOrder);
		// Sell market
		var sellOrder = client.newOrder(NewOrderParams.sellMarket(symbol, buyOrder.executedQty())).fetch();
		assertTrue(sellOrder.side().equals("SELL"));
		testNoNulls(sellOrder);
	}

	@Test
	@Order(2)
	void testNewOrderBuyLimit() throws ApiException {
		// buy limit
		var buyOrder = client.newOrder(NewOrderParams.buyLimit(symbol, quantity, "0.011160")).fetch();
		assertTrue(buyOrder.side().equals("BUY"));
		testNoNulls(buyOrder);
	}

	@Test
	@Order(3)
	void testCancelOpenOrders() throws ApiException {
		// cancel orders
		var cancellation = client.cancelOpenOrders(new CancelOpenOrdersParams(symbol)).fetch();
		testNoNulls(cancellation);
		var orders = client.getOpenOrders().fetch();
		assertEquals(orders.size(), 0);
	}

	@Test
	@Order(4)
	void testGetOpenOrders() throws ApiException {
		testNoNulls(client.getOpenOrders());
	}

	@Test
	@Order(5)
	void testGetOrderStatus() throws ApiException {
		// buy
		var buyOrder = client.newOrder(NewOrderParams.buyMarket(symbol, quantity)).fetch();
		// get order status
		testHasNulls(client.getOrderStatus(new OrderStatusParams(symbol, buyOrder.orderId())), List.of("accountId"), false);
		// Sell
		client.newOrder(NewOrderParams.sellMarket(symbol, buyOrder.executedQty())).fetch();
	}

	@Test
	@Order(6)
	void testCancelOrder() throws ApiException {
		// buy limit
		var buyOrder = client.newOrder(NewOrderParams.buyLimit(symbol, quantity, "0.011160")).fetch();
		assertTrue(buyOrder.side().equals("BUY"));
		testNoNulls(buyOrder);
		var cancellation = client.cancelOrder(new CancelOrderParams(symbol, buyOrder.orderId()));
		testNoNulls(cancellation);
		orderId = buyOrder.orderId();
	}

	@Test
	@Order(7)
	void testGetOrderCount() throws ApiException {
		testNoNulls(client.getOrderCount());
	}

	@Test
	@Order(8)
	void testGetAccount() throws ApiException {
		testNoNulls(client.getAccount());
	}

	@Test
	@Order(9)
	void testGetAllOrders() throws ApiException {
		testHasNulls(client.getAllOrders(new AllOrdersParams(symbol)), List.of("accountId"), true);
	}

	@Test
	@Order(10)
	void testGetAllOrders2() throws ApiException {
		testHasNulls(client.getAllOrders(new AllOrdersParams(symbol, orderId)), List.of("accountId"), true);
	}

	@Test
	@Order(11)
	void testGetMyTrades() throws ApiException {
		testNoNulls(client.getTrades(new TradesParams(orderId, symbol)));
	}

	@Test
	@Order(12)
	void testNewOCOAndGetOCO() throws ApiException {
		var oco = new NewOCOOrderParams(ocoSymbol, OrderSide.BUY, ocoQuantity, ocoPrice, ocoStopPrice);
		oco.setStopLimitPrice(ocoStopPrice);
		oco.setStopLimitTimeInForce(TimeInForce.GTC);

		var res = client.newOCO(oco).fetch();
		System.out.println(res);
		orderListId = res.orderListId();
		testHasNulls(res, List.of("orderReports[1].stopPrice"), false);
		testNoNulls(client.getOCO(new OCOInfoParams(res.orderListId())));
	}

	@Test
	@Order(14)
	void testCancelOpenOCO() throws ApiException {
		client.getOpenOCO().fetch().forEach(oo -> {
			testNoNulls(oo);
			try {
				var resp = client.cancelOCO(new CancelOCOParams(oo.symbol(), oo.orderListId())).fetch();
				testHasNulls(resp, List.of("orderReports[1].stopPrice"), false);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		});
	}

	@Test
	@Order(15)
	void testGetAllOCO() throws ApiException {
		testNoNulls(client.getAllOCO());
	}

	@Test
	@Order(16)
	void testGetAllOCO2() throws ApiException {
		testNoNulls(client.getAllOCO(new AllOCOInfoParams(orderId)));
	}

	@Test
	@Order(17)
	void testGetAllOCO3() throws ApiException {
		testNoNulls(client.getAllOCO(new AllOCOInfoParams(orderId), new TimeFrame(limit)));
	}

	@Test
	@Order(18)
	void testGetAllOCO4() throws ApiException {
		testNoNulls(client.getAllOCO(new TimeFrame(limit)));
	}
}
