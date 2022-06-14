package com.binance4j.core.misc;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** An asset on binance */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {
	/**
	 * The asset id
	 */
	private String id;
	/**
	 * The asset abbreviation
	 */
	private String assetCode;
	/**
	 * The asset full name
	 */
	private String assetName;
	/**
	 * ???
	 */
	private String unit;
	/**
	 * The cost of a transaction
	 */
	private BigDecimal transactionFee;
	/**
	 * The payment associated with a certain amount of sale
	 */
	private BigDecimal commissionRate;
	/**
	 * ???
	 */
	private BigDecimal freeAuditWithdrawAmount;
	/**
	 * ???
	 */
	private BigDecimal freeUserChargeAmount;
	/**
	 * The minimal amount you can withdraw
	 */
	private BigDecimal minProductWithdraw;
	/**
	 * The smallest withdraw multiple
	 */
	private BigDecimal withdrawIntegerMultiple;
	/**
	 * the time elapsed between the moment a blockchain transaction is
	 * submitted to the network and the time it is finally recorded into a
	 * confirmed block
	 */
	private Long confirmTimes;
	/**
	 * is the withdrawal of the asset enabled
	 */
	private Boolean enableWithdraw;
	/**
	 * is it issued by a government
	 */
	private Boolean isLegalMoney;
}