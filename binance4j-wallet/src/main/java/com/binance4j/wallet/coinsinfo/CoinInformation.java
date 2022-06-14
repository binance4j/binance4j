package com.binance4j.wallet.coinsinfo;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The coin informations for the authenticated account */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinInformation {
	/**
	 * The coin abbreviation
	 */
	private String coin;
	/**
	 * The coin name
	 */
	private String name;
	/**
	 * The deposit permission
	 */
	private Boolean depositAllEnable;
	/**
	 * if the coin is a legal money
	 */
	private Boolean isLegalMoney;
	/**
	 * if the coin can be traded
	 */
	private Boolean trading;
	/**
	 * The withdraw permission
	 */
	private Boolean withdrawAllEnable;
	/**
	 * The free balance
	 */
	private BigDecimal free;
	/**
	 * The freezed balance
	 */
	private BigDecimal freeze;
	/**
	 * The Initial Public Offering balance (?)
	 */
	private BigDecimal ipoable;
	/**
	 * The Initial Public Offering freezed balance (?)
	 */
	private BigDecimal ipoing;
	/**
	 * The locked balance
	 */
	private BigDecimal locked;
	/**
	 * ?
	 */
	private BigDecimal storage;
	/**
	 * The withdrawing balance
	 */
	private BigDecimal withdrawing;
	/**
	 * The coin network information
	 */
	private List<CoinNetworkInformation> networkList;
}
