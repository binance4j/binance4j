package com.binance4j.wallet.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The request to obtain the system status */
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemStatusParams extends FramedParams {
	public SystemStatusParams() {
		super(1);
	}
}
