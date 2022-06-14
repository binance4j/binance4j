package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OrderInfo;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.AllOrdersRequest;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetAllOrdersTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

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

}
