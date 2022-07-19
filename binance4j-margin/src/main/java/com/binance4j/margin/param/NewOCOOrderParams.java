package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.OrderParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#newOCO} params. */
public class NewOCOOrderParams extends OrderParams {
	/** A unique Id for the entire orderList */
	private String listClientOrderId;
	/** A unique Id for the limit order */
	private String limitClientOrderId;
	/** Used to make the LIMIT_MAKER leg an iceberg order. */
	private BigDecimal limitIcebergQty;
	/** A unique Id for the stop loss/stop loss limit leg */
	private String stopClientOrderId;
	/** If provided, stopLimitTimeInForce is required. */
	private BigDecimal stopLimitPrice;
	/** Used with STOP_LOSS_LIMIT leg to make an iceberg order. */
	private BigDecimal stopIcebergQty;
	/** Valid values are GTC/FOK/IOC */
	private TimeInForce stopLimitTimeInForce;
	/** Is the order isolated? */
	private Boolean isIsolated;

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
		super(1, symbol, side, quantity);
		this.price = price;
		this.stopPrice = stopPrice;
	}

	/** @return the listClientOrderId */.
	public String getListClientOrderId() {
		return listClientOrderId;
	}

	/** @param listClientOrderId the listClientOrderId to set */.
	public void setListClientOrderId(String listClientOrderId) {
		this.listClientOrderId = listClientOrderId;
	}

	/** @return the limitClientOrderId */.
	public String getLimitClientOrderId() {
		return limitClientOrderId;
	}

	/** @param limitClientOrderId the limitClientOrderId to set */.
	public void setLimitClientOrderId(String limitClientOrderId) {
		this.limitClientOrderId = limitClientOrderId;
	}

	/** @return the limitIcebergQty */.
	public BigDecimal getLimitIcebergQty() {
		return limitIcebergQty;
	}

	/** @param limitIcebergQty the limitIcebergQty to set */.
	public void setLimitIcebergQty(BigDecimal limitIcebergQty) {
		this.limitIcebergQty = limitIcebergQty;
	}

	/** @return the stopClientOrderId */.
	public String getStopClientOrderId() {
		return stopClientOrderId;
	}

	/** @param stopClientOrderId the stopClientOrderId to set */.
	public void setStopClientOrderId(String stopClientOrderId) {
		this.stopClientOrderId = stopClientOrderId;
	}

	/** @return the stopLimitPrice */.
	public BigDecimal getStopLimitPrice() {
		return stopLimitPrice;
	}

	/** @param stopLimitPrice the stopLimitPrice to set */.
	public void setStopLimitPrice(BigDecimal stopLimitPrice) {
		this.stopLimitPrice = stopLimitPrice;
	}

	/** @return the stopIcebergQty */.
	public BigDecimal getStopIcebergQty() {
		return stopIcebergQty;
	}

	/** @param stopIcebergQty the stopIcebergQty to set */.
	public void setStopIcebergQty(BigDecimal stopIcebergQty) {
		this.stopIcebergQty = stopIcebergQty;
	}

	/** @return the stopLimitTimeInForce */.
	public TimeInForce getStopLimitTimeInForce() {
		return stopLimitTimeInForce;
	}

	/** @param stopLimitTimeInForce the stopLimitTimeInForce to set */.
	public void setStopLimitTimeInForce(TimeInForce stopLimitTimeInForce) {
		this.stopLimitTimeInForce = stopLimitTimeInForce;
	}

	/** @return the isIsolated */.
	public Boolean isIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */.
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

}