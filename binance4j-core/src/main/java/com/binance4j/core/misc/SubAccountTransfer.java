package com.binance4j.core.misc;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

// TODO transfer to sub account module when created
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountTransfer {
	/**
	 * Counter party name
	 */
	private String counterParty;
	/**
	 * Counter party email
	 */
	private String email;
	/**
	 * Transfer in or transfer out
	 */
	private int type; // 1 for transfer in; 2 for transfer out
	/**
	 * Transfer asset
	 */
	private String asset;
	/**
	 * Quantity of transfer asset
	 */
	private String qty;
	/**
	 * Type of from account
	 */
	private String fromAccountType;
	/**
	 * Type of to account
	 */
	private String toAccountType;
	/**
	 * Transfer status
	 */
	private String status;
	/**
	 * Transfer ID
	 */
	private long tranId;
	/**
	 * Transfer time
	 */
	private long time;
}