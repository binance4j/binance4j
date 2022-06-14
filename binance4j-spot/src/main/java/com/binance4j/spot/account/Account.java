package com.binance4j.spot.account;

import com.binance4j.core.account.AssetBalance;
import com.binance4j.core.misc.AccountType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * The SPOT account information
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
	/**
	 * The maker commission
	 */
	private BigDecimal makerCommission;
	/**
	 * The taker commission
	 */
	private BigDecimal takerCommission;
	/**
	 * The buyer commission
	 */
	private BigDecimal buyerCommission;
	/**
	 * The seller commission
	 */
	private BigDecimal sellerCommission;
	/**
	 * The trade permission
	 */
	private Boolean canTrade;
	/**
	 * The withdrawal permission
	 */
	private Boolean canWithdraw;
	/**
	 * The deposit permission
	 */
	private Boolean canDeposit;
	/**
	 * The timestamp of the last data update
	 */
	private Long updateTime;
	/**
	 * The balances of each asset in the SPOT wallet
	 */
	private List<AssetBalance> balances;
	/**
	 * The account Type (SPOT)
	 */
	private AccountType accountType;
	/**
	 * The permissions list (SPOT)
	 */
	private List<AccountType> permissions;
}
