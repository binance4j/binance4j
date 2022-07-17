package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The coin infos for the authenticated account */
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
		BigDecimal free,
		/** The freezed balance. */
		BigDecimal freeze,
		/** The Initial Public Offering balance (?) */
		BigDecimal ipoable,
		/** The Initial Public Offering freezed balance (?) */
		BigDecimal ipoing,
		/** The locked balance. */
		BigDecimal locked,
		/** ? */
		BigDecimal storage,
		/** The withdrawing balance. */
		BigDecimal withdrawing,
		/** The coin network information. */
		List<CoinNetworkInformation> networkList) {
}
