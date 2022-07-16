package com.binance4j.spot.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to fetch open OCO orders */
@Data
@EqualsAndHashCode(callSuper = true)
public class OpenOCOParams extends FramedParams {
	public OpenOCOParams() {
		super(3);
	}
}
