package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.dto.IsolatedTransferAccount;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewIsolatedTransferParams extends FramedParams {
	private String asset;
	private String symbol;
	private IsolatedTransferAccount transFrom;
	private IsolatedTransferAccount transTo;
	private BigDecimal amount;

	public NewIsolatedTransferParams(String asset, String symbol, IsolatedTransferAccount transFrom, IsolatedTransferAccount transTo, BigDecimal amount) {
		super(600);
		this.asset = asset;
		this.symbol = symbol;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.amount = amount;
	}
}
