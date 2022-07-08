package com.binance4j.spot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.vision.spot.VisionChecksum;

public class GetChecksumTest extends SpotTest {
	@Test
	@DisplayName("It should throw an InvalidDateException")
	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTradesChecksum(symbol, year, month, "32").getChecksum());

		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test
	@DisplayName("It should throw a NotFoundException")
	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTradesChecksum(symbol, "1995", month, day).getChecksum());

		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test
	@DisplayName("It should return the klines cheksum")
	void testKlinesChecksum() throws ApiException {
		VisionChecksum checksum = client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum();
		test(checksum);
	}

	@Test
	@DisplayName("It should return the trades checksum")
	void testTradesChecksum() throws ApiException {
		VisionChecksum checksum = client.getTradesChecksum(symbol, year, month, day).getChecksum();
		test(checksum);
	}

	@Test
	@DisplayName("It should return the agg trades cheksum")
	void testAggTradesChecksum() throws ApiException {
		VisionChecksum checksum = client.getAggTradesChecksum(symbol, year, month, day).getChecksum();
		test(checksum);
	}
}
