package com.binance4j.market.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoParams;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.market.Candle;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.Request;
import com.binance4j.market.depth.BookTicker;
import com.binance4j.market.depth.BookTickerParams;
import com.binance4j.market.depth.BookTickersParams;
import com.binance4j.market.depth.OrderBook;
import com.binance4j.market.depth.OrderBookParams;
import com.binance4j.market.kline.KlinesParams;
import com.binance4j.market.price.AveragePrice;
import com.binance4j.market.price.AveragePriceParams;
import com.binance4j.market.price.PriceTicker;
import com.binance4j.market.price.PriceTickerParams;
import com.binance4j.market.price.PriceTickersParams;
import com.binance4j.market.tickerstatistics.TickerStatistics;
import com.binance4j.market.tickerstatistics.TickerStatisticsParams;
import com.binance4j.market.tickerstatistics.TickersStatisticsParams;
import com.binance4j.market.time.ServerTimeResponse;
import com.binance4j.market.trade.AggTradeParams;
import com.binance4j.market.trade.HistoricalTradesParams;
import com.binance4j.market.trade.TradeHistoryItem;
import com.binance4j.market.trade.TradesParams;

/**
 * API client for the market endpoints
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#market-data-endpoints">Documentation</a>
 */
public class MarketClient extends RestClient<MarketMapping> {

	/**
	 *
	 * 
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public MarketClient(String key, String secret) {
		super(MarketMapping.class, key, secret);
	}

	/** Test connectivity to the Rest API. */
	public Request<Void> ping() {
		return new Request<>(service.ping());
	}

	/** Test connectivity to the Rest API and get the current server time. */
	public Request<ServerTimeResponse> getServerTime() {
		return new Request<>(service.getServerTime());
	}

	/**
	 * Get current exchange trading rules and one or many symbols informations.
	 * <p>
	 * If any symbol provided in either {@code symbol} or
	 * {@code symbols} do not exist, the endpoint will throw an error.
	 */
	public Request<ExchangeInfo> getExchangeInfo(ExchangeInfoParams params) {
		return new Request<>(service.getExchangeInfo(params.toMap()), params);
	}

	/** Get current exchange trading rules and all symbols informations */
	public Request<ExchangeInfo> getExchangeInfo() {
		return getExchangeInfo(new ExchangeInfoParams());
	}

	/** Get the symbol order book */
	public Request<OrderBook> getOrderBook(OrderBookParams params) {
		return new Request<>(service.getOrderBook(params.toMap()), params);
	}

	/** Get recent trades. */
	public Request<List<TradeHistoryItem>> getTrades(TradesParams params) {
		return new Request<>(service.getTrades(params.toMap()), params);
	}

	/** Get older market trades. */
	public Request<List<TradeHistoryItem>> getHistoricalTrades(HistoricalTradesParams params) {
		return new Request<>(service.getHistoricalTrades(params.toMap()),
				params);
	}

	/**
	 * Get compressed, aggregate trades. Trades that fill at the time, from the same
	 * order, with the same price will have the quantity aggregated.
	 *
	 * <ul>
	 * <li>
	 * If {@code startTime</code> and <code>endTime} are sent, time
	 *          between startTime and endTime must be less than 1 hour.
	 * </li>
	 * <li>
	 * If {@code fromId</code>, <code>startTime}, and
	 * {@code endTime} are not sent, the most recent aggregate trades
	 * will be returned.
	 * </li>
	 * </ul>
	 */
	public Request<List<AggTrade>> getAggTrades(AggTradeParams params) {
		return new Request<>(service.getAggTrades(params.toMap()), params);
	}

	/**
	 * Kline/candles for a symbol.
	 * <ul>
	 * <li>
	 * Klines are uniquely identified by their open time.
	 * </li>
	 * <li>
	 * If {@code startTime</code> and <code>endTime} are not sent, the
	 * most recent klines are returned.
	 * </li>
	 * </ul>
	 */
	public Request<List<Candle>> getKlines(KlinesParams params) {
		Map<String, Object> map = params.toMap();
		// present in IntervalRequest through FramedRequest but not required by the API
		map.remove("timestamp");
		map.remove("recvWindow");
		return new Request<>(service.getKlines(map), params);
	}

	/** Get Current average price for a symbol. */
	public Request<AveragePrice> getAveragePrice(AveragePriceParams params) {
		return new Request<>(service.getAveragePrice(params.toMap()), params);
	}

	/** Get 24 hour rolling window price change statistics of a symbol. */
	public Request<TickerStatistics> get24hTickerStatistics(TickerStatisticsParams params) {
		return new Request<>(service.get24hTickerStatistics(params.toMap()),
				params);
	}

	/** Get 24 hour rolling window price change statistics of all symbols */
	public Request<List<TickerStatistics>> get24hTickerStatistics() {
		return new Request<>(service.get24hTickerStatistics(), new Params(40));
	}

	/** Get 24 hour rolling window price change statistics of specific symbols */
	public Request<List<TickerStatistics>> get24hTickerStatistics(TickersStatisticsParams params) {
		return new Request<>(service.get24hTickersStatistics(params.toMap()), params);
	}

	/** Latest price for all symbols. */
	public Request<List<PriceTicker>> getTicker() {
		return new Request<>(service.getTicker(), new Params(2));
	}

	/** Latest price for a symbol or symbols. */
	public Request<PriceTicker> getTicker(PriceTickerParams params) {
		return new Request<>(service.getTicker(params.toMap()), params);
	}

	/** Latest price for a symbol or symbols. */
	public Request<List<PriceTicker>> getTicker(PriceTickersParams params) {
		return new Request<>(service.getTickers(params.toMap()), params);
	}

	/** Get best price/qty on the order book for a symbol */
	public Request<BookTicker> getBookTicker(BookTickerParams params) {
		return new Request<>(service.getBookTicker(params.toMap()), params);
	}

	/** Get best price/qty on the order book for all symbols */
	public Request<List<BookTicker>> getBookTicker() {
		return new Request<>(service.getBookTicker(), new Params(2));
	}

	/** Get best price/qty on the order book for the given symbols */
	public Request<List<BookTicker>> getBookTicker(BookTickersParams params) {
		return new Request<>(service.getBookTickers(params.toMap()), params);
	}
}
