package com.binance4j.spot.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@link SpotClient#newOCO} params.
 */
@Param(weight = 2, isOrder = true, type = RateLimitType.UID_AND_IP)
public class NewOCOOrderParams implements Params {
	/** The order symbol */
	@Mandatory
	String symbol;
	/** The order side */
	@Mandatory
	OrderSide side;
	/** The order quantity */
	@Mandatory
	String quantity;
	/** The order price */
	@Mandatory
	String price;
	/** The stop price */
	@Mandatory
	String stopPrice;
	/** The order response type Default: RESULT. */
	protected NewOrderResponseType newOrderRespType;
	/** A unique Id for the entire orderList */
	String listClientOrderId;
	/** A unique Id for the limit order */
	String limitClientOrderId;
	/** Used to make the LIMIT_MAKER leg an iceberg order. */
	@JsonProperty("limitIcebergQty")
	String limitIcebergQuantity;
	/** A unique Id for the stop loss/stop loss limit leg */
	String stopClientOrderId;
	/** If provided, stopLimitTimeInForce is required. */
	String stopLimitPrice;
	/** Used with STOP_LOSS_LIMIT leg to make an iceberg order. */
	@JsonProperty("stopIcebergQty")
	String stopIcebergQuantity;
	/** Valid values are GTC/FOK/IOC */
	TimeInForce stopLimitTimeInForce;

	/**
	 * - Produces an OCO order
	 *
	 * @param symbol    The symbol the order is made on.
	 * @param side      The order side (BUY/SELL).
	 * @param quantity  The order quantity.
	 * @param price     The order price.
	 * @param stopPrice The stop price.
	 */
	public NewOCOOrderParams(String symbol, OrderSide side, String quantity, String price, String stopPrice) {
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the side
	 */
	public OrderSide getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(OrderSide side) {
		this.side = side;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the stopPrice
	 */
	public String getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(String stopPrice) {
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the newOrderRespType
	 */
	public NewOrderResponseType getNewOrderRespType() {
		return newOrderRespType;
	}

	/**
	 * @param newOrderRespType the newOrderRespType to set
	 */
	public void setNewOrderRespType(NewOrderResponseType newOrderRespType) {
		this.newOrderRespType = newOrderRespType;
	}

	/**
	 * @return the listClientOrderId
	 */
	public String getListClientOrderId() {
		return listClientOrderId;
	}

	/**
	 * @param listClientOrderId the listClientOrderId to set
	 */
	public void setListClientOrderId(String listClientOrderId) {
		this.listClientOrderId = listClientOrderId;
	}

	/**
	 * @return the limitClientOrderId
	 */
	public String getLimitClientOrderId() {
		return limitClientOrderId;
	}

	/**
	 * @param limitClientOrderId the limitClientOrderId to set
	 */
	public void setLimitClientOrderId(String limitClientOrderId) {
		this.limitClientOrderId = limitClientOrderId;
	}

	/**
	 * @return the limitIcebergQuantity
	 */
	public String getLimitIcebergQuantity() {
		return limitIcebergQuantity;
	}

	/**
	 * @param limitIcebergQuantity the limitIcebergQuantity to set
	 */
	public void setLimitIcebergQuantity(String limitIcebergQuantity) {
		this.limitIcebergQuantity = limitIcebergQuantity;
	}

	/**
	 * @return the stopClientOrderId
	 */
	public String getStopClientOrderId() {
		return stopClientOrderId;
	}

	/**
	 * @param stopClientOrderId the stopClientOrderId to set
	 */
	public void setStopClientOrderId(String stopClientOrderId) {
		this.stopClientOrderId = stopClientOrderId;
	}

	/**
	 * @return the stopLimitPrice
	 */
	public String getStopLimitPrice() {
		return stopLimitPrice;
	}

	/**
	 * @param stopLimitPrice the stopLimitPrice to set
	 */
	public void setStopLimitPrice(String stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/**
	 * @return the stopIcebergQuantity
	 */
	public String getStopIcebergQuantity() {
		return stopIcebergQuantity;
	}

	/**
	 * @param stopIcebergQuantity the stopIcebergQuantity to set
	 */
	public void setStopIcebergQuantity(String stopIcebergQuantity) {
		this.stopIcebergQuantity = stopIcebergQuantity;
	}

	/**
	 * @return the stopLimitTimeInForce
	 */
	public TimeInForce getStopLimitTimeInForce() {
		return stopLimitTimeInForce;
	}

	/**
	 * @param stopLimitTimeInForce the stopLimitTimeInForce to set
	 */
	public void setStopLimitTimeInForce(TimeInForce stopLimitTimeInForce) {
		this.stopLimitTimeInForce = stopLimitTimeInForce;
	}
}