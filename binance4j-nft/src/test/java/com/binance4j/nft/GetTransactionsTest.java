package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.transaction.NFTOrderType;
import com.binance4j.nft.transaction.NFTTransactionHistory;
import com.binance4j.nft.transaction.NFTTransactionHistoryParams;

/**
 * Tests the transaction history request
 */
public class GetTransactionsTest extends NFTTest {
	@Test
	void testSellOrder() throws ApiException {
		Arrays.asList(NFTOrderType.values()).forEach(v -> {
			NFTTransactionHistoryParams params = new NFTTransactionHistoryParams(v);
			NFTTransactionHistory history;
			try {
				history = client.getTransactions(params).execute();
				test(history);
			} catch (ApiException e) {
				fail();
			}
		});
	}

	@Test
	void testLimitAndPage() throws ApiException {
		NFTTransactionHistoryParams params = new NFTTransactionHistoryParams(NFTOrderType.SELL_ORDER, limit, page);
		NFTTransactionHistory history = client.getTransactions(params).execute();
		test(history);
		assertTrue(history.getTotal() <= limit);
	}
}
