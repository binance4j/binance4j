package com.binance4j.spot.client;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import com.binance4j.core.dto.OCOResponse;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.exception.ApiException;
import com.binance4j.spot.param.NewOCOOrderParams;

public class NewOCOTest extends SpotTest {

	// @Test
	// TODO find a symbol authorizing STOP_LOSS

	public void testNewOCO() {
		try {
			NewOCOOrderParams params = new NewOCOOrderParams("BTCBUSD", OrderSide.BUY, new BigDecimal(1), new BigDecimal(50000), new BigDecimal(55000));
			OCOResponse res = client.newOCO(params).execute();
			testNoNulls(res);
			assertTrue(getNullProperties(res).contains("OCOResponse.isIsolated"));
		} catch (ApiException e) {
			fail();
		}
	}
}
