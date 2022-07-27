package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The coin infos for the authenticated account.
 * 
 * @param coin              The coin abbreviation.
 * @param name              The coin name.
 * @param depositAllEnable  The deposit permission.
 * @param isLegalMoney      if the coin is a legal money.
 * @param trading           if the coin can be traded.
 * @param withdrawAllEnable The withdraw permission.
 * @param free              The free balance.
 * @param freeze            The freezed balance.
 * @param ipoable           The Initial Public Offering balance (?)
 * @param ipoing            The Initial Public Offering freezed balance (?)
 * @param locked            The locked balance.
 * @param storage           The storage
 * @param withdrawing       The withdrawing balance.
 * @param networkList       The coin network information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CoinInformation(
		/** The coin abbreviation. */
		String coin,
		/** The coin name. */
		String name,
		/** The deposit permission. */
		boolean depositAllEnable,
		/** if the coin is a legal money. */
		boolean isLegalMoney,
		/** if the coin can be traded. */
		boolean trading,
		/** The withdraw permission. */
		boolean withdrawAllEnable,
		/** The free balance. */
		String free,
		/** The freezed balance. */
		String freeze,
		/** The Initial Public Offering balance (?) */
		String ipoable,
		/** The Initial Public Offering freezed balance (?) */
		String ipoing,
		/** The locked balance. */
		String locked,
		/** The storage */
		String storage,
		/** The withdrawing balance. */
		String withdrawing,
		/** The coin network information. */
		List<CoinNetworkInformation> networkList) {
}
