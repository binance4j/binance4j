package com.binance4j.market.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.market.dto.ExchangeInfo;
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
import com.binance4j.market.request.Get24hTickerStatisticsRequest;
import com.binance4j.market.request.Get24hTickersStatisticsRequest;
import com.binance4j.market.request.GetAggTradesRequest;
import com.binance4j.market.request.GetAveragePriceRequest;
import com.binance4j.market.request.GetBookTickerRequest;
import com.binance4j.market.request.GetBookTickersRequest;
import com.binance4j.market.request.GetExchangeInfoRequest;
import com.binance4j.market.request.GetHistoricalTradesRequest;
import com.binance4j.market.request.GetKlinesRequest;
import com.binance4j.market.request.GetOrderBookRequest;
import com.binance4j.market.request.GetServerTimeRequest;
import com.binance4j.market.request.GetTickerRequest;
import com.binance4j.market.request.GetTickersRequest;
import com.binance4j.market.request.GetTradesRequest;
import com.binance4j.market.request.PingRequest;

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
	public PingRequest ping() {
		return new PingRequest(service.ping());
	}

	/**
	 * Test connectivity to the Rest API and get the current server time.
	 * 
	 * @return The request to execute.
	 */
	public GetServerTimeRequest getServerTime() {
		return new GetServerTimeRequest(service.getServerTime());
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
	public GetExchangeInfoRequest getExchangeInfo(ExchangeInfoParams params) {
		return new GetExchangeInfoRequest(service.getExchangeInfo(params.toMap()));
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
	public GetOrderBookRequest getOrderBook(OrderBookParams params) {
		return new GetOrderBookRequest(service.getOrderBook(params.toMap()));
	}

	/**
	 * Get recent trades.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTradesRequest getTrades(TradesParams params) {
		return new GetTradesRequest(service.getTrades(params.toMap()));
	}

	/**
	 * Get older market trades.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetHistoricalTradesRequest getHistoricalTrades(HistoricalTradesParams params) {
		return new GetHistoricalTradesRequest(service.getHistoricalTrades(params.toMap()));
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
	public GetAggTradesRequest getAggTrades(AggTradeParams params) {
		return new GetAggTradesRequest(service.getAggTrades(params.toMap()));
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
	public GetAggTradesRequest getAggTrades(AggTradeParams params, TimeFrame timeFrame) {
		return new GetAggTradesRequest(service.getAggTrades(Params.merge(params, timeFrame)));
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
	public GetKlinesRequest getKlines(KlinesParams params) {
		return new GetKlinesRequest(service.getKlines(params.toMap()));
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
	public GetKlinesRequest getKlines(KlinesParams params, TimeFrame timeFrame) {
		return new GetKlinesRequest(service.getKlines(Params.merge(params, timeFrame)));
	}

	/**
	 * Get Current average price for a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetAveragePriceRequest getAveragePrice(AveragePriceParams params) {
		return new GetAveragePriceRequest(service.getAveragePrice(params.toMap()));
	}

	/**
	 * Get 24 hour rolling window price change statistics of a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Get24hTickerStatisticsRequest get24hTickerStatistics(TickerStatisticsParams params) {
		return new Get24hTickerStatisticsRequest(service.get24hTickerStatistics(params.toMap()));
	}

	/**
	 * Get 24 hour rolling window price change statistics of all symbols.
	 * 
	 * @return The request to execute.
	 */
	public Get24hTickersStatisticsRequest get24hTickerStatistics() {
		return new Get24hTickersStatisticsRequest(service.get24hTickerStatistics());
	}

	/**
	 * Get 24 hour rolling window price change statistics of specific symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public Get24hTickersStatisticsRequest get24hTickerStatistics(TickersStatisticsParams params) {
		return new Get24hTickersStatisticsRequest(service.get24hTickersStatistics(params.toMap()));
	}

	/**
	 * Latest price for all symbols.
	 * 
	 * @return The request to execute.
	 */
	public GetTickersRequest getTicker() {
		return new GetTickersRequest(service.getTicker());
	}

	/**
	 * Latest price for a symbol or symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTickerRequest getTicker(PriceTickerParams params) {
		return new GetTickerRequest(service.getTicker(params.toMap()));
	}

	/**
	 * Latest price for a symbol or symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetTickersRequest getTicker(PriceTickersParams params) {
		return new GetTickersRequest(service.getTickers(params.toMap()));
	}

	/**
	 * Get best price/quantity on the order book for a symbol.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetBookTickerRequest getBookTicker(BookTickerParams params) {
		return new GetBookTickerRequest(service.getBookTicker(params.toMap()));
	}

	/**
	 * Get best price/quantity on the order book for all symbols.
	 * 
	 * @return The request to execute.
	 */
	public GetBookTickersRequest getBookTicker() {
		return new GetBookTickersRequest(service.getBookTicker());
	}

	/**
	 * Get best price/quantity on the order book for the given symbols.
	 * 
	 * @param params Request params.
	 * @return The request to execute.
	 */
	public GetBookTickersRequest getBookTicker(BookTickersParams params) {
		return new GetBookTickersRequest(service.getBookTickers(params.toMap()));
	}
}
