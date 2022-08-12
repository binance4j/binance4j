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

	@Override
	protected NFTClient getClient() {
		return client;
	}

	@Test
	void testGetAssets() throws ApiException {
		testNotThrow(getClient().getAssets());
	}

	@Test
	void testGetAssets2() throws ApiException {
		testNotThrow(getClient().getAssets(new Paging(1)));
	}

	@Test
	void testGetDeposits() throws ApiException {
		testNotThrow(getClient().getDeposits());
	}

	@Test
	void testGetDeposits2() throws ApiException {
		testNotThrow(getClient().getDeposits(new FramedPaging(page)));
	}

	@Test
	void testGetTransactions() throws ApiException {
		for (var o : OrderType.values()) {
			testNotThrow(getClient().getTransactions(new TransactionHistoryParams(o)));
		}
	}

	@Test
	void testGetTransactions2() throws ApiException {
		testNotThrow(
				getClient().getTransactions(new TransactionHistoryParams(OrderType.SELL_ORDER),
						new FramedPaging(page)));
	}

	@Test
	void testGetWithdraws() throws ApiException {
		testNotThrow(getClient().getWithdraws());
	}

	@Test
	void testGetWithdraws2() throws ApiException {
		testNotThrow(getClient().getWithdraws(new FramedPaging(1)));
	}
}
