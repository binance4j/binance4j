package com.binance4j.web.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.exception.ApiException;
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
import com.binance4j.market.param.BookTickersParams;
import com.binance4j.market.param.ExchangeInfoParams;
import com.binance4j.market.param.HistoricalTradesParams;
import com.binance4j.market.param.KlinesParams;
import com.binance4j.market.param.OrderBookParams;
import com.binance4j.market.param.PriceTickersParams;
import com.binance4j.market.param.TickersStatisticsParams;
import com.binance4j.market.param.TradesParams;
import com.binance4j.web.annotation.JsonGetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** Controller for Market endpoints. */
@RestController
@RequestMapping("api/v1/market")
@Api(value = "Market", tags = "Market", produces = "application/json", description = "Market endpoints")
public class MarketController extends BaseController {

	/**
	 * @return Test connectivity.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "ping")
	@ApiOperation(value = "Test connectivity.")
	public Void ping() throws ApiException {
		return connectors.rest().market().ping().sync();
	}

	/**
	 * @return Server time.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "server-time")
	@ApiOperation(value = "Get server time.")
	public ServerTimeResponse getServerTime() throws ApiException {
		return connectors.rest().market().getServerTime().sync();
	}

	/**
	 * @return Current exchange trading rules and one or many symbols informations.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "exchange-info")
	@ApiOperation(value = "Get current exchange trading rules and one or many symbols informations.")
	public ExchangeInfo getExchangeInfo(
			@RequestParam(required = false, name = SYMBOLS_DESCRIPTION) String symbols)
			throws ApiException {
		return connectors.rest().market().getExchangeInfo(new ExchangeInfoParams(symbols)).sync();
	}

	/**
	 * @param symbol Trading pair we want the depth.
	 * @param limit  Market depth size.
	 * @return The symbol order book.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "order-book")
	@ApiOperation(value = "Get the symbol order book.")
	public OrderBook getOrderBook(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false, name = "Market depth size.") @ApiParam(allowableValues = "5,10,20,50,100,500,1000,5000") String limit)
			throws ApiException {
		return connectors.rest().market().getOrderBook(new OrderBookParams(symbol, limit)).sync();
	}

	/**
	 * @param symbol Symbol we want the trades.
	 * @param limit  Trades size. Default 500; max 1000.
	 * @return Recent trades.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "trades")
	@ApiOperation(value = "Get recent trades.")
	public List<Trade> getTrades(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false, name = "Trades size.") @ApiParam(allowableValues = "range[1, 1000]", defaultValue = "500") Integer limit)
			throws ApiException {
		return connectors.rest().market().getTrades(new TradesParams(symbol, limit)).sync();
	}

	/**
	 * @param symbol Symbol we want the trades.
	 * @param limit  Trades size. Default 500; max 1000.
	 * @param fromId Trade id to fetch from.
	 * @return Old trades.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "historical-trades")
	@ApiOperation(value = "Get old trades.")
	public List<Trade> getHistoricalTrades(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false, name = "Trades size.") @ApiParam(allowableValues = "range[1, 1000]", defaultValue = "500") Integer limit,
			@RequestParam(required = false, name = "Trade id to fetch from.") Long fromId)
			throws ApiException {
		return connectors.rest().market().getHistoricalTrades(new HistoricalTradesParams(symbol, limit, fromId)).sync();
	}

	/**
	 * @param symbol    Symbol we want the trades.
	 * @param fromId    Trade id to fetch from.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 * @return Compressed, aggregate trades.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "aggtrades")
	@ApiOperation(value = "Get compressed, aggregate trades.")
	public List<AggTrade> getAggTrades(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(required = false, name = "Trade id to fetch from.") Long fromId,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().market()
				.getAggTrades(new AggTradeParams(symbol, fromId), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @param symbol   Trading pair we want the data.
	 * @param interval Candlestick interval.
	 * @return Kline/candles for a symbol.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "klines")
	@ApiOperation(value = "Get kline/candles for a symbol.")
	public List<Candle> getKlines(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbol,
			@RequestParam(name = "Candlestick interval.") @ApiParam(allowableValues = "3m, 5m, 15m, 30m, 1h, 2h, 4h, 6h, 8h, 12h, 1d, 3d, 1w, 1M") String interval,
			@RequestParam(required = false, name = START_TIME_DESCRIPTION) Long startTime,
			@RequestParam(required = false, name = END_TIME_DESCRIPTION) Long endTime,
			@RequestParam(required = false, name = LIMIT_DESCRIPTION) Integer limit)
			throws ApiException {
		return connectors.rest().market()
				.getKlines(new KlinesParams(symbol, interval), new TimeFrame(startTime, endTime, limit)).sync();
	}

	/**
	 * @param symbol Trading pair we want the price.
	 * @return Current average price for a symbol.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "average-price")
	@ApiOperation(value = "Get current average price for a symbol.")
	public AveragePrice getAveragePrice(
			@RequestParam(name = SYMBOL_DESCRIPTION) String symbol)
			throws ApiException {
		return connectors.rest().market().getAveragePrice(new AveragePriceParams(symbol)).sync();
	}

	/**
	 * @param symbols Symbols we want the statistics.
	 * @return 24 hour rolling window price change statistics of all symbols.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "24hr-statistics")
	@ApiOperation(value = "Get 24 hour rolling window price change statistics of all symbols.")
	public List<TickerStatistics> get24hTickerStatistics(
			@RequestParam(required = false, name = SYMBOLS_DESCRIPTION) String symbols)
			throws ApiException {
		return connectors.rest().market().get24hTickerStatistics(new TickersStatisticsParams(symbols)).sync();
	}

	/**
	 * @param symbols Symbols we want the statistics.
	 * @return Latest price for a symbol or symbols.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "price-ticker")
	@ApiOperation(value = "Get Latest price for a symbol or symbols.")
	public List<PriceTicker> getTicker(
			@RequestParam(required = false, name = SYMBOLS_DESCRIPTION) String symbols)
			throws ApiException {
		return connectors.rest().market().getTicker(new PriceTickersParams(symbols)).sync();
	}

	/**
	 * @param symbols Symbols we want the statistics.
	 * @return best price && quantity on the order book for the given symbols.
	 * @throws ApiException Something went wrong with the API.
	 */
	@JsonGetMapping(path = "order-book-ticker")
	@ApiOperation(value = "Get best price && quantity on the order book for the given symbols.")
	public List<BookTicker> getBookTicker(
			@RequestParam(required = false, name = SYMBOLS_DESCRIPTION) String symbols)
			throws ApiException {
		return connectors.rest().market().getBookTicker(new BookTickersParams(symbols)).sync();
	}
}