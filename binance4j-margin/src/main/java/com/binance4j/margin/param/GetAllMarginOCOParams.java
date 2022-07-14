package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllMarginOCOParams extends IntervalParams {
	private Boolean isIsolated;
	/** mandatory for isolated margin, not supported for cross margin. */
	private String symbol;
	/** If supplied, neither startTime or endTime can be provided. */
	private Long fromId;
	/** Default Value: 500; Max Value: 1000 */
	private Integer limit;

	public GetAllMarginOCOParams() {
		super(200);
	}
}
