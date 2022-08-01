package com.binance4j.market.dto;

/**
 * 24 hour price change statistics for a ticker.
 * 
 * @param symbol             Ticker symbol.
 * @param priceChange        Price change during the last 24 hours.
 * @param priceChangePercent Price change; in percentage; during the last 24 hours.
 * @param weightedAvgPrice   Weighted average price.
 * @param prevClosePrice     Previous close price.
 * @param lastPrice          Last price.
 * @param lastQuantity       Last quantity.
 * @param bidPrice           Bid price.
 * @param bidQuantity        Bid quantity.
 * @param askPrice           Ask price.
 * @param askQuantity        Ask quantity.
 * @param openPrice          Open price 24 hours ago.
 * @param highPrice          Highest price during the past 24 hours.
 * @param lowPrice           Lowest price during the past 24 hours.
 * @param volume             Total volume during the past 24 hours.
 * @param quoteVolume        Total quote volume during the past 24 hours.
 * @param openTime           Open time.
 * @param closeTime          Close time.
 * @param firstId            First trade id.
 * @param lastId             Last trade id.
 * @param count              Total number of trades during the last 24 hours.
 */
public record TickerStatistics(String symbol, String priceChange, String priceChangePercent, String weightedAvgPrice, String prevClosePrice, String lastPrice,
		String lastQty, String bidPrice, String bidQty, String askPrice, String askQty, String openPrice, String highPrice, String lowPrice, String volume,
		String quoteVolume, long openTime, long closeTime, long firstId, long lastId, long count) {
}
