package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.service.TestService;

public class NewOCOTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	// @Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testNewOCO() {
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

			fail();
		}
	}
}
