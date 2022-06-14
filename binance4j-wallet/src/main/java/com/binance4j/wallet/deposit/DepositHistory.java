package com.binance4j.wallet.deposit;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** A deposit history */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositHistory {
	/**
	 * The volume to deposit
	 */
	private BigDecimal amount;
	/**
	 * The coin abbreviation
	 */
	private String coin;
	/**
	 * The transfer network
	 */
	private String network;
	/**
	 * The deposit address
	 */
	private String address;
	/**
	 * The deposit address tag
	 */
	private String addressTag;
	/**
	 * The transaction id
	 */
	private String txId;
	/**
	 * confirm times for unlocking
	 */
	private String unlockConfirm;
	/**
	 * ???
	 */
	private String confirmTimes;
	/**
	 * The withdraw status
	 */
	private Integer status;
	/**
	 * confirm times for insertion (?)
	 */
	private Long insertTime;
	/**
	 * The transfer type. 1 for internal transfer, 0 for external transfer
	 */
	private Integer transferType;
}
