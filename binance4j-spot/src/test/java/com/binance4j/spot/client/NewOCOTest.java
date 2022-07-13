package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.OCOOrderParams;
import com.binance4j.core.order.OCOResponse;
import com.binance4j.core.order.OrderSide;

public class NewOCOTest extends SpotTest {

	// @Test
	// TODO find a symbol authorizing STOP_LOSS

	public void testNewOCO() {
		try {
			OCOOrderParams params = new OCOOrderParams("BTCBUSD", OrderSide.BUY,
					new BigDecimal(1), new BigDecimal(50000), new BigDecimal(55000));
			OCOResponse res = client.newOCO(params).execute();
			test(res);
			assertTrue(getNullProperties(res).contains("OCOResponse.isIsolated"));
		} catch (ApiException e) {
			fail();
		}
	}
}
