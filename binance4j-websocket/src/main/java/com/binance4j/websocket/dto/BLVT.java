package com.binance4j.websocket.dto;

import java.util.List;

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
public record BLVT(String e, long E, String s, String m, @JsonProperty("b") List<BLVTBasket> baskets, String n, String l, int t, String f) {
}