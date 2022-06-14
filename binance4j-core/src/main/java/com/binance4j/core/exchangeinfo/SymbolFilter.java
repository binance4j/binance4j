package com.binance4j.core.exchangeinfo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Trading rules of a symbol
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolFilter {
	/**
	 * The symbol filter type
	 */
	private FilterType filterType;
	/**
	 * The minimum price/stopPrice allowed.
	 */
	private BigDecimal minPrice;
	/**
	 * The maximum price/stopPrice allowed.
	 */
	private BigDecimal maxPrice;
	/**
	 * The intervals that a price/stopPrice can be increased/decreased by.
	 */
	private BigDecimal tickSize;
	/**
	 * The minimum quantity/icebergQty allowed.
	 */
	private BigDecimal minQty;
	/**
	 * The maximum quantity/icebergQty allowed.
	 */
	private BigDecimal maxQty;
	/**
	 * The intervals that a quantity/icebergQty can be increased/decreased
	 * by.
	 */
	private BigDecimal stepSize;
	/**
	 * The minimum notional value allowed for an order on a symbol. An
	 * order's notional value is the price * quantity.
	 */
	private BigDecimal minNotional;
	/**
	 * The maximum number of "algo" orders an account is allowed to have
	 * open on a symbol. "Algo" orders are STOP_LOSS; STOP_LOSS_LIMIT;
	 * TAKE_PROFIT;
	 * and TAKE_PROFIT_LIMIT orders.
	 */
	private BigDecimal maxNumAlgoOrders;
	/**
	 * The filter limit number
	 */
	private Integer limit;
	/**
	 * filters the price according to the previous order.
	 * 
	 * @see FilterType#PERCENT_PRICE
	 */
	private BigDecimal multiplierUp;
	/**
	 * filters the price according to the previous order.
	 * 
	 * @see FilterType#PERCENT_PRICE
	 */
	private BigDecimal multiplierDown;
	/**
	 * The max positions allowed
	 */
	private BigDecimal maxPosition;
	/**
	 * The number of minutes the average price is calculated over. 0 means
	 * the last price is used.
	 */
	private Integer avgPriceMins;
	/**
	 * The max number of orders allowed
	 */
	private Integer maxNumOrders;
	/**
	 * Whether or not the filter is applied to MARKET orders
	 */
	private Boolean applyToMarket;

	/**
	 * ???
	 */
	private int minTrailingAboveDelta;
	/**
	 * ???
	 */
	private int maxTrailingAboveDelta;
	/**
	 * ???
	 */
	private int minTrailingBelowDelta;
	/**
	 * ???
	 */
	private int maxTrailingBelowDelta;
}