package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.OrderStatusRequest;
import com.binance4j.spot.service.TestService;

public class GetOrderStatusTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOrderStatus() throws ApiException {
		// params should be changed to match your own order
		String symbol = "GMTBUSD";
		Long id = 65293729L;

		OrderInfo order = client.getOrderStatus(new OrderStatusRequest(symbol, id)).execute();
		assertNull(order.isIsolated());
		assertNotNull(order.getClientOrderId());
		assertNotNull(order.getCummulativeQuoteQty());
		assertNotNull(order.getExecutedQty());
		assertNotNull(order.getIcebergQty());
		assertNotNull(order.isWorking());
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
