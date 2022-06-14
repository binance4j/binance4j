package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustLogRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetDustLogTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the dust transfer history")
	void testGetDustLog() throws ApiException {
		DustLog log = client.getDustLog(new DustLogRequest()).execute();

		assertNotNull(log.getTotal());

		log.getUserAssetDribblets().forEach(a -> {
			assertNotNull(a.getOperateTime());
			assertNotNull(a.getTotalServiceChargeAmount());
			assertNotNull(a.getTotalTransferedAmount());
			assertNotNull(a.getTransId());

			a.getUserAssetDribbletDetails().forEach(d -> {
				assertNotNull(d.getAmount());
				assertNotNull(d.getFromAsset());
				assertNotNull(d.getOperateTime());
				assertNotNull(d.getServiceChargeAmount());
				assertNotNull(d.getTransId());
				assertNotNull(d.getTransferedAmount());
			});
		});
	}

}
