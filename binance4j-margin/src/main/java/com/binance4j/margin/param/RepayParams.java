package com.binance4j.margin.param;

import java.math.BigDecimal;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/** The {@link MarginClient#repay} params. */
@Data
@EqualsAndHashCode(callSuper = true)
public class RepayParams extends FramedParams {
	/** The asset to repay. */
	private String asset;
	/** The isolated symbol. */
	private String symbol;
	/** For isolated margin or not. Default {@code false}. */
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private Boolean isIsolated;
	/** The amount to repay. */
	private BigDecimal amount;

	public RepayParams(String asset, BigDecimal amount) {
		super(300);
		this.asset = asset;
		this.amount = amount;
	}

	/**
	 * Isolated margin repay
	 * 
	 * @param symbol isolated symbol
	 */
	public void isIsolated(String symbol) {
		this.isIsolated = true;
		this.symbol = symbol;
	}

	/** Crossed margin repay. */
	public void isNotIsolated() {
		this.isIsolated = false;
		this.symbol = null;
	}

	public Boolean isIsolated() {
		return isIsolated;
	}
}