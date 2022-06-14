package com.binance4j.spot.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.order.Trade;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.MyTradesRequest;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetTradesTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("Properties shouldn't be null or ApiException should not be null")
	public void testGetMyTrades() throws ApiException {
		List<Trade> trades = client.getMyTrades(new MyTradesRequest("APEBUSD")).execute();

		if (!trades.isEmpty()) {
			Trade trade = trades.get(0);
			assertNotNull(trade.getCommission());
			assertNotNull(trade.getCommissionAsset());
			assertNotNull(trade.getId());
			assertNotNull(trade.getIsBestMatch());
			assertNotNull(trade.getIsBuyer());
			assertNotNull(trade.getIsMaker());
			assertNotNull(trade.getOrderId());
			assertNotNull(trade.getPrice());
			assertNotNull(trade.getQty());
			assertNotNull(trade.getQuoteQty());
			assertNotNull(trade.getSymbol());
			assertNotNull(trade.getTime());
		}
	}

}
