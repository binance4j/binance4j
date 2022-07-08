package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderSide;

public class NewOCOTest extends SpotTest {

	// @Test
	// TODO find a symbol authorizing STOP_LOSS
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testNewOCO() {
		try {
			OCOOrder req = new OCOOrder("BTCBUSD", OrderSide.BUY,
					new BigDecimal(1), new BigDecimal(50000), new BigDecimal(55000));
			OCOResponse res = client.newOCO(req).execute();
			test(res);
			assertTrue(getNullProperties(res).contains("OCOResponse.isIsolated"));
		} catch (ApiException e) {
			fail();
		}
	}
}
