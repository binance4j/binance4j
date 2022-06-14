package com.binance4j.vision.spot;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * The representation of a trade
 */
@Data
@NoArgsConstructor
public class VisionTrade {
	/**
	 * The trade id
	 */
	private Long tradeId;
	/**
	 * The timestamp
	 */
	private Long time;
	/**
	 * The price
	 */
	private BigDecimal price;
	/**
	 * The quantity
	 */
	private BigDecimal quantity;
	/**
	 * The quote asset quantity
	 */
	private BigDecimal quoteQuantity;
	/**
	 * Was it a buyer maker
	 */
	private Boolean isBuyerMaker;
	/**
	 * Was it the best price match?
	 */
	private Boolean isBestMatch;

	public VisionTrade(List<String> input) {
		setTradeId(Long.parseLong(input.get(0)));
		setPrice(new BigDecimal(input.get(1)));
		setQuantity(new BigDecimal(input.get(2)));
		setQuoteQuantity(new BigDecimal(input.get(3)));
		setTime(Long.parseLong(input.get(4)));
		setIsBuyerMaker(Boolean.parseBoolean(input.get(5)));
		setIsBestMatch(Boolean.parseBoolean(input.get(6)));
	}
}
