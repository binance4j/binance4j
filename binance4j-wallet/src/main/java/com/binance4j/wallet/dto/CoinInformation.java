package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/** The coin informations for the authenticated account */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinInformation {
	/** The coin abbreviation. */
	private String coin;
	/** The coin name. */
	private String name;
	/** The deposit permission. */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean depositAllEnable;
	/** if the coin is a legal money. */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isLegalMoney;
	/** if the coin can be traded. */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean trading;
	/** The withdraw permission. */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean withdrawAllEnable;
	/** The free balance. */
	private BigDecimal free;
	/** The freezed balance. */
	private BigDecimal freeze;
	/** The Initial Public Offering balance (?) */
	private BigDecimal ipoable;
	/** The Initial Public Offering freezed balance (?) */
	private BigDecimal ipoing;
	/** The locked balance. */
	private BigDecimal locked;
	/** ? */
	private BigDecimal storage;
	/** The withdrawing balance. */
	private BigDecimal withdrawing;
	/** The coin network information. */
	private List<CoinNetworkInformation> networkList;

	public Boolean isDepositAllEnable() {
		return depositAllEnable;
	}

	public void isDepositAllEnable(boolean enabled) {
		this.depositAllEnable = enabled;
	}

	public Boolean isLegalMoney() {
		return isLegalMoney;
	}

	public void isLegalMoney(boolean isLegalMoney) {
		this.isLegalMoney = isLegalMoney;
	}

	public Boolean isTrading() {
		return trading;
	}

	public void isTrading(boolean trading) {
		this.trading = trading;
	}

	public Boolean isWithdrawAllEnable() {
		return withdrawAllEnable;
	}

	public void isWithdrawAllEnable(boolean withdrawAllEnable) {
		this.withdrawAllEnable = withdrawAllEnable;
	}
}
