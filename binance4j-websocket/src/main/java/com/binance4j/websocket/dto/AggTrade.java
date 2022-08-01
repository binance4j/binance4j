package com.binance4j.websocket.dto;

/**
 * An aggregated trade event for a symbol.
 * 
 * @param aggregatedTradeId     The agg trade id.
 * @param price                 The price.
 * @param quantity              The volume.
 * @param firstBreakdownTradeId First trade id.
 * @param lastBreakdownTradeId  Last trade id.
 * @param tradeTime             The timestamp.
 * @param isBuyerMaker          Was the buyer the maker?
 * @param eventType             The event type.
 * @param eventTime             The timestamp.
 * @param symbol                The trading pair.
 */
public record AggTrade(Long a, String p, String q, Long f, Long l, Long T, Boolean m, String e, Long E, String s) {
}