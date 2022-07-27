package com.binance4j.websocket.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Net asset value.
 * 
 * @param eventType    Event type.
 * @param eventTime    Event time.
 * @param name         Name.
 * @param tokensIssued Tokens issued.
 * @param baskets      BVLT basket.
 * @param nav          Nav.
 * @param realLeverage Real leverage.
 * @param leverage     Leverage.
 * @param fundingRatio Funding ratio.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BLVT(
		/** Event type. */
		@JsonProperty("e") String eventType,
		/** Event time. */
		@JsonProperty("E") long eventTime,
		/** Name. */
		@JsonProperty("s") String name,
		/** Tokens issued. */
		@JsonProperty("m") String tokensIssued,
		/** BVLT basket. */
		@JsonProperty("b") List<BLVTBasket> baskets,
		/** Nav. */
		@JsonProperty("n") String nav,
		/** Real leverage. */
		@JsonProperty("l") String realLeverage,
		/** Leverage. */
		@JsonProperty("t") int leverage,
		/** Funding ratio. */
		@JsonProperty("f") String fundingRatio) {
}