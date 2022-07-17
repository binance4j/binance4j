package com.binance4j.vision.dto;

import java.math.BigDecimal;
import java.util.List;

/** The representation of a trade */
public record VisionTrade(
		/** The trade id. */
		Long tradeId,
		/** The timestamp. */
		Long time,
		/** The price. */
		BigDecimal price,
		/** The quantity. */
		BigDecimal quantity,
		/** The quote asset quantity. */
		BigDecimal quoteQuantity,
		/** Was it a buyer maker. */
		Boolean isBuyerMaker, /** Was it the best price match?. */
		Boolean isBestMatch) {
	public VisionTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), Long.parseLong(input.get(4)), new BigDecimal(input.get(1)), new BigDecimal(input.get(2)),
				new BigDecimal(input.get(3)), Boolean.parseBoolean(input.get(5)), Boolean.parseBoolean(input.get(6)));
	}
}
