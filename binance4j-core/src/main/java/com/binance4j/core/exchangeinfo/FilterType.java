package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two
 * forms: symbol filters and exchange filters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FilterType {
  // Symbol
  /**
   * The PRICE_FILTER defines the price rules for a symbol. There are 3 parts:
   * <ul>
   * <li>{@code minPrice} defines the minimum price/stopPrice allowed;
   * disabled on minPrice == 0.</li>
   * <li>{@code maxPrice} defines the maximum price/stopPrice allowed;
   * disabled on maxPrice == 0.</li>
   * <li>{@code tickSize} defines the intervals that a price/stopPrice can be
   * increased/decreased by; disabled on tickSize == 0.</li>
   * </ul>
   * 
   * Any of the above variables can be set to 0, which disables that rule
   * in the price filter. In order to pass the price filter, the
   * following must be true for price/stopPrice of the enabled rules:
   * 
   * <ul>
   * <li>price &gt; minPrice</li>
   * <li>price &lt; maxPrice</li>
   * <li>price % tickSize == 0</li>
   * </ul>
   */
  PRICE_FILTER,
  /**
   * The PERCENT_PRICE filter defines valid range for a price based on the average
   * of the previous trades. avgPriceMins is the number of minutes the average
   * price is calculated over. 0 means the last price is used.
   * 
   * In order to pass the percent price, the following must be true for price:
   * 
   * <ul>
   * <li>price &lt; weightedAveragePrice * multiplierUp</li>
   * <li>price &gt; weightedAveragePrice * multiplierDown</li>
   * </ul>
   */
  PERCENT_PRICE,
  /**
   * The PERCENT_PRICE_BY_SIDE filter defines the valid range for the price based
   * on the lastPrice of the symbol. There is a different range depending on
   * whether the order is placed on the BUY side or the SELL side.
   * 
   * Buy orders will succeed on this filter if:
   * <ul>
   * <li>Order price &lt; bidMultiplierUp * lastPrice</li>
   * <li>Order price &gt; bidMultiplierDown * lastPrice</li>
   * </ul>
   * 
   * Sell orders will succeed on this filter if:
   * <ul>
   * <li>Order Price &lt;= askMultiplierUp * lastPrice</li>
   * <li>Order Price &gt;= askMultiplierDown * lastPrice</li>
   * </ul>
   */
  PERCENT_PRICE_BY_SIDE,
  /**
   * The LOT_SIZE filter defines the quantity (aka "lots" in auction terms) rules
   * for a symbol. There are 3 parts:
   * 
   * <ul>
   * <li>{@code minQty} defines the minimum quantity/icebergQty allowed.</li>
   * <li>{@code maxQty} defines the maximum quantity/icebergQty allowed.</li>
   * <li>{@code stepSize} defines the intervals that a quantity/icebergQty can
   * be increased/decreased by.</li>
   * </ul>
   * 
   * In order to pass the lot size, the following must be true for
   * quantity/icebergQty:
   * 
   * <ul>
   * <li>quantity &gt;= minQty</li>
   * <li>quantity &lt;= maxQty</li>
   * <li>(quantity-minQty) % stepSize == 0</li>
   * </ul>
   */
  LOT_SIZE,
  /**
   * The MIN_NOTIONAL filter defines the minimum notional value allowed for an
   * order on a symbol. An order's notional value is the price * quantity. If the
   * order is an Algo order (e.g. STOP_LOSS_LIMIT), then the notional value of the
   * stopPrice * quantity will also be evaluated. If the order is an Iceberg
   * Order, then the notional value of the price * icebergQty will also be
   * evaluated. applyToMarket determines whether or not the MIN_NOTIONAL filter
   * will also be applied to MARKET orders. Since MARKET orders have no price, the
   * average price is used over the last avgPriceMins minutes. avgPriceMins is the
   * number of minutes the average price is calculated over. 0 means the last
   * price is used.
   */
  MIN_NOTIONAL,
  /**
   * The ICEBERG_PARTS filter defines the maximum parts an iceberg order can have.
   * The number of ICEBERG_PARTS is defined as CEIL(qty / icebergQty).
   */
  ICEBERG_PARTS,
  /**
   * The {@code MARKET_LOT_SIZE} filter defines the quantity (aka "lots" in
   * auction terms)
   * rules for MARKET orders on a symbol. There are 3 parts:
   * 
   * <ul>
   * <li>{@code minQty} defines the minimum quantity allowed.</li>
   * <li>{@code maxQty} defines the maximum quantity allowed.</li>
   * <li>{@code stepSize} defines the intervals that a quantity can be
   * increased/decreased
   * by.</li>
   * </ul>
   * 
   * In order to pass the market lot size, the following must be true for
   * quantity:
   * 
   * <ul>
   * <li>quantity &gt;= minQty</li>
   * <li>quantity &lt;= maxQty</li>
   * <li>(quantity-minQty) % stepSize == 0</li>
   * </ul>
   */
  MARKET_LOT_SIZE,
  /**
   * The {@code MAX_NUM_ORDERS} filter defines the maximum number of orders an
   * account is allowed to have open on a symbol. Note that both "algo" orders and
   * normal orders are counted for this filter.
   */
  MAX_NUM_ORDERS,
  /**
   * ???
   */
  MAX_ALGO_ORDERS,
  /**
   * The {@code MAX_NUM_ALGO_ORDERS} filter defines the maximum number of "algo"
   * orders an account is allowed to have open on a symbol. "Algo" orders are
   * {@code STOP_LOSS}, {@code STOP_LOSS_LIMIT}, {@code TAKE_PROFIT}, and
   * {@code TAKE_PROFIT_LIMIT} orders.
   */
  MAX_NUM_ALGO_ORDERS,
  /**
   * The {@code MAX_NUM_ICEBERG_ORDERS} filter defines the maximum number of
   * {@code ICEBERG} orders an account is allowed to have open on a symbol. An
   * {@code ICEBERG}
   * order is any order where the icebergQty is &gt; 0.
   */
  MAX_NUM_ICEBERG_ORDERS,
  /**
   * The MAX_POSITION filter defines the allowed maximum position an account can
   * have on the base asset of a symbol. An account's position defined as the sum
   * of the account's:
   * 
   * <ul>
   * <li>free balance of the base asset</li>
   * <li>locked balance of the base asset</li>
   * <li>sum of the qty of all open BUY orders</li>
   * </ul>
   * 
   * {@code BUY} orders will be rejected if the account's position is greater than
   * the
   * maximum position allowed.
   */
  MAX_POSITION,
  /**
   * How much the market price could fall before you'd want to sell, or rise
   * before you'd want to buy
   */
  TRAILING_DELTA,
  // Exchange
  /**
   * The {@code EXCHANGE_MAX_NUM_ORDERS} filter defines the maximum number of
   * orders an account is allowed to have open on the exchange. Note that both
   * "algo" orders and normal orders are counted for this filter.
   */
  EXCHANGE_MAX_NUM_ORDERS,
  /**
   * The {@code EXCHANGE_MAX_NUM_ALGO_ORDERS} filter defines the maximum number of
   * "algo" orders an account is allowed to have open on the exchange. "Algo"
   * orders are {@code STOP_LOSS}, {@code STOP_LOSS_LIMIT}, {@code TAKE_PROFIT},
   * and {@code TAKE_PROFIT_LIMIT} orders.
   */
  EXCHANGE_MAX_NUM_ALGO_ORDERS,
}