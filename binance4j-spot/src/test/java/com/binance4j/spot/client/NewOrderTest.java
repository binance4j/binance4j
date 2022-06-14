package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.NewOrder;
import com.binance4j.spot.order.NewOrderResponse;
import com.binance4j.spot.service.TestService;

class NewOrderTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	// @Test
	@DisplayName("Test must not throw an exception")
	void testNewOrder() throws ApiException {
		// /!\ Change the values /!\
		NewOrder order = NewOrder.buyLimit("BTCBUSD", new BigDecimal("1"), new BigDecimal("25000"));
		NewOrderResponse res = client.newOrder(order).execute();

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
}
