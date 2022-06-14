package com.binance4j.market.client;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.market.Candle;
import com.binance4j.core.request.Request;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.market.depth.*;
import com.binance4j.market.kline.KlinesRequest;
import com.binance4j.market.price.*;
import com.binance4j.market.tickerstatistics.TickerStatistics;
import com.binance4j.market.tickerstatistics.TickerStatisticsRequest;
import com.binance4j.market.tickerstatistics.TickersStatisticsRequest;
import com.binance4j.market.time.ServerTimeResponse;
import com.binance4j.market.trade.AggTradeRequest;
import com.binance4j.market.trade.HistoricalTradesRequest;
import com.binance4j.market.trade.TradeHistoryItem;
import com.binance4j.market.trade.TradesRequest;

import java.util.List;
import java.util.Map;

/**
 * API client for the market endpoints
 *
 * @see <a href="https://testnet.binance.vision/">...</a>
 */
public class MarketClient extends RestClient<MarketMapping> {

	/**
	 * Constructor
	 *
	 * @param key    The API public key
	 * @param secret The API secret key
	 */
	public MarketClient(String key, String secret) {
		super(MarketMapping.class, key, secret);
	}

	/**
	 * Test connectivity to the Rest API.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#test-connectivity">Documentation</a>
	 */
	public RequestExecutor<Void> ping() {
		return new RequestExecutor<>(service.ping());
	}

	/**
	 * Test connectivity to the Rest API and get the current server time.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#check-server-time">Documentation</a>
	 */
	public RequestExecutor<ServerTimeResponse> getServerTime() {
		return new RequestExecutor<>(service.getServerTime());
	}

	/**
	 * Get current exchange trading rules and one or many symbols informations.
	 * <p>
	 * If any symbol provided in either {@code symbol} or
	 * {@code symbols} do not exist, the endpoint will throw an error.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#exchange-information">Documentation</a>
	 */
	public RequestExecutor<ExchangeInfo> getExchangeInfo(ExchangeInfoRequest req) {
		return new RequestExecutor<>(service.getExchangeInfo(req.toMap()), req);
	}

	/**
	 * Get current exchange trading rules and all symbols informations
	 *
	 * @see #getExchangeInfo(ExchangeInfoRequest)
	 */
	public RequestExecutor<ExchangeInfo> getExchangeInfo() {
		return getExchangeInfo(new ExchangeInfoRequest());
	}

	/**
	 * Get the symbol order book
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#order-book">Documentation</a>
	 */
	public RequestExecutor<OrderBook> getOrderBook(OrderBookRequest req) {
		return new RequestExecutor<>(service.getOrderBook(req.toMap()), req);
	}

	/**
	 * Get recent trades.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list">Documentation</a>
	 */
	public RequestExecutor<List<TradeHistoryItem>> getTrades(TradesRequest req) {
		return new RequestExecutor<>(service.getTrades(req.toMap()), req);
	}

	/**
	 * Get older market trades.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#old-trade-lookup-market_data">Documentation</a>
	 */
	public RequestExecutor<List<TradeHistoryItem>> getHistoricalTrades(HistoricalTradesRequest req) {
		return new RequestExecutor<>(service.getHistoricalTrades(req.toMap()),
				req);
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
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#compressed-aggregate-trades-list">Documentation</a>
	 */
	public RequestExecutor<List<AggTrade>> getAggTrades(AggTradeRequest req) {
		return new RequestExecutor<>(service.getAggTrades(req.toMap()), req);
	}

	/**
	 * Kline/candlestick bars for a symbol.
	 * <ul>
	 * <li>
	 * Klines are uniquely identified by their open time.
	 * </li>
	 * <li>
	 * If {@code startTime</code> and <code>endTime} are not sent, the
	 * most recent klines are returned.
	 * </li>
	 * </ul>
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data">Documentation</a>
	 */
	public RequestExecutor<List<Candle>> getKlines(KlinesRequest req) {
		Map<String, Object> map = req.toMap();
		// present in IntervalRequest through FramedRequest but not required by the API
		map.remove("timestamp");
		map.remove("recvWindow");
		return new RequestExecutor<>(service.getKlines(map), req);
	}

	/**
	 * Get Current average price for a symbol.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#current-average-price">Documentation</a>
	 */
	public RequestExecutor<AveragePrice> getAveragePrice(AveragePriceRequest req) {
		return new RequestExecutor<>(service.getAveragePrice(req.toMap()), req);
	}

	/**
	 * Get 24 hour rolling window price change statistics of a symbol.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Documentation</a>
	 */
	public RequestExecutor<TickerStatistics> get24hTickerStatistics(TickerStatisticsRequest req) {
		return new RequestExecutor<>(service.get24hTickerStatistics(req.toMap()),
				req);
	}

	/**
	 * Get 24 hour rolling window price change statistics of all symbols
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Documentation</a>
	 */
	public RequestExecutor<List<TickerStatistics>> get24hTickerStatistics() {
		return new RequestExecutor<>(service.get24hTickerStatistics(), new Request(40));
	}

	/**
	 * Get 24 hour rolling window price change statistics of specific symbols
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Documentation</a>
	 */
	public RequestExecutor<List<TickerStatistics>> get24hTickerStatistics(TickersStatisticsRequest req) {
		return new RequestExecutor<>(service.get24hTickersStatistics(req.toMap()), req);
	}

	/**
	 * Latest price for all symbols.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Documentation</a>
	 */
	public RequestExecutor<List<PriceTicker>> getTicker() {
		return new RequestExecutor<>(service.getTicker(), new Request(2));
	}

	/**
	 * Latest price for a symbol or symbols.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Documentation</a>
	 */
	public RequestExecutor<PriceTicker> getTicker(PriceTickerRequest req) {
		return new RequestExecutor<>(service.getTicker(req.toMap()), req);
	}

	/**
	 * Latest price for a symbol or symbols.
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Documentation</a>
	 */
	public RequestExecutor<List<PriceTicker>> getTicker(PriceTickersRequest req) {
		return new RequestExecutor<>(service.getTickers(req.toMap()), req);
	}

	/**
	 * Get best price/qty on the order book for a symbol
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Documentation</a>
	 */
	public RequestExecutor<BookTicker> getBookTicker(BookTickerRequest req) {
		return new RequestExecutor<>(service.getBookTicker(req.toMap()), req);
	}

	/**
	 * Get best price/qty on the order book for all symbols
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Documentation</a>
	 */
	public RequestExecutor<List<BookTicker>> getBookTicker() {
		return new RequestExecutor<>(service.getBookTicker(), new Request(2));
	}

	/**
	 * Get best price/qty on the order book for the given symbols
	 *
	 * @see <a href=
	 * "https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Documentation</a>
	 */
	public RequestExecutor<List<BookTicker>> getBookTicker(BookTickersRequest req) {
		return new RequestExecutor<>(service.getBookTickers(req.toMap()), req);
	}
}
