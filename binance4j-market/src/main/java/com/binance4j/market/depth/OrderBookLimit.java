package com.binance4j.market.depth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The order book result size
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public enum OrderBookLimit {
	LIMIT_5(5), LIMIT_10(10), LIMIT_20(20), LIMIT_50(50), LIMIT_100(100), LIMIT_500(500), LIMIT_1000(1000),
	LIMIT_5000(5000);

	@Getter
	private final int value;
}
