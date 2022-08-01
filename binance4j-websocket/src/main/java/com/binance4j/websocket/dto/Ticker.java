package com.binance4j.websocket.dto;

/**
 * Pair ticker.
 * 
 * @param eventType                   The event type.
 * @param eventTime                   The timestamp.
 * @param symbol                      The trading pair.
 * @param priceChange                 The price change.
 * @param priceChangePercent          The price change percent.
 * @param weightedAveragePrice        The weighted average price.
 * @param previousDaysClosePrice      The previous days close price.
 * @param currentDaysClosePrice       The current days close price.
 * @param closeTradesQuantity         Last quantity.
 * @param bestBidPrice                Best bid price.
 * @param bestBidQuantity             Best bid quantity.
 * @param bestAskPrice                Best ask price.
 * @param bestAskQuantity             Best ask quantity.
 * @param openPrice                   The open price.
 * @param highPrice                   The highest price.
 * @param lowPrice                    The lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 * @param statisticsOpenTime          Statistics open time.
 * @param statisticsCloseTime         Statistics close time.
 * @param firstTradeId                First trade ID.
 * @param lastTradeId                 Last trade Id.
 * @param totalNumberOfTrades         Total number of trades.
 */
public record Ticker(String e, Long E, String s, String p, String P, String w, String x, String c, String Q, String b, String B, String a, String A, String o,
		String h, String l, String v, String q, Long O, Long C, Long F, Long L, Long n) {
}