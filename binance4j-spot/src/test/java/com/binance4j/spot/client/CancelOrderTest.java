package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.CancelOrderRequest;
import com.binance4j.core.order.CancelOrderResponse;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CancelOrderTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

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
}
