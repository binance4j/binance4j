package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetMarginOCOParams extends FramedParams {
	private Boolean isIsolated;
	/** mandatory for isolated margin, not supported for cross margin. */
	private String symbol;
	/** Either orderListId or origClientOrderId must be provided. */
	private Long orderListId;
	/** Either orderListId or origClientOrderId must be provided. */
	private String origClientOrderId;

	public GetMarginOCOParams() {
		super(10);
	}
}
