package com.binance4j.spot.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to cancel an OCO request
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CancelOCOParams extends FramedParams {
	/** The symbol to cancel the order. */
	private String symbol;
	/** Either orderListId or listClientOrderId must be provided. */
	private Long orderListId;
	/** Either orderListId or listClientOrderId must be provided. */
	private String listClientOrderId;
	/**
	 * Used to uniquely identify this cancel. Automatically generated by
	 * default
	 */
	private String newClientOrderId;

	/** @param symbol The symbol to cancel the order. */
	public CancelOCOParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * @param symbol      The symbol to cancel the order
	 * @param orderListId The order list id
	 */
	public CancelOCOParams(String symbol, Long orderListId) {
		this(symbol);
		this.orderListId = orderListId;
	}

	/**
	 * @param symbol            The symbol to cancel the order
	 * @param listClientOrderId The list client order id
	 */
	public CancelOCOParams(String symbol, String listClientOrderId) {
		this(symbol);
		this.listClientOrderId = listClientOrderId;
	}
}
