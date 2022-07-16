package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.margin.dto.IsolatedTransferAccount;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedTransferHistoryParams extends IntervalParams {
	private String asset;
	private String symbol;
	private IsolatedTransferAccount transFrom;
	private IsolatedTransferAccount transTo;
	/** Current page,default 1 */
	private Long current;
	/** Default 10, max 100 */
	private Integer size;
	private Boolean archived;

	public IsolatedTransferHistoryParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}
