package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The trading permissions of a symbol */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SymbolPermission {
    /** The symbol is available for SPOT trading */
    SPOT,
    /** The symbol is available for MARGIN trading */
    MARGIN,
    /** The symbol is available for LEVERAGED trading */
    LEVERAGED,
    /** ??? */
    TRD_GRP_002,
    /** ??? */
    TRD_GRP_003
}