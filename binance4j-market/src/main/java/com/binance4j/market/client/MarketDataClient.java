package com.binance4j.market.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.request.Request;
import com.binance4j.core.request.RequestExecutor;
import com.binance4j.core.request.RestClient;
import com.binance4j.market.aggtrade.AggTradeRequest;
import com.binance4j.market.averageprice.AveragePrice;
import com.binance4j.market.averageprice.AveragePriceRequest;
import com.binance4j.market.bookticker.BookTicker;
import com.binance4j.market.bookticker.BookTickerRequest;
import com.binance4j.market.depth.OrderBook;
import com.binance4j.market.depth.OrderBookRequest;
import com.binance4j.market.kline.KlinesRequest;
import com.binance4j.market.priceticker.PriceTicker;
import com.binance4j.market.priceticker.PriceTickerRequest;
import com.binance4j.market.tickerstatistics.TickerStatistics;
import com.binance4j.market.tickerstatistics.TickerStatisticsRequest;
import com.binance4j.market.time.ServerTimeResponse;
import com.binance4j.market.trades.HistoricalTradesRequest;
import com.binance4j.market.trades.TradeHistoryItem;
import com.binance4j.market.trades.TradesRequest;

public class MarketDataClient extends RestClient<MarketDataMapping> {
    /**
     * Instantiates a client for the market data endpoints.
     *
     * @param key        The API public key
     * @param secret     The API secret key
     * @param useTestnet Are we using TestNet?
     */
    public MarketDataClient(String key, String secret, Boolean useTestnet) {
        super(MarketDataMapping.class, key, secret, useTestnet);
    }

    /**
     * Instantiates a client for the market data endpoints.
     *
     * @param key    The API public key
     * @param secret The API secret key
     */
    public MarketDataClient(String key, String secret) {
        super(MarketDataMapping.class, key, secret, false);
    }

    /**
     * Test connectivity to the Rest API.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#test-connectivity">Documentation</a>
     */
    public RequestExecutor<Void> ping() {
        return new RequestExecutor<>(getServices().stream().map(MarketDataMapping::ping).toList());
    }

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#check-server-time">Documentation</a>
     */
    public RequestExecutor<ServerTimeResponse> getServerTime() {
        return new RequestExecutor<>(getServices().stream().map(MarketDataMapping::getServerTime).toList());
    }

    /**
     * Get current exchange trading rules and one or many symbols informations.
     *
     * If any symbol provided in either {@code symbol} or
     * {@code symbols} do not exist, the endpoint will throw an error.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#exchange-information">Documentation</a>
     */
    public RequestExecutor<ExchangeInfo> getExchangeInfo(ExchangeInfoRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getExchangeInfo(pojoToMap(req))).toList(), req);
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
     *      "https://binance-docs.github.io/apidocs/spot/en/#order-book">Documentation</a>
     */
    public RequestExecutor<OrderBook> getOrderBook(OrderBookRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getOrderBook(pojoToMap(req))).toList(), req);
    }

    /**
     * Get recent trades.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#recent-trades-list">Documentation</a>
     */
    public RequestExecutor<List<TradeHistoryItem>> getTrades(TradesRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getTrades(pojoToMap(req))).toList(), req);
    }

    /**
     * Get older market trades.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#old-trade-lookup-market_data">Documentation</a>
     */
    public RequestExecutor<List<TradeHistoryItem>> getHistoricalTrades(HistoricalTradesRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getHistoricalTrades(pojoToMap(req))).toList(),
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
     *      "https://binance-docs.github.io/apidocs/spot/en/#compressed-aggregate-trades-list">Documentation</a>
     */
    public RequestExecutor<List<AggTrade>> getAggTrades(AggTradeRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAggTrades(pojoToMap(req))).toList(), req);
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
     *      "https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data">Documentation</a>
     */
    public RequestExecutor<List<CandlestickBar>> getKlines(KlinesRequest req) {
        Map<String, Object> map = pojoToMap(req);
        // present in IntervalRequest through FramedRequest but not required by the API
        map.remove("timestamp");
        map.remove("recvWindow");
        return new RequestExecutor<>(getServices().stream().map(a -> a.getKlines(map)).toList(), req);
    }

    /**
     * Get Current average price for a symbol.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#current-average-price">Documentation</a>
     */
    public RequestExecutor<AveragePrice> getAveragePrice(AveragePriceRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getAveragePrice(pojoToMap(req))).toList(), req);
    }

    /**
     * Get 24 hour rolling window price change statistics of a symbol.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Documentation</a>
     */
    public RequestExecutor<TickerStatistics> get24hTickerStatistics(TickerStatisticsRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.get24hTickerStatistics(pojoToMap(req))).toList(),
                req);
    }

    /**
     * Get 24 hour rolling window price change statistics of all symbols
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#24hr-ticker-price-change-statistics">Documentation</a>
     */
    public RequestExecutor<List<TickerStatistics>> get24hTickerStatistics() {
        return new RequestExecutor<>(getServices().stream().map(MarketDataMapping::get24hTickerStatistics).toList(),
                new Request(40));
    }

    /**
     * Latest price for a symbol or symbols.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Documentation</a>
     */
    public RequestExecutor<PriceTicker> getTicker(PriceTickerRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getTicker(pojoToMap(req))).toList(), req);
    }

    /**
     * Latest price for all symbols.
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#symbol-price-ticker">Documentation</a>
     */
    public RequestExecutor<List<PriceTicker>> getTicker() {
        return new RequestExecutor<>(getServices().stream().map(MarketDataMapping::getTicker).toList(), new Request(2));
    }

    /**
     * Get best price/qty on the order book for a symbol
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Documentation</a>
     */
    public RequestExecutor<BookTicker> getBookTicker(BookTickerRequest req) {
        return new RequestExecutor<>(getServices().stream().map(a -> a.getBookTicker(pojoToMap(req))).toList(), req);
    }

    /**
     * Get best price/qty on the order book for all symbols
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#symbol-order-book-ticker">Documentation</a>
     */
    public RequestExecutor<List<BookTicker>> getBookTicker() {
        return new RequestExecutor<>(getServices().stream().map(MarketDataMapping::getBookTicker).toList(),
                new Request(2));
    }
}
