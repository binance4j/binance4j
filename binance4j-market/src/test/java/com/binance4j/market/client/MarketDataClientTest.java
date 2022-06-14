package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfo;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.market.CandlestickInterval;
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

import org.junit.jupiter.api.Test;

public class MarketDataClientTest {
    MarketDataClient client;

    public MarketDataClientTest() {
        String key = System.getenv("BINANCE_API_KEY");
        String secret = System.getenv("BINANCE_API_SECRET");
        client = new MarketDataClient(key, secret, false);
    }

    @Test
    public void testGet24hTickerStatistics() throws ApiException {
        List<TickerStatistics> res = client.get24hTickerStatistics().execute();
        res.forEach(r -> {
            assertNotNull(r.getAskPrice());
            assertNotNull(r.getAskQty());
            assertNotNull(r.getBidPrice());
            assertNotNull(r.getBidQty());
            assertNotNull(r.getCloseTime());
            assertNotNull(r.getCount());
            assertNotNull(r.getFirstId());
            assertNotNull(r.getHighPrice());
            assertNotNull(r.getLastId());
            assertNotNull(r.getLastPrice());
            assertNotNull(r.getLastQty());
            assertNotNull(r.getLowPrice());
            assertNotNull(r.getOpenPrice());
            assertNotNull(r.getPrevClosePrice());
            assertNotNull(r.getPriceChange());
            assertNotNull(r.getPriceChangePercent());
            assertNotNull(r.getQuoteVolume());
            assertNotNull(r.getSymbol());
            assertNotNull(r.getVolume());
            assertNotNull(r.getWeightedAvgPrice());
        });
    }

    @Test
    public void testGet24hTickerStatisticswithParams() throws ApiException {
        TickerStatistics res = client.get24hTickerStatistics(new TickerStatisticsRequest("BTCBUSD")).execute();
        assertNotNull(res.getSymbol());
        assertNotNull(res.getAskPrice());
        assertNotNull(res.getAskQty());
        assertNotNull(res.getBidPrice());
        assertNotNull(res.getBidQty());
        assertNotNull(res.getCloseTime());
        assertNotNull(res.getCount());
        assertNotNull(res.getFirstId());
        assertNotNull(res.getHighPrice());
        assertNotNull(res.getLastId());
        assertNotNull(res.getLastPrice());
        assertNotNull(res.getLastQty());
        assertNotNull(res.getLowPrice());
        assertNotNull(res.getOpenPrice());
        assertNotNull(res.getOpenTime());
        assertNotNull(res.getPrevClosePrice());
        assertNotNull(res.getPriceChange());
        assertNotNull(res.getPriceChangePercent());
        assertNotNull(res.getQuoteVolume());
        assertNotNull(res.getVolume());
        assertNotNull(res.getWeightedAvgPrice());
    }

    @Test
    public void testGetAggTrades() throws ApiException {

        List<AggTrade> res = client.getAggTrades(new AggTradeRequest("BTCBUSD")).execute();
        res.forEach(r -> {
            assertNotNull(r.getTradeId());
            assertNotNull(r.getFirstTradeId());
            assertNotNull(r.getIsBestMatch());
            assertNotNull(r.getIsBuyerMaker());
            assertNotNull(r.getLastTradeId());
            assertNotNull(r.getPrice());
            assertNotNull(r.getQuantity());
            assertNotNull(r.getTime());
        });
    }

    @Test
    public void testGetAveragePrice() throws ApiException {

        AveragePrice res = client.getAveragePrice(new AveragePriceRequest("BTCBUSD")).execute();
        assertNotNull(res.getMins());
        assertNotNull(res.getPrice());
    }

    @Test
    public void testGetBookTicker() throws ApiException {

        List<BookTicker> res = client.getBookTicker().execute();
        res.forEach(r -> {
            assertNotNull(r.getAskPrice());
            assertNotNull(r.getAskQuantity());
            assertNotNull(r.getBidPrice());
            assertNotNull(r.getBidQuantity());
        });
    }

    @Test
    public void testGetBookTickerwithParams() throws ApiException {

        BookTicker res = client.getBookTicker(new BookTickerRequest("BTCBUSD")).execute();
        assertNotNull(res.getAskPrice());
        assertNotNull(res.getAskQuantity());
        assertNotNull(res.getBidPrice());
        assertNotNull(res.getBidQuantity());
        assertNotNull(res.getSymbol());
    }

    // TODO check sub infos integrity
    @Test
    public void testGetExchangeInfo() throws ApiException {
        ExchangeInfo res = client.getExchangeInfo().execute();
        assertNotNull(res.getTimezone());
        assertNotNull(res.getServerTime());

        res.getExchangeFilters().forEach(f -> {
            assertNotNull(f.getFilterType());
            assertNotNull(f.getLimit());
        });

        res.getRateLimits().forEach(rl -> {
            assertNotNull(rl.getInterval());
            assertNotNull(rl.getIntervalNum());
            assertNotNull(rl.getLimit());
            assertNotNull(rl.getRateLimitType());
        });
        res.getSymbols().forEach(s -> {
            assertNotNull(s.getBaseAsset());
            assertNotNull(s.getBaseAssetPrecision());
            assertNotNull(s.getFilters());
            assertNotNull(s.getIcebergAllowed());
            assertNotNull(s.getIsMarginTradingAllowed());
            assertNotNull(s.getIsSpotTradingAllowed());
            assertNotNull(s.getOcoAllowed());
            assertNotNull(s.getOrderTypes());
            assertNotNull(s.getPermissions());
            assertNotNull(s.getQuoteAsset());
            assertNotNull(s.getQuoteCommissionPrecision());
            assertNotNull(s.getQuoteOrderQtyMarketAllowed());
            assertNotNull(s.getQuotePrecision());
            assertNotNull(s.getStatus());
            assertNotNull(s.getSymbol());
        });
    }

