package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** [MarginClient.newOCO] params. */
@Param(type = RateLimitType.UID)
public class NewOCOOrderParams:Params
{
	/** The order symbol */
	String symbol;
	/** The order side */
	OrderSide side;
	/** The order quantity */
	String quantity;
	/** The order price */
	String price;
	/** The stop price */
	String stopPrice;
	/** The order response type Default: RESULT. */
	NewOrderResponseType newOrderRespType;
	/** A unique Id for the entire orderList */
	String listClientOrderId;
	/** A unique Id for the limit order */
	String limitClientOrderId;
	/** Used to make the LIMIT_MAKER leg an iceberg order. */
	String limitIcebergQty;
	/** A unique Id for the stop loss/stop loss limit leg */
	String stopClientOrderId;
	/** If provided, stopLimitTimeInForce is required. */
	String stopLimitPrice;
	/** Used with STOP_LOSS_LIMIT leg to make an iceberg order. */
	String stopIcebergQty;
	/** Valid values are GTC/FOK/IOC */
	TimeInForce stopLimitTimeInForce;
	/** Is the order isolated? */
	Boolean isIsolated;

	/**
	 * Produces an OCO order
	 *
	 * @param symbol    Symbol the order is made on.
	 * @param side      Order side (BUY/SELL).
	 * @param quantity  Order quantity.
	 * @param price     Order price.
	 * @param stopPrice Stop price.
	 */
	public NewOCOOrderParams(String symbol, OrderSide side, String quantity, String price, String stopPrice) {
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
	}

	/**
	 * - Produces an OCO order
	 *
	 * @param symbol               Symbol the order is made on.
	 * @param side                 Order side (BUY/SELL).
	 * @param quantity             Order quantity.
	 * @param price                Order price.
	 * @param stopPrice            Stop price.
	 * @param stopLimitPrice       Stop limit price.
	 * @param stopLimitTimeInForce Valid values are GTC/FOK/IOC.
	 */
	public NewOCOOrderParams(String symbol, OrderSide side, String quantity, String price, String stopPrice,
			String stopLimitPrice,
			TimeInForce stopLimitTimeInForce) {
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
		this.stopLimitPrice = stopLimitPrice;
		this.stopLimitTimeInForce = stopLimitTimeInForce;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol Symbol to set
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
	 * @param side Side to set
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
	 * @param quantity Quantity to set
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
	 * @param price Price to set
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
	 * @param stopPrice StopPrice to set
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
	 * @param newOrderRespType NewOrderRespType to set
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
	 * @param listClientOrderId ListClientOrderId to set
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
	 * @param limitClientOrderId LimitClientOrderId to set
	 */
	public void setLimitClientOrderId(String limitClientOrderId) {
		this.limitClientOrderId = limitClientOrderId;
	}

	/**
	 * @return the limitIcebergQty
	 */
	public String getLimitIcebergQty() {
		return limitIcebergQty;
	}

	/**
	 * @param limitIcebergQty LimitIcebergQty to set
	 */
	public void setLimitIcebergQty(String limitIcebergQty) {
		this.limitIcebergQty = limitIcebergQty;
	}

	/**
	 * @return the stopClientOrderId
	 */
	public String getStopClientOrderId() {
		return stopClientOrderId;
	}

	/**
	 * @param stopClientOrderId StopClientOrderId to set
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
	 * @param stopLimitPrice StopLimitPrice to set
	 */
	public void setStopLimitPrice(String stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/**
	 * @return the stopIcebergQty
	 */
	public String getStopIcebergQty() {
		return stopIcebergQty;
	}

	/**
	 * @param stopIcebergQty StopIcebergQty to set
	 */
	public void setStopIcebergQty(String stopIcebergQty) {
		this.stopIcebergQty = stopIcebergQty;
	}

	/**
	 * @return the stopLimitTimeInForce
	 */
	public TimeInForce getStopLimitTimeInForce() {
		return stopLimitTimeInForce;
	}

	/**
	 * @param stopLimitTimeInForce StopLimitTimeInForce to set
	 */
	public void setStopLimitTimeInForce(TimeInForce stopLimitTimeInForce) {
		this.stopLimitTimeInForce = stopLimitTimeInForce;
	}

	/**
	 * @return the isIsolated
	 */
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated IsIsolated to set
	 */
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}
}