package com.binance4j.wallet.dust;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Details about an asset dust trasnfer (convertion into BNB)
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustTransferResult {
	/**
	 * The amount of volume converted
	 */
	private BigDecimal amount;
	/**
	 * The converted asset abbreviation
	 */
	private String fromAsset;
	/**
	 * The operation timestamp
	 */
	private Long operateTime;
	/**
	 * The fees
	 */
	private BigDecimal serviceChargeAmount;
	/**
	 * The transaction id
	 */
	private Long tranId;
	/**
	 * The transfered amount after fees
	 */
	private BigDecimal transferedAmount;
}