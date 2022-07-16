package com.binance4j.wallet.param;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The parameters to get a coin deposit address */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepositAddressParams extends FramedParams {
	/** The coin abbreviation. */
	private String coin;
	/** The transfer network. */
	private String network;

	/**
	 * Default constructor
	 *
	 * @param coin The coin we need the address
	 */
	public DepositAddressParams(String coin) {
		super(10);
		this.coin = coin;
	}

	/**
	 *
	 * 
	 * @param coin    The coin we need the address
	 * @param network The transfer network
	 */
	public DepositAddressParams(String coin, String network) {
		this(coin);
		this.network = network;
	}
}
