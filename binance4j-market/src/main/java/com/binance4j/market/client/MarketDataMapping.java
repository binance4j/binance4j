package com.binance4j.market.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.binance4j.market.averageprice.AveragePrice;
import com.binance4j.market.bookticker.BookTicker;
import com.binance4j.market.depth.OrderBook;
import com.binance4j.market.priceticker.PriceTicker;
import com.binance4j.market.tickerstatistics.TickerStatistics;
import com.binance4j.market.time.ServerTimeResponse;
import com.binance4j.market.trades.TradeHistoryItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface MarketDataMapping {
    public static final String BASE = "/api/v3/";

    @GET(BASE + "ping")
    Call<Void> ping();

    @GET(BASE + "time")
    Call<ServerTimeResponse> getServerTime();

    @GET(BASE + "exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo(@QueryMap Map<String, Object> map);

    @GET(BASE + "depth")
    Call<OrderBook> getOrderBook(@QueryMap Map<String, Object> map);

    @GET(BASE + "trades")
    Call<List<TradeHistoryItem>> getTrades(@QueryMap Map<String, Object> map);

    @Headers(AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET(BASE + "historicalTrades")
    Call<List<TradeHistoryItem>> getHistoricalTrades(@QueryMap Map<String, Object> map);

    @GET(BASE + "aggTrades")
    Call<List<AggTrade>> getAggTrades(@QueryMap Map<String, Object> map);

    @GET(BASE + "klines")
    Call<List<CandlestickBar>> getKlines(@QueryMap Map<String, Object> map);

    @GET(BASE + "avgPrice")
    Call<AveragePrice> getAveragePrice(@QueryMap Map<String, Object> map);

    @GET(BASE + "ticker/24hr")
    Call<List<TickerStatistics>> get24hTickerStatistics();

    @GET(BASE + "ticker/24hr")
    Call<TickerStatistics> get24hTickerStatistics(@QueryMap Map<String, Object> map);

    @GET(BASE + "ticker/price")
    Call<List<PriceTicker>> getTicker();

    @GET(BASE + "ticker/price")
    Call<PriceTicker> getTicker(@QueryMap Map<String, Object> map);

    @GET(BASE + "ticker/bookTicker")
    Call<List<BookTicker>> getBookTicker();

    @GET(BASE + "ticker/bookTicker")
    Call<BookTicker> getBookTicker(@QueryMap Map<String, Object> map);
}
