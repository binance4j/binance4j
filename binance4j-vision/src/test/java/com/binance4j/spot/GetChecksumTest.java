package com.binance4j.spot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.vision.spot.VisionChecksum;

public class GetChecksumTest extends SpotTest {
	@Test

	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTradesChecksum(symbol, year, month, "32").getChecksum());

		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test

	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTradesChecksum(symbol, "1995", month, day).getChecksum());

		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test

	void testKlinesChecksum() throws ApiException {
		VisionChecksum checksum = client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum();
		test(checksum);
	}

	@Test

	void testTradesChecksum() throws ApiException {
		VisionChecksum checksum = client.getTradesChecksum(symbol, year, month, day).getChecksum();
		test(checksum);
	}

	@Test

	void testAggTradesChecksum() throws ApiException {
		VisionChecksum checksum = client.getAggTradesChecksum(symbol, year, month, day).getChecksum();
		test(checksum);
	}
}
