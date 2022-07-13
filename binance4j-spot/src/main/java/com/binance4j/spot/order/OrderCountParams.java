package com.binance4j.spot.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to display the user's current order count usage for all
 * intervals.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCountParams extends FramedParams {
	/**
	 * Default constructor
	 */
	public OrderCountParams() {
		super(20);
	}
}