    @Test
    public void testGetExchangeInfowithParams() throws ApiException {

        ExchangeInfo res = client.getExchangeInfo(new ExchangeInfoRequest("BTCBUSD")).execute();

        assertNotNull(res.getTimezone());
        assertNotNull(res.getServerTime());

        res.getExchangeFilters().forEach(f -> {
            assertNotNull(f.getFilterType());
            assertNotNull(f.getLimit());
        });

        res.getRateLimits().forEach(rl -> {
            assertNotNull(rl.getInterval());
            assertNotNull(rl.getIntervalNum());
            assertNotNull(rl.getLimit());
            assertNotNull(rl.getRateLimitType());
        });
        res.getSymbols().forEach(s -> {
            assertNotNull(s.getBaseAsset());
            assertNotNull(s.getBaseAssetPrecision());
            assertNotNull(s.getFilters());
            assertNotNull(s.getIcebergAllowed());
            assertNotNull(s.getIsMarginTradingAllowed());
            assertNotNull(s.getIsSpotTradingAllowed());
            assertNotNull(s.getOcoAllowed());
            assertNotNull(s.getOrderTypes());
            assertNotNull(s.getPermissions());
            assertNotNull(s.getQuoteAsset());
            assertNotNull(s.getQuoteCommissionPrecision());
            assertNotNull(s.getQuoteOrderQtyMarketAllowed());
            assertNotNull(s.getQuotePrecision());
            assertNotNull(s.getStatus());
            assertNotNull(s.getSymbol());
        });
    }

    @Test
    public void testGetHistoricalTrades() throws ApiException {
        List<TradeHistoryItem> res = client.getHistoricalTrades(new HistoricalTradesRequest("BTCBUSD")).execute();
        res.forEach(r -> {
            assertNotNull(r.getId());
            assertNotNull(r.getIsBestMatch());
            assertNotNull(r.getIsBuyerMaker());
            assertNotNull(r.getPrice());
            assertNotNull(r.getQuantity());
            assertNotNull(r.getQuoteQuantity());
            assertNotNull(r.getTime());
        });
        assertNotNull(res);
    }

    @Test
    public void testGetKlines() throws ApiException {
        List<CandlestickBar> res = client.getKlines(new KlinesRequest("BTCBUSD", CandlestickInterval.FIVE_MINUTES))
                .execute();
        res.forEach(r -> {
            assertNotNull(r.getClose());
            assertNotNull(r.getCloseTime());
            assertNotNull(r.getHigh());
            assertNotNull(r.getLow());
            assertNotNull(r.getNumberOfTrades());
            assertNotNull(r.getOpen());
            assertNotNull(r.getOpenTime());
            assertNotNull(r.getQuoteAssetVolume());
            assertNotNull(r.getTakerBuyBaseAssetVolume());
            assertNotNull(r.getTakerBuyQuoteAssetVolume());
            assertNotNull(r.getVolume());
        });
    }

    @Test
    public void testGetOrderBook() throws ApiException {
        OrderBook res = client.getOrderBook(new OrderBookRequest("BTCBUSD")).execute();

        res.getAsks().forEach(a -> {
            assertNotNull(a.getPrice());
            assertNotNull(a.getQuantity());
        });

        res.getBids().forEach(a -> {
            assertNotNull(a.getPrice());
            assertNotNull(a.getQuantity());
        });

        res.getLastUpdateId();
    }

    @Test
    public void testGetServerTime() throws ApiException {
        ServerTimeResponse res = client.getServerTime().execute();
        assertNotNull(res.getServerTime());
    }

    @Test
    public void testGetTicker() throws ApiException {
        List<PriceTicker> res = client.getTicker().execute();
        res.forEach(r -> {
            assertNotNull(r.getPrice());
            assertNotNull(r.getSymbol());
        });
    }

    @Test
    public void testGetTickerwithParams() throws ApiException {
        PriceTicker res = client.getTicker(new PriceTickerRequest("BTCBUSD")).execute();
        assertNotNull(res.getPrice());
        assertNotNull(res.getSymbol());
    }

    @Test
    public void testGetTrades() throws ApiException {
        List<TradeHistoryItem> res = client.getTrades(new TradesRequest("BTCBUSD")).execute();
        res.forEach(r -> {
            assertNotNull(r.getId());
            assertNotNull(r.getIsBestMatch());
            assertNotNull(r.getIsBuyerMaker());
            assertNotNull(r.getPrice());
            assertNotNull(r.getQuantity());
            assertNotNull(r.getQuoteQuantity());
            assertNotNull(r.getTime());
        });
    }

    @Test
    public void testPing() throws ApiException {
        client.ping().execute();
        assertNull(null);
    }
}
