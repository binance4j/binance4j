package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** The parameters to get a coin deposit address */
@Param(weight = 10)
public class DepositAddressParams implements Params {
	/** The coin abbreviation. */
	@Mandatory
	String coin;
	/** The transfer network. */
	String network;

	/**
	 * @param coin The coin we need the address.
	 */
	public DepositAddressParams(String coin) {
		this.coin = coin;
	}

	/**
	 * @param coin    The coin we need the address.
	 * @param network The transfer network.
	 */
	public DepositAddressParams(String coin, String network) {
		this(coin);
		this.network = network;
	}

	/**
	 * @return the coin
	 */
	public String getCoin() {
		return coin;
	}

	/**
	 * @param coin the coin to set
	 */
	public void setCoin(String coin) {
		this.coin = coin;
	}

	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

}
