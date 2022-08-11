package com.binance4j.connectors;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.UserDataClient;
import com.binance4j.websocket.client.WebsocketAggTradeClient;
import com.binance4j.websocket.client.WebsocketAllBookTickersClient;
import com.binance4j.websocket.client.WebsocketAllMiniTickersClient;
import com.binance4j.websocket.client.WebsocketAllTickersClient;
import com.binance4j.websocket.client.WebsocketBookTickerClient;
import com.binance4j.websocket.client.WebsocketCandlestickClient;
import com.binance4j.websocket.client.WebsocketDepthClient;
import com.binance4j.websocket.client.WebsocketMiniDepthClient;
import com.binance4j.websocket.client.WebsocketMiniTickerClient;
import com.binance4j.websocket.client.WebsocketTradeClient;
import com.binance4j.websocket.client.WebsocketUserDataClient;
import com.binance4j.websocket.dto.AggTrade;
import com.binance4j.websocket.dto.BookTicker;
import com.binance4j.websocket.dto.Candle;
import com.binance4j.websocket.dto.Depth;
import com.binance4j.websocket.dto.DepthLevel;
import com.binance4j.websocket.dto.DepthUpdateSpeed;
import com.binance4j.websocket.dto.MiniDepth;
import com.binance4j.websocket.dto.MiniTicker;
import com.binance4j.websocket.dto.Ticker;
import com.binance4j.websocket.dto.Trade;
import com.binance4j.websocket.dto.UserDataUpdate;

/** Websocket connectors container. */
public class WebsocketConnectors {
	/** Inner {@link WebsocketAllBookTickersClient}. */
	private WebsocketAllBookTickersClient allBookTickers;
	/** Inner {@link WebsocketAllMiniTickersClient}. */
	private WebsocketAllMiniTickersClient allMiniTickers;
	/** Inner {@link WebsocketAllTickersClient}. */
	private WebsocketAllTickersClient allTickers;
	/** Inner {@link WebsocketAggTradeClient WebsocketAggTradeClients}. */
	private Map<String, WebsocketAggTradeClient> websocketAggTradeClients = new HashMap<>();
	/** Inner {@link WebsocketBookTickerClient WebsocketBookTickerClients}. */
	private Map<String, WebsocketBookTickerClient> websocketBookTickerClients = new HashMap<>();
	/** Inner {@link WebsocketCandlestickClient WebsocketCandlestickClients}. */
	private Map<String, WebsocketCandlestickClient> websocketCandlestickClients = new HashMap<>();
	/** Inner {@link WebsocketDepthClient WebsocketDepthClients}. */
	private Map<String, WebsocketDepthClient> websocketDepthClients = new HashMap<>();
	/** Inner {@link WebsocketMiniDepthClient WebsocketMiniDepthClients}. */
	private Map<String, WebsocketMiniDepthClient> websocketMiniDepthClients = new HashMap<>();
	/** Inner {@link WebsocketMiniTickerClient WebsocketMiniTickerClients}. */
	private Map<String, WebsocketMiniTickerClient> websocketMiniTickerClients = new HashMap<>();
	/** Inner {@link WebsocketTradeClient WebsocketTradeClients}. */
	private Map<String, WebsocketTradeClient> websocketTradeClients = new HashMap<>();
	/** Inner {@link WebsocketUserDataClient WebsocketUserDataClients}. */
	private Map<String, WebsocketUserDataClient> websocketUserDataClients = new HashMap<>();

	// allBookTickers //

	/**
	 * Creates an instance of {@link WebsocketAllBookTickersClient} and caches it.
	 * 
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketAllBookTickersClient allBookTickers(WebsocketCallback<BookTicker> callback) {
		allBookTickers = new WebsocketAllBookTickersClient(callback);
		return allBookTickers;
	};

	/**
	 * @return The cached client.
	 */
	public Optional<WebsocketAllBookTickersClient> allBookTickers() {
		return Optional.of(allBookTickers);
	};

	// allMiniTickers //

	/**
	 * Creates an instance of {@link WebsocketAllMiniTickersClient} and caches it.
	 * 
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketAllMiniTickersClient allMiniTickers(WebsocketCallback<MiniTicker> callback) {
		allMiniTickers = new WebsocketAllMiniTickersClient(callback);
		return allMiniTickers;
	};

	/**
	 * @return The cached client.
	 */
	public Optional<WebsocketAllMiniTickersClient> allMiniTickers() {
		return Optional.of(allMiniTickers);
	};

	// allTickers //

	/**
	 * Creates an instance of {@link WebsocketAllTickersClient} and caches it.
	 * 
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketAllTickersClient allTickers(WebsocketCallback<Ticker> callback) {
		allTickers = new WebsocketAllTickersClient(callback);
		return allTickers;
	};

	/**
	 * @return The cached client.
	 */
	public Optional<WebsocketAllTickersClient> allTickers() {
		return Optional.of(allTickers);
	};

