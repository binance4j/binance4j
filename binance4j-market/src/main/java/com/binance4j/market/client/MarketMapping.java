package com.binance4j.market.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.market.dto.AveragePrice;
import com.binance4j.market.dto.BookTicker;
import com.binance4j.market.dto.ExchangeInfo;
import com.binance4j.market.dto.OrderBook;
import com.binance4j.market.dto.PriceTicker;
import com.binance4j.market.dto.ServerTimeResponse;
import com.binance4j.market.dto.TickerStatistics;
import com.binance4j.market.dto.TradeHistoryItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** {@link MarketClient} mapping */
public interface MarketMapping extends RestMapping {
	/** Base uri */
	String BASE = "/api/v3/";

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ping")
	Call<Void> ping();

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "time")
	Call<ServerTimeResponse> getServerTime();

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "exchangeInfo")
	Call<ExchangeInfo> getExchangeInfo(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "depth")
	Call<OrderBook> getOrderBook(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "trades")
	Call<List<TradeHistoryItem>> getTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@GET(BASE + "historicalTrades")
	Call<List<TradeHistoryItem>> getHistoricalTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "aggTrades")
	Call<List<AggTrade>> getAggTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "klines")
	Call<List<Candle>> getKlines(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "avgPrice")
	Call<AveragePrice> getAveragePrice(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/24hr")
	Call<List<TickerStatistics>> get24hTickerStatistics();

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/24hr")
	Call<TickerStatistics> get24hTickerStatistics(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/24hr")
	Call<List<TickerStatistics>> get24hTickersStatistics(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/price")
	Call<List<PriceTicker>> getTicker();

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/price")
	Call<List<PriceTicker>> getTickers(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/price")
	Call<PriceTicker> getTicker(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/bookTicker")
	Call<List<BookTicker>> getBookTicker();

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/bookTicker")
	Call<BookTicker> getBookTicker(@QueryMap Map<String, Object> map);

	/**
	 * @param map The query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/bookTicker")
	Call<List<BookTicker>> getBookTickers(@QueryMap Map<String, Object> map);
}
