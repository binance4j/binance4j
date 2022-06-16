package com.binance4j.vision.spot;

import java.math.BigDecimal;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isBuyerMaker;
	/**
	 * Was it the best price match?
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isBestMatch;

	public VisionTrade(List<String> input) {
		setTradeId(Long.parseLong(input.get(0)));
		setPrice(new BigDecimal(input.get(1)));
		setQuantity(new BigDecimal(input.get(2)));
		setQuoteQuantity(new BigDecimal(input.get(3)));
		setTime(Long.parseLong(input.get(4)));
		isBuyerMaker(Boolean.parseBoolean(input.get(5)));
		isBestMatch(Boolean.parseBoolean(input.get(6)));
	}

	public Boolean isBestMatch() {
		return isBestMatch;
	}

	public void isBestMatch(boolean isBestMatch) {
		this.isBestMatch = isBestMatch;
	}

	public Boolean isBuyerMaker() {
		return isBuyerMaker;
	}

	public void isBuyerMaker(boolean isBuyerMaker) {
		this.isBuyerMaker = isBuyerMaker;
	}
}