	// aggTrade //

	/**
	 * Creates an instance of {@link WebsocketAggTradeClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketAggTradeClient aggTrade(String symbols, WebsocketCallback<AggTrade> callback) {
		var client = new WebsocketAggTradeClient(symbols, callback);
		websocketAggTradeClients.put(client.getSymbols(), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketAggTradeClient> aggTrade(String symbols) {
		return Optional.of(websocketAggTradeClients.get(handleSymbols(symbols)));
	};

	// bookTicker //

	/**
	 * Creates an instance of {@link WebsocketBookTickerClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketBookTickerClient bookTicker(String symbols, WebsocketCallback<BookTicker> callback) {
		var client = new WebsocketBookTickerClient(symbols, callback);
		websocketBookTickerClients.put(client.getSymbols(), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketBookTickerClient> bookTicker(String symbols) {
		return Optional.of(websocketBookTickerClients.get(handleSymbols(symbols)));
	};

	// candlestick //

	/**
	 * Creates an instance of {@link WebsocketCandlestickClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param interval Candlestick interval.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketCandlestickClient candlestick(String symbols, CandlestickInterval interval,
			WebsocketCallback<Candle> callback) {
		var client = new WebsocketCandlestickClient(symbols, interval, callback);
		websocketCandlestickClients.put(String.format("%s%s", client.getSymbols(), interval), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketCandlestickClient> candlestick(String symbols, CandlestickInterval interval) {
		return Optional.of(websocketCandlestickClients.get(String.format("%s%s", handleSymbols(symbols), interval)));
	};

	// depth //

	/**
	 * Creates an instance of {@link WebsocketDepthClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param speed    Update speed.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketDepthClient depth(String symbols, DepthUpdateSpeed speed, WebsocketCallback<Depth> callback) {
		var client = new WebsocketDepthClient(symbols, speed, callback);
		websocketDepthClients.put(String.format("%s%s", client.getSymbols(), speed), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketDepthClient> depth(String symbols, DepthUpdateSpeed speed) {
		return Optional.of(websocketDepthClients.get(String.format("%s%s", handleSymbols(symbols), speed)));
	};

	// miniDepth //

	/**
	 * Creates an instance of {@link WebsocketMiniDepthClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param level    Order book size.
	 * @param speed    Update speed.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketMiniDepthClient miniDepth(String symbols, DepthLevel level, DepthUpdateSpeed speed,
			WebsocketCallback<MiniDepth> callback) {
		var client = new WebsocketMiniDepthClient(symbols, level, speed, callback);
		websocketMiniDepthClients.put(String.format("%s%s%s", client.getSymbols(), level, speed), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketMiniDepthClient> miniDepth(String symbols, DepthLevel level, DepthUpdateSpeed speed) {
		return Optional
				.of(websocketMiniDepthClients.get(String.format("%s%s%s", handleSymbols(symbols), level, speed)));
	};

	// miniTicker //

	/**
	 * Creates an instance of {@link WebsocketMiniTickerClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketMiniTickerClient miniTicker(String symbols, WebsocketCallback<MiniTicker> callback) {
		var client = new WebsocketMiniTickerClient(symbols, callback);
		websocketMiniTickerClients.put(client.getSymbols(), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketMiniTickerClient> miniTicker(String symbols) {
		return Optional.of(websocketMiniTickerClients.get(handleSymbols(symbols)));
	};

	// trade //

	/**
	 * Creates an instance of {@link WebsocketTradeClient} and caches it.
	 * 
	 * @param symbols  Trading pairs to watch separated by a coma.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketTradeClient trade(String symbols, WebsocketCallback<Trade> callback) {
		var client = new WebsocketTradeClient(symbols, callback);
		websocketTradeClients.put(client.getSymbols(), client);
		return client;
	};

	/**
	 * @param symbol The symbols the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketTradeClient> trade(String symbols) {
		return Optional.of(websocketTradeClients.get(handleSymbols(symbols)));
	};

	// userData //

	/**
	 * Creates an instance of {@link WebsocketTradeClient} and caches it.
	 * 
	 * @param client   UserDataClient that will fetch the listen key to open the
	 *                 stream and keep it alive at a periodical interval.
	 * @param callback Events handler.
	 * @return The generated client.
	 */
	public WebsocketUserDataClient user(UserDataClient userDataClient, WebsocketCallback<UserDataUpdate> callback)
			throws ApiException {
		var client = new WebsocketUserDataClient(userDataClient, callback);
		websocketUserDataClients.put(client.getListenKey(), client);
		return client;
	};

	/**
	 * @param listenKey The listen key the client is connected to.
	 * @return The cached client.
	 */
	public Optional<WebsocketUserDataClient> user(String listenKey) {
		return Optional.of(websocketUserDataClients.get(listenKey));
	};

	private String handleSymbols(String symbols) {
		return symbols.replaceAll(" ", "").toLowerCase();
	}
}