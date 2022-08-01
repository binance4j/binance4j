package com.binance4j.websocket.dto;

/**
 * Pair trade data.
 * 
 * @param eventType          The event type.
 * @param eventTime          The timestamp.
 * @param symbol             The trading pair.
 * @param tradeId            The trade id.
 * @param price              The price.
 * @param quantity           The price.
 * @param buyerOrderId       The buyer order id.
 * @param sellerOrderId      The seller order id.
 * @param tradeTime          The timestamp.
 * @param buyerIsMarketMaker Is the buyer the market maker?
 */
public record Trade(String e, Long E, String s, String t, String p, String q, Long b, Long a, Long T, Boolean m) {
}