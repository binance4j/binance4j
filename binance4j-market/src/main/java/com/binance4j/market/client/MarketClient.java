package com.binance4j.market.client;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.market.dto.AveragePrice;
import com.binance4j.market.dto.BookTicker;
import com.binance4j.market.dto.ExchangeInfo;
import com.binance4j.market.dto.OrderBook;
import com.binance4j.market.dto.PriceTicker;
import com.binance4j.market.dto.ServerTimeResponse;
import com.binance4j.market.dto.TickerStatistics;
import com.binance4j.market.dto.Trade;
import com.binance4j.market.param.AggTradeParams;
import com.binance4j.market.param.AveragePriceParams;
import com.binance4j.market.param.BookTickerParams;
import com.binance4j.market.param.BookTickersParams;
import com.binance4j.market.param.ExchangeInfoParams;
import com.binance4j.market.param.HistoricalTradesParams;
import com.binance4j.market.param.KlinesParams;
import com.binance4j.market.param.OrderBookParams;
import com.binance4j.market.param.PriceTickerParams;
import com.binance4j.market.param.PriceTickersParams;
import com.binance4j.market.param.TickerStatisticsParams;
import com.binance4j.market.param.TickersStatisticsParams;
import com.binance4j.market.param.TradesParams;

/**
 * API client for the market endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#market-data-endpoints">Documentation</a>
 */
public class MarketClient extends RestClient<MarketMapping> {
	/**
	 * @param key    API public key.
	 * @param secret API secret key.
	 */
	public MarketClient(String key, String secret) {
		super(MarketMapping.class, key, secret);
	}

	/**
	 * Test connectivity to the Rest API.
	 * 
	 * @return The request to execute.
	 */
	public Request<Void> ping() {
		return new Request<>(service.ping());
	}

	/**
	 * Test connectivity to the Rest API and get the current server time.
	 * 
	 * @return The request to execute.
	 */
	public Request<ServerTimeResponse> getServerTime() {
		return new Request<>(service.getServerTime());
	}

	/**
	 * Get current exchange trading rules and one or many symbols informations.
	 * <p>
	 * If any symbol provided in either {@code symbol} or {@code symbols} do not
	 * exist, the endpoint will throw an error.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<ExchangeInfo> getExchangeInfo(ExchangeInfoParams params) {
		return new Request<>(service.getExchangeInfo(params.toMap()));
	}

	/**
	 * Get current exchange trading rules and all symbols informations.
	 * 
	 * @return The request to execute.
	 */
	public Request<ExchangeInfo> getExchangeInfo() {
		return getExchangeInfo(new ExchangeInfoParams());
	}

	/**
	 * Get the symbol order book.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<OrderBook> getOrderBook(OrderBookParams params) {
		return new Request<>(service.getOrderBook(params.toMap()));
	}

	/**
	 * Get recent trades.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getTrades(TradesParams params) {
		return new Request<>(service.getTrades(params.toMap()));
	}

	/**
	 * Get older market trades.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Trade>> getHistoricalTrades(HistoricalTradesParams params) {
		return new Request<>(service.getHistoricalTrades(params.toMap()));
	}

	/**
	 * Get compressed, aggregate trades. Trades that fill at the time, from the same
	 * order, with the same price will have
	 * the quantity aggregated.
	 * <p>
	 * If {@code startTime}, and {@code endTime} are sent, time between startTime
	 * and endTime must be less than 1 hour.
	 * <p>
	 * If {@code fromId}, {@code startTime}, and {@code endTime} are not sent, the
	 * most recent aggregate trades will be
	 * returned.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<AggTrade>> getAggTrades(AggTradeParams params) {
		return new Request<>(service.getAggTrades(params.toMap()));
	}

	/**
	 * Get compressed, aggregate trades. Trades that fill at the time, from the same
	 * order, with the same price will have
	 * the quantity aggregated.
	 * <p>
	 * If {@code startTime}, and {@code endTime} are sent, time between startTime
	 * and endTime must be less than 1 hour.
	 * <p>
	 * If {@code fromId}, {@code startTime}, and {@code endTime} are not sent, the
	 * most recent aggregate trades will be
	 * returned.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval search.
	 * @return The request to execute.
	 */
	public Request<List<AggTrade>> getAggTrades(AggTradeParams params, TimeFrame timeFrame) {
		return new Request<>(service.getAggTrades(Params.merge(params, timeFrame)));
	}

	/**
	 * Kline/candles for a symbol.
	 * <p>
	 * Klines are uniquely identified by their open time.
	 * <p>
	 * If {@code startTime</code> and <code>endTime} are not sent, the most recent
	 * klines are returned.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<Candle>> getKlines(KlinesParams params) {
		return new Request<>(service.getKlines(params.toMap()));
	}

	/**
	 * Kline/candles for a symbol.
	 * <p>
	 * Klines are uniquely identified by their open time.
	 * <p>
	 * If {@code startTime</code> and <code>endTime} are not sent, the most recent
	 * klines are returned.
	 * 
	 * @param params    Request params.
	 * @param timeFrame Time interval search.
	 * @return The request to execute.
	 */
	public Request<List<Candle>> getKlines(KlinesParams params, TimeFrame timeFrame) {
		return new Request<>(service.getKlines(Params.merge(params, timeFrame)));
	}

	/**
	 * Get Current average price for a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<AveragePrice> getAveragePrice(AveragePriceParams params) {
		return new Request<>(service.getAveragePrice(params.toMap()));
	}

	/**
	 * Get 24 hour rolling window price change statistics of a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<TickerStatistics> get24hTickerStatistics(TickerStatisticsParams params) {
		return new Request<>(service.get24hTickerStatistics(params.toMap()));
	}

	/**
	 * Get 24 hour rolling window price change statistics of all symbols.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<TickerStatistics>> get24hTickerStatistics() {
		return new Request<>(service.get24hTickerStatistics());
	}

	/**
	 * Get 24 hour rolling window price change statistics of specific symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<TickerStatistics>> get24hTickerStatistics(TickersStatisticsParams params) {
		return new Request<>(service.get24hTickersStatistics(params.toMap()));
	}

	/**
	 * Latest price for all symbols.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<PriceTicker>> getTicker() {
		return new Request<>(service.getTicker());
	}

	/**
	 * Latest price for a symbol or symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<PriceTicker> getTicker(PriceTickerParams params) {
		return new Request<>(service.getTicker(params.toMap()));
	}

	/**
	 * Latest price for a symbol or symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<PriceTicker>> getTicker(PriceTickersParams params) {
		return new Request<>(service.getTickers(params.toMap()));
	}

	/**
	 * Get best price/quantity on the order book for a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<BookTicker> getBookTicker(BookTickerParams params) {
		return new Request<>(service.getBookTicker(params.toMap()));
	}

	/**
	 * Get best price/quantity on the order book for all symbols.
	 * 
	 * @return The request to execute.
	 */
	public Request<List<BookTicker>> getBookTicker() {
		return new Request<>(service.getBookTicker());
	}

	/**
	 * Get best price/quantity on the order book for the given symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Request<List<BookTicker>> getBookTicker(BookTickersParams params) {
		return new Request<>(service.getBookTickers(params.toMap()));
	}
}
