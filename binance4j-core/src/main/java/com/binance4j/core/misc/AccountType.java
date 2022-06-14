package com.binance4j.core.misc;

/** The authenticated account type */
public enum AccountType {
    /** A SPOT trading account */
    SPOT,
    /** A MARGIN trading account */
    MARGIN,
    /** A LEVERAGED trading account */
    LEVERAGED,
    /** A TRD_GRP_002 trading account */
    TRD_GRP_002,
    /** A USDT futures trading account */
    USDT_FUTURE,
    /** A futures trading account */
    COIN_FUTURE;
}