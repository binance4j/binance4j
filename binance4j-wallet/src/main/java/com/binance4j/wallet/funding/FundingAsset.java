package com.binance4j.wallet.funding;

import java.math.BigDecimal;

import lombok.Data;

/**
 * The Funding Wallet balance reflects a user's total crypto balance from P2P
 * buy/sell orders, Binance Payment, Binance Card and Crypto Deposit/Withdrawal
 */
@Data
public class FundingAsset {
    /**
     * The asset abbreviation
     */
    private String asset;
    /**
     * The available balancve
     */
    private BigDecimal free;
    /**
     * The locked balance (volume in the order book)
     */
    private BigDecimal locked;
    /**
     * The freezed balance. Locked by binance (?)
     */
    private BigDecimal freeze;
    /**
     * The pending volume withdrawing
     */
    private BigDecimal withdrawing;
    /**
     * The value of the balance in BTC
     */
    private BigDecimal btcValuation;
}