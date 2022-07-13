package com.binance4j.spot.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request to retrieve a specific OCO based on provided optional parameters
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OCOInfoParams extends FramedParams {

	/**
	 * Either orderListId or origClientOrderId must be provided
	 */
	private Long orderListId;

	/**
	 * Either orderListId or origClientOrderId must be provided
	 */
	private String origClientOrderId;

	/**
	 * Constructor
	 *
	 * @param orderListId The order list id
	 */
	public OCOInfoParams(Long orderListId) {
		super(2);
		this.orderListId = orderListId;
	}

	/**
	 * Constructor
	 *
	 * @param origClientOrderId The origin client order id
	 */
	public OCOInfoParams(String origClientOrderId) {
		super(2);
		this.origClientOrderId = origClientOrderId;
	}
}
