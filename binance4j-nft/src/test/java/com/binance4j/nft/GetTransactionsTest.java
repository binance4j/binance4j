package com.binance4j.nft;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.service.TestService;
import com.binance4j.nft.transaction.NFTOrderType;
import com.binance4j.nft.transaction.NFTTransactionHistory;
import com.binance4j.nft.transaction.NFTTransactionHistoryRequest;

/**
 * Tests the transaction history request
 */
public class GetTransactionsTest {
	final NFTClient client = TestService.CLIENT;
	final int limit = 25;
	final int page = 1;

	@Test
	@DisplayName("It should return a non null result")
	void testPurchaseOrder() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.PURCHASE_ORDER);
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testMintFee() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.MINT_FEE);
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testPrimaryMarketOrder() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.PRIMARY_MARKET_ORDER);
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testRoyaltyIncome() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.ROYALTY_INCOME);
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testSellOrder() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.SELL_ORDER);
		test(req);
	}

	@Test
	@DisplayName("It should return a non null result")
	void testLimitAndPage() throws ApiException {
		NFTTransactionHistoryRequest req = new NFTTransactionHistoryRequest(NFTOrderType.SELL_ORDER, limit, page);
		testLimit(req);
	}

	/**
	 * Tests that the result fields ar not null
	 *
	 * @param req The request
	 * @throws ApiException The Exception sent by the server
	 */
	NFTTransactionHistory test(NFTTransactionHistoryRequest req) throws ApiException {
		NFTTransactionHistory history = client.getTransactions(req).execute();


		assertNotNull(history.getTotal());

		history.getList().forEach(transaction -> {
			assertNotNull(transaction.getOrderNo());
			assertNotNull(transaction.getTradeAmount());
			assertNotNull(transaction.getTradeCurrency());
			assertNotNull(transaction.getTradeTime());

			transaction.getTokens().forEach(token -> {
				assertNotNull(token.getContractAddress());
				assertNotNull(token.getNetwork());
				assertNotNull(token.getTokenId());
			});
		});
		return history;
	}

	/**
	 * Tests that the result fields ar not null and that the total is inferior or
	 * equal to the request limit
	 *
	 * @param req The request
	 * @throws ApiException The Exception sent by the server
	 */
	void testLimit(NFTTransactionHistoryRequest req) throws ApiException {
		NFTTransactionHistory history = test(req);
		assertTrue(history.getTotal() <= limit);
	}
}
