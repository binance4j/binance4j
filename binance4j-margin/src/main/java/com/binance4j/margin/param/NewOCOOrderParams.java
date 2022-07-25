package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The {@link MarginClient#newOCO} params. */
public class NewOCOOrderParams extends Params {

	/** The order symbol */
	String symbol;
	/** The order side */
	OrderSide side;
	/** The order quantity */
	BigDecimal quantity;
	/** The order price */
	BigDecimal price;
	/** The stop price */
	BigDecimal stopPrice;
	/** The order response type Default: RESULT. */
	NewOrderResponseType newOrderRespType;
	/** A unique Id for the entire orderList */
	String listClientOrderId;
	/** A unique Id for the limit order */
	String limitClientOrderId;
	/** Used to make the LIMIT_MAKER leg an iceberg order. */
	@JsonProperty("limitIcebergQty")
	BigDecimal limitIcebergQuantity;
	/** A unique Id for the stop loss/stop loss limit leg */
	String stopClientOrderId;
	/** If provided, stopLimitTimeInForce is required. */
	BigDecimal stopLimitPrice;
	/** Used with STOP_LOSS_LIMIT leg to make an iceberg order. */
	@JsonProperty("stopIcebergQty")
	BigDecimal stopIcebergQuantity;
	/** Valid values are GTC/FOK/IOC */
	TimeInForce stopLimitTimeInForce;
	/** Is the order isolated? */
	Boolean isIsolated;

	/**
	 * Produces an OCO order
	 *
	 * @param symbol    The symbol the order is made on.
	 * @param side      The order side (BUY/SELL).
	 * @param quantity  The order quantity.
	 * @param price     The order price.
	 * @param stopPrice The stop price.
	 */
	public NewOCOOrderParams(String symbol, OrderSide side, BigDecimal quantity, BigDecimal price, BigDecimal stopPrice) {
		super(1);
		rateLimitType = RateLimitType.UID;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
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
	public BigDecimal getLimitIcebergQuantity() {
		return limitIcebergQuantity;
	}

	/**
	 * @param limitIcebergQuantity the limitIcebergQuantity to set
	 */
	public void setLimitIcebergQuantity(BigDecimal limitIcebergQuantity) {
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
	public BigDecimal getStopLimitPrice() {
		return stopLimitPrice;
	}

	/**
	 * @param stopLimitPrice the stopLimitPrice to set
	 */
	public void setStopLimitPrice(BigDecimal stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/**
	 * @return the stopIcebergQuantity
	 */
	public BigDecimal getStopIcebergQuantity() {
		return stopIcebergQuantity;
	}

	/**
	 * @param stopIcebergQuantity the stopIcebergQuantity to set
	 */
	public void setStopIcebergQuantity(BigDecimal stopIcebergQuantity) {
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

	/**
	 * @return the isIsolated
	 */
	public Boolean isIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
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
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the stopPrice
	 */
	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(BigDecimal stopPrice) {
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

}