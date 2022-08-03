package com.binance4j.nft.client;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.test.CustomTest;
import com.binance4j.nft.dto.OrderType;
import com.binance4j.nft.param.TransactionHistoryParams;

public class NFTClientTest extends CustomTest {
	int page = 1;
	NFTClient client = new NFTClient(key, secret);

	@Test
	void testGetAssets() throws ApiException {
		testNoNulls(client.getAssets());
	}

	@Test
	void testGetAssets2() throws ApiException {
		testNoNulls(client.getAssets(new Paging(1)));
	}

	@Test
	void testGetDeposits() throws ApiException {
		testNoNulls(client.getDeposits());
	}

	@Test
	void testGetDeposits2() throws ApiException {
		testNoNulls(client.getDeposits(new FramedPaging(page)));
	}

	@Test
	void testGetTransactions() throws ApiException {
		for (var o : OrderType.values()) {
			testNoNulls(client.getTransactions(new TransactionHistoryParams(o)));
		}
	}

	@Test
	void testGetTransactions2() throws ApiException {
		testNoNulls(client.getTransactions(new TransactionHistoryParams(OrderType.SELL_ORDER), new FramedPaging(page)));
	}

	@Test
	void testGetWithdraws() throws ApiException {
		testNoNulls(client.getWithdraws());
	}

	@Test
	void testGetWithdraws2() throws ApiException {
		testNoNulls(client.getWithdraws(new FramedPaging(1)));
	}
}
