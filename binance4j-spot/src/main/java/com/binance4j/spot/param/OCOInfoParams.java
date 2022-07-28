package com.binance4j.spot.param;

import com.binance4j.core.param.Params;

/** Request to retrieve a specific OCO based on provided optional parameters */
public class OCOInfoParams extends Params {
	/** Either orderListId or origClientOrderId must be provided. */
	Long orderListId;
	/** Either orderListId or origClientOrderId must be provided. */
	String origClientOrderId;

	/**
	 * @param orderListId The order list id.
	 */
	public OCOInfoParams(Long orderListId) {
		super(2);
		this.orderListId = orderListId;
	}

	/**
	 * @param origClientOrderId The origin client order id.
	 */
	public OCOInfoParams(String origClientOrderId) {
		super(2);
		this.origClientOrderId = origClientOrderId;
	}

	/**
	 * @return the orderListId
	 */
	public Long getOrderListId() {
		return orderListId;
	}

	/**
	 * @param orderListId the orderListId to set
	 */
	public void setOrderListId(Long orderListId) {
		this.orderListId = orderListId;
	}

	/**
	 * @return the origClientOrderId
	 */
	public String getOrigClientOrderId() {
		return origClientOrderId;
	}

	/**
	 * @param origClientOrderId the origClientOrderId to set
	 */
	public void setOrigClientOrderId(String origClientOrderId) {
		this.origClientOrderId = origClientOrderId;
	}

}
