package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.dto.IsolatedTransferType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewIsolatedTransferParams extends FramedParams {
	private String asset;
	private String symbol;
	private IsolatedTransferType transFrom;
	private IsolatedTransferType transTo;
	private BigDecimal amount;

	public NewIsolatedTransferParams(String asset, String symbol, IsolatedTransferType transFrom, IsolatedTransferType transTo, BigDecimal amount) {
		super(600);
		this.asset = asset;
		this.symbol = symbol;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.amount = amount;
	}
}
