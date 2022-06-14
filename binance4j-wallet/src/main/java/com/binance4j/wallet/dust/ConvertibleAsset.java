package com.binance4j.wallet.dust;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Asset that can be converted into BNB
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertibleAsset {
	/**
	 * The asset name
	 */
	private String asset;
	/**
	 * The asset full name
	 */
	private String assetFullName;
	/**
	 * The free balance
	 */
	private BigDecimal amountFree;
	/**
	 * The BTC valuation
	 */
	private BigDecimal toBTC;
	/**
	 * The BNB valuation
	 */
	private BigDecimal toBNB;
	/**
	 * The BNB valuation commissions fees deducted
	 */
	private BigDecimal toBNBOffExchange;
	/**
	 * Commission fees
	 */
	private BigDecimal exchange;
}
