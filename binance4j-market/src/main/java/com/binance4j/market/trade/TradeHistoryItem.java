package com.binance4j.market.trade;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/** Represents an executed trade history item. */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeHistoryItem {
	/** The trade id. */
	private Long id;
	/** The trad price. */
	private String price;
	/** The trade volume. */
	@JsonProperty("qty")
	private String quantity;
	/** The trade opposite volume. */
	@JsonProperty("quoteQty")
	private String quoteQuantity;
	/** The trade execution in ms. */
	private Long time;
	/** Is the trade a buyer maker trade. */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isBuyerMaker;
	/** Was the trade the best price match?. */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isBestMatch;

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
