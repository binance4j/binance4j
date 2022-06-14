package com.binance4j.spot.order;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request to fetch open OCO orders
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OpenOCORequest extends FramedRequest {
	public OpenOCORequest() {
		super(3);
	}
}
