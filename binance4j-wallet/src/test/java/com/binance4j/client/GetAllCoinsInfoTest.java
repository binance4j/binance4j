package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.coinsinfo.CoinInformation;

class GetAllCoinsInfoTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the coins info")
	void testGetAllCoinsInfo() throws ApiException {
		List<CoinInformation> infos = client.getAllCoinsInfo().execute();

		infos.forEach(i -> {
			if (i.getCoin().equals("BNB")) {

			}
			assertNotNull(i.getCoin());
			assertNotNull(i.getDepositAllEnable());
			assertNotNull(i.getFree());
			assertNotNull(i.getFreeze());
			assertNotNull(i.getIpoable());
			assertNotNull(i.getIpoing());
			assertNotNull(i.getIsLegalMoney());
			assertNotNull(i.getLocked());
			assertNotNull(i.getName());
			assertNotNull(i.getNetworkList());
			assertNotNull(i.getStorage());
			assertNotNull(i.getTrading());
			assertNotNull(i.getWithdrawAllEnable());
			assertNotNull(i.getWithdrawing());
		});
	}
}
