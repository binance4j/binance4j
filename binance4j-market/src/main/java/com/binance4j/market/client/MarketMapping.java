package com.binance4j.market.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.client.RestMapping;
import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.market.dto.AveragePrice;
import com.binance4j.market.dto.BookTicker;
import com.binance4j.market.dto.ExchangeInfo;
import com.binance4j.market.dto.OrderBook;
import com.binance4j.market.dto.PriceTicker;
import com.binance4j.market.dto.ServerTimeResponse;
import com.binance4j.market.dto.TickerStatistics;
import com.binance4j.market.dto.Trade;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/** {@link MarketClient} mapping. */
public interface MarketMapping extends RestMapping {
	/** Base uri */
	String BASE = "/api/v3/";

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ping")
	@Headers({ IP_H, WEIGHT_ONE_H })
	Call<Void> ping();

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "time")
	@Headers({ IP_H, WEIGHT_ONE_H })
	Call<ServerTimeResponse> getServerTime();

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "exchangeInfo")
	@Headers({ IP_H, "X-WEIGHT: 10" })
	Call<ExchangeInfo> getExchangeInfo(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "depth")
	@Headers({ IP_H, "X-WEIGHT: 50" })
	Call<OrderBook> getOrderBook(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "trades")
	@Headers({ IP_H, WEIGHT_ONE_H })
	Call<List<Trade>> getTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers({ API_H, IP_H, "X-WEIGHT: 5" })
	@GET(BASE + "historicalTrades")
	Call<List<Trade>> getHistoricalTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "aggTrades")
	@Headers({ IP_H, WEIGHT_ONE_H })
	Call<List<AggTrade>> getAggTrades(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "klines")
	@Headers({ IP_H, WEIGHT_ONE_H })
	Call<List<Candle>> getKlines(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "avgPrice")
	@Headers({ IP_H, WEIGHT_ONE_H })
	Call<AveragePrice> getAveragePrice(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/24hr")
	@Headers({ IP_H, "X-WEIGHT: 40" })
	Call<List<TickerStatistics>> get24hTickerStatistics();

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/24hr")
	@Headers({ IP_H, "X-WEIGHT: 40" })
	Call<TickerStatistics> get24hTickerStatistics(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/24hr")
	@Headers({ IP_H, "X-WEIGHT: 40" })
	Call<List<TickerStatistics>> get24hTickersStatistics(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/price")
	@Headers({ IP_H, "X-WEIGHT: 2" })
	Call<List<PriceTicker>> getTicker();

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/price")
	@Headers({ IP_H, "X-WEIGHT: 2" })
	Call<List<PriceTicker>> getTickers(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/price")
	@Headers({ IP_H, "X-WEIGHT: 2" })
	Call<PriceTicker> getTicker(@QueryMap Map<String, Object> map);

	/**
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/bookTicker")
	@Headers({ IP_H, "X-WEIGHT: 2" })
	Call<List<BookTicker>> getBookTicker();

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/bookTicker")
	@Headers({ IP_H, "X-WEIGHT: 2" })
	Call<BookTicker> getBookTicker(@QueryMap Map<String, Object> map);

	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET(BASE + "ticker/bookTicker")
	@Headers({ IP_H, "X-WEIGHT: 2" })
	Call<List<BookTicker>> getBookTickers(@QueryMap Map<String, Object> map);
}
