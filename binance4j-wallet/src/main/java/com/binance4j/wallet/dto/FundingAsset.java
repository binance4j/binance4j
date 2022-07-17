package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * The Funding Wallet balance reflects a user's total crypto balance from P2P buy/sell orders, Binance Payment, Binance
 * Card and Crypto Deposit/Withdrawal
 */
@Data
public record FundingAsset(
		/** The asset abbreviation. */
		String asset,
		/** The available balancve. */
		BigDecimal free,
		/** The locked balance (volume in the order book). */
		BigDecimal locked,
		/** The freezed balance. Locked by binance (?) */
		BigDecimal freeze,
		/** The pending volume withdrawing. */
		BigDecimal withdrawing,
		/** The value of the balance in BTC. */
		BigDecimal btcValuation) {
}