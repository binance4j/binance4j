package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.nft.dto.OrderType;
import com.binance4j.nft.dto.TransactionHistory;
import com.binance4j.nft.param.TransactionHistoryParams;

/** Tests the transaction history request */
public class GetTransactionsTest extends NFTTest {
	@Test
	void testSellOrder() throws ApiException {
		List.of(OrderType.values()).forEach(v -> {
			TransactionHistoryParams params = new TransactionHistoryParams(v);
			TransactionHistory history;
			try {
				history = client.getTransactions(params).execute();
				testNoNulls(history);
			} catch (ApiException e) {
				fail();
			}
		});
	}

	@Test
	void testLimitAndPage() throws ApiException {
		TransactionHistoryParams params = new TransactionHistoryParams(OrderType.SELL_ORDER);
		TransactionHistory history = client.getTransactions(params, new FramedPaging(page)).execute();
		testNoNulls(history);
		assertTrue(history.total() <= limit);
	}
}
