package com.binance4j.convert;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import com.binance4j.convert.param.ConversionParams;
import com.binance4j.core.exception.ApiException;

public class GetConversionsTest extends ConvertTest {
	@Test
	void test1() throws ApiException {
		var req = getClient().getConversions(new ConversionParams(System.currentTimeMillis() - Duration.ofDays(29).toMillis(), System.currentTimeMillis()));
		System.out.println(req.execute());
		// test(req);
	}
}
