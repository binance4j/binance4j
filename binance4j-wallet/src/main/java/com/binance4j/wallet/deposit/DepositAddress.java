package com.binance4j.wallet.deposit;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * A deposit address for a given asset.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositAddress {
	/**
	 * The deposit url
	 */
	private String url;
	/**
	 * The deposit address
	 */
	private String address;
	/**
	 * The deposit tag
	 */
	private String tag;
	/**
	 * The coin abbreviation
	 */
	private String coin;
}