package com.binance4j.wallet.dto;

/**
 * The Funding Wallet balance reflects a user's total crypto balance from P2P buy/sell orders, Binance Payment, Binance
 * Card and Crypto Deposit/Withdrawal.
 * 
 * @param asset        The asset abbreviation.
 * @param free         The available balancve.
 * @param locked       The locked balance (volume in the order book).
 * @param freeze       The freezed balance. Locked by binance (?)
 * @param withdrawing  The pending volume withdrawing.
 * @param btcValuation The value of the balance in BTC.
 */
public record FundingAsset(String asset, String free, String locked, String freeze, String withdrawing, String btcValuation) {
}