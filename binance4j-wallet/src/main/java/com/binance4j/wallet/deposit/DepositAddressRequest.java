package com.binance4j.wallet.deposit;

import com.binance4j.core.request.FramedRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get a coin deposit address
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepositAddressRequest extends FramedRequest {
	/**
	 * The coin abbreviation
	 */
	private String coin;
	/**
	 * The transfer network
	 */
	private String network;

	/**
	 * Default constructor
	 *
	 * @param coin The coin we need the address
	 */
	public DepositAddressRequest(String coin) {
		super(10);
		this.coin = coin;
	}

	/**
	 * Constructor
	 *
	 * @param coin    The coin we need the address
	 * @param network The transfer network
	 */
	public DepositAddressRequest(String coin, String network) {
		this(coin);
		this.network = network;
	}
}
