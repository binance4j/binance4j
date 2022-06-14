package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.OCOInfo;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetOpenOcoTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetOpenOCO() throws ApiException {
		List<OCOInfo> ocos = client.getOpenOCO().execute();
		if (!ocos.isEmpty()) {
			OCOInfo oco = ocos.get(0);
			assertNotNull(oco.getContingencyType());
			assertNotNull(oco.getListClientOrderId());
			assertNotNull(oco.getListOrderStatus());
			assertNotNull(oco.getListStatusType());
			assertNotNull(oco.getOrderListId());
			assertNotNull(oco.getOrders());
			assertNotNull(oco.getSymbol());
			assertNotNull(oco.getTransactionTime());
		}
	}
}
