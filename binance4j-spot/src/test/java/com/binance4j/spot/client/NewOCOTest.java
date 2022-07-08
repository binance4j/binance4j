package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.test.ConcurrentTest;

public class NewOCOTest extends ConcurrentTest {
	final SpotClient client = SpotCLIENT;

	// @Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testNewOCO() {
		// TODO find a symbol authorizing STOP_LOSS
		try {
			OCOOrder req = new OCOOrder("BTCBUSD", OrderSide.BUY,
					new BigDecimal(1), new BigDecimal(50000), new BigDecimal(55000));
			OCOResponse resp = client.newOCO(req).execute();
			resp.getOrders().forEach(order -> SpothasNoNullProperty(order));
			assertTrue(SpotgetNullProperties(resp).contains("OCOResponse.isIsolated"));
		} catch (ApiException e) {
			fail();
		}
	}
}
